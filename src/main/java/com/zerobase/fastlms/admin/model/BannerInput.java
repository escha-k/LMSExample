package com.zerobase.fastlms.admin.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
public class BannerInput {

    String name;
    String url;
    String alterText;
    String target;
    Integer sortOrder;
    Boolean isPublic;
    LocalDateTime regDt;
    MultipartFile file;
}
