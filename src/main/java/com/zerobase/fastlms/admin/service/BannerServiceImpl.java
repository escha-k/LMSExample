package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.entity.Banner;
import com.zerobase.fastlms.admin.mapper.BannerMapper;
import com.zerobase.fastlms.admin.model.BannerInput;
import com.zerobase.fastlms.admin.model.BannerParam;
import com.zerobase.fastlms.admin.repository.BannerRepository;
import com.zerobase.fastlms.util.ImageUploadUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
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
                .isPublic(parameter.getIsPublic())
                .build();

        bannerRepository.save(banner);
    }

    @Override
    public void updateBanner(BannerInput parameter) {
        bannerMapper.shiftSortOrder(parameter.getSortOrder());

        Banner banner = bannerRepository.findById(parameter.getName())
                .orElseThrow(NoSuchElementException::new);

        if (!parameter.getFile().isEmpty()) {
            banner.setImage(ImageUploadUtil.upload(parameter.getFile()));
        }
        banner.setUrl(parameter.getUrl());
        banner.setAlterText(parameter.getAlterText());
        banner.setTarget(parameter.getTarget());
        banner.setSortOrder(parameter.getSortOrder());
        banner.setPublic(parameter.getIsPublic());

        bannerRepository.save(banner);
    }

    @Override
    public void deleteBannersByName(List<String> list) {
        bannerRepository.deleteAllByIdInBatch(list);
    }

    public BannerDto getBanner(String id) {
        Banner banner = bannerRepository.findById(id).orElseThrow(NoSuchElementException::new);

        return BannerDto.of(banner);
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
