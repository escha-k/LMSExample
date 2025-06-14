package com.zerobase.fastlms.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class LoginHistoryDto {

    String userId;
    String ip;
    String userAgent;
    LocalDateTime loginDt;

    long seq;

    public String getLoginDtText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return loginDt != null ? loginDt.format(formatter) : "";
    }
}
