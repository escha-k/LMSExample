package com.zerobase.fastlms.admin.controller;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.model.BannerInput;
import com.zerobase.fastlms.admin.model.BannerParam;
import com.zerobase.fastlms.admin.service.BannerService;
import com.zerobase.fastlms.course.controller.BaseController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AdminBannerController extends BaseController {

    private final BannerService bannerService;

    @GetMapping("/admin/banner/list.do")
    public String list(Model model, BannerParam parameter) {

        parameter.init();

        List<BannerDto> list = bannerService.getBanners(parameter);
        long totalCount = list.size();
        String pagerHtml = getPaperHtml(totalCount, parameter.getPageSize(), parameter.getPageIndex(), "");

        model.addAttribute("list", list);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pager", pagerHtml);

        return "admin/banner/list";
    }

    @GetMapping("/admin/banner/add.do")
    public String add() {

        return "admin/banner/add";
    }

    @PostMapping("/admin/banner/upload.do")
    public String add(BannerInput parameter) {

        log.info("isPublic: {}", parameter.getIsPublic());
        bannerService.saveBanner(parameter);

        return "redirect:/admin/banner/list.do";
    }

    @GetMapping("/admin/banner/update.do")
    public String update(Model model, BannerParam parameter) {

        String name = parameter.getName();
        BannerDto banner = bannerService.getBanner(name);

        model.addAttribute("banner", banner);

        return "admin/banner/update";
    }

    @PostMapping("/admin/banner/update.do")
    public String update(BannerInput parameter) {

        bannerService.updateBanner(parameter);

        return "redirect:/admin/banner/list.do";
    }

    @PostMapping("/admin/banner/delete.do")
    public String delete(@RequestParam("deleteList") List<String> list) {

        bannerService.deleteBannersByName(list);

        return "redirect:/admin/banner/list.do";
    }
}
