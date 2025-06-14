package com.zerobase.fastlms.member.service;

import com.zerobase.fastlms.admin.dto.LoginHistoryDto;

import java.util.List;

public interface LoginHistoryService {

    void saveHistory(LoginHistoryDto loginHistoryDto);

    List<LoginHistoryDto> getHistoryByUserId(String userId);
}
