package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.model.BannerInput;
import com.zerobase.fastlms.admin.model.BannerParam;

import java.util.List;

public interface BannerService {

    void saveBanner(BannerInput banner);

    void updateBanner(BannerInput banner);

    void deleteBannersByName(List<String> list);

    BannerDto getBanner(String id);

    List<BannerDto> getBanners(BannerParam parameter);

    List<BannerDto> getPublicBanners();
}
