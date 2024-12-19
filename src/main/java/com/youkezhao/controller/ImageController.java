package com.youkezhao.controller;

import com.youkezhao.entity.Image;
import com.youkezhao.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    // 获取某个景点的所有图片
    @GetMapping("/attraction/{attractionId}")
    public List<Image> getImagesByAttractionId(@PathVariable Long attractionId) {
        return imageService.getImagesByAttractionId(attractionId);
    }

    // 获取某个区域的所有图片
    @GetMapping("/region/{regionId}")
    public List<Image> getImagesByRegionId(@PathVariable Long regionId) {
        return imageService.getImagesByRegionId(regionId);
    }
}
