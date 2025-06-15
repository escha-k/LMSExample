package com.zerobase.fastlms.admin.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BannerInput {

    String name;
    String url;
    String alterText;
    String target;
    Integer sortOrder;
    boolean isPublic;
    MultipartFile file;

}
