package com.zerobase.fastlms.member.service.impl;

import com.zerobase.fastlms.admin.dto.LoginHistoryDto;
import com.zerobase.fastlms.admin.mapper.LoginHistoryMapper;
import com.zerobase.fastlms.member.entity.LoginHistory;
import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.repository.LoginHistoryRepository;
import com.zerobase.fastlms.member.repository.MemberRepository;
import com.zerobase.fastlms.member.service.LoginHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LoginHistoryServiceImpl implements LoginHistoryService {

    private final MemberRepository memberRepository;
    private final LoginHistoryRepository loginHistoryRepository;

    private final LoginHistoryMapper loginHistoryMapper;

    @Override
    public void saveHistory(LoginHistoryDto loginHistoryDto) {

        String userId = loginHistoryDto.getUserId();
        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("회원 정보가 존재하지 않습니다."));

        LoginHistory loginHistory = LoginHistory.builder()
                .member(member)
                .ip(loginHistoryDto.getIp())
                .userAgent(loginHistoryDto.getUserAgent())
                .loginDt(loginHistoryDto.getLoginDt())
                .build();

        loginHistoryRepository.save(loginHistory);
    }

    @Override
    public List<LoginHistoryDto> getHistoryByUserId(String userId) {

        List<LoginHistoryDto> list = loginHistoryMapper.selectLoginHistoryByUserId(userId);
        if (!list.isEmpty()) {
            int i = 0;
            for (LoginHistoryDto e : list) {
                e.setSeq(++i);
            }
        }

        return list;
    }
}
