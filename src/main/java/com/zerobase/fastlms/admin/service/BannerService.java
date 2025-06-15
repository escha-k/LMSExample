package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.model.BannerInput;
import com.zerobase.fastlms.admin.model.BannerParam;

import java.util.List;

public interface BannerService {

    public void saveBanner(BannerInput banner);

    void deleteBannersByName(List<String> list);

    public BannerDto getBanner(String id);

    public List<BannerDto> getBanners(BannerParam parameter);

    public List<BannerDto> getPublicBanners();
}
