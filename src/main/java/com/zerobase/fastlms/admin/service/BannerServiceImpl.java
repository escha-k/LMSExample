package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.entity.Banner;
import com.zerobase.fastlms.admin.mapper.BannerMapper;
import com.zerobase.fastlms.admin.model.BannerInput;
import com.zerobase.fastlms.admin.model.BannerParam;
import com.zerobase.fastlms.admin.repository.BannerRepository;
import com.zerobase.fastlms.util.ImageUploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BannerServiceImpl implements BannerService {

    private final BannerRepository bannerRepository;
    private final BannerMapper bannerMapper;

    @Override
    public void saveBanner(BannerInput parameter) {
        bannerMapper.shiftSortOrder(parameter.getSortOrder());

        String image = ImageUploadUtil.upload(parameter.getFile());

        Banner banner = Banner.builder()
                .name(parameter.getName())
                .image(image)
                .url(parameter.getUrl())
                .alterText(parameter.getAlterText())
                .target(parameter.getTarget())
                .sortOrder(parameter.getSortOrder())
                .isPublic(parameter.isPublic())
                .build();

        bannerRepository.save(banner);
    }

    @Override
    public void updateBanner(BannerInput banner) {

    }

    @Override
    public void deleteBanners(BannerInput banner) {

    }

    @Override
    public List<BannerDto> getBanners(BannerParam parameter) {

        List<BannerDto> list = bannerMapper.selectAll(parameter);
        if (!list.isEmpty()) {
            int i = 0;
            for (BannerDto e : list) {
                e.setSeq(++i);
            }
        }

        return list;
    }

    @Override
    public List<BannerDto> getPublicBanners() {

        return bannerMapper.selectPublic();
    }
}
