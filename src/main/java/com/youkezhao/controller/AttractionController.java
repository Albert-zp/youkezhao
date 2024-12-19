package com.youkezhao.controller;

import com.youkezhao.entity.Attraction;
import com.youkezhao.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/attractions")
public class AttractionController {

    private final AttractionService attractionService;

    @Autowired
    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    // 获取所有景点
    @GetMapping("/api/attractions")
    public List<Attraction> getAllAttractions() {
        return attractionService.getAllAttractions();
    }

    // 根据地区ID获取景点
    @GetMapping("/region/{regionId}")
    public List<Attraction> getAttractionsByRegion(@PathVariable Long regionId) {
        return attractionService.getAttractionsByRegion(regionId);
    }
}
