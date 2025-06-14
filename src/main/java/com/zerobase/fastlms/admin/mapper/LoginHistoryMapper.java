package com.zerobase.fastlms.admin.mapper;

import com.zerobase.fastlms.admin.dto.LoginHistoryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginHistoryMapper {

    List<LoginHistoryDto> selectLoginHistoryByUserId(String userId);
}
