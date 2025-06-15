package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.admin.entity.Banner;
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
public class BannerDto {

    String name;
    String image;
    String alterText;
    String url;
    String target;
    Integer sortOrder;
    boolean isPublic;
    LocalDateTime regDt;

    long seq;

    public static BannerDto of(Banner banner) {

        return BannerDto.builder()
                .name(banner.getName())
                .image(banner.getImage())
                .alterText(banner.getAlterText())
                .url(banner.getUrl())
                .target(banner.getTarget())
                .sortOrder(banner.getSortOrder())
                .isPublic(banner.isPublic())
                .regDt(banner.getRegDt())
                .build();
    }

    public String getRegDtText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return regDt != null ? regDt.format(formatter) : "";
    }
}
