package com.zerobase.fastlms.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class ImageUploadUtil {

    private static final String DIR = "banners";

    public static String upload(MultipartFile image) {

        if (image == null || image.isEmpty()) {
            return null;
        }

        try {
            String fileName = image.getOriginalFilename();

            int extIndex = fileName.lastIndexOf(".");
            String extension = extIndex == -1 ? "" : fileName.substring(extIndex);

            String uuid = UUID.randomUUID().toString().replace("-", "");

            String savedFileName = uuid + extension;

            File savedDir = new File(DIR);
            if (!savedDir.exists()) {
                savedDir.mkdirs();
            }

            Path savedPath = Paths.get(DIR, savedFileName);
            image.transferTo(savedPath);

            return DIR + "/" + savedFileName;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
