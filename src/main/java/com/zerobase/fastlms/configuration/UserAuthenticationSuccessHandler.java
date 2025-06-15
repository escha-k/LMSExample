package com.zerobase.fastlms.configuration;

import com.zerobase.fastlms.admin.dto.LoginHistoryDto;
import com.zerobase.fastlms.member.service.LoginHistoryService;
import com.zerobase.fastlms.member.service.MemberService;
import com.zerobase.fastlms.util.RequestUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class UserAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final MemberService memberService;
    private final LoginHistoryService loginHistoryService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        Object principal = authentication.getPrincipal();
        UserDetails userDetails = (UserDetails) principal;

        String userId = userDetails.getUsername();
        LocalDateTime now = LocalDateTime.now();
        String userAgent = RequestUtils.getUserAgent(request);
        LoginHistoryDto loginHistoryDto = LoginHistoryDto.builder()
                .userId(userId)
                .userAgent(userAgent)
                .ip(RequestUtils.getIpAddr(request))
                .loginDt(LocalDateTime.now())
                .build();

        loginHistoryService.saveHistory(loginHistoryDto);
        memberService.updateLastLoginDt(userId, now);

        response.sendRedirect("/");
    }
}
