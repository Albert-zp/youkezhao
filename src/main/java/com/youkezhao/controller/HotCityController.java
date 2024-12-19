package com.youkezhao.controller;

import com.youkezhao.entity.HotCity;
import com.youkezhao.service.HotCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/hot-cities")
public class HotCityController {

    private final HotCityService hotCityService;

    @Autowired
    public HotCityController(HotCityService hotCityService) {
        this.hotCityService = hotCityService;
    }

    // 获取指定区域的热门城市列表
    @GetMapping("/region/{regionId}")
    public List<HotCity> getHotCitiesByRegionId(@PathVariable Long regionId) {
        return hotCityService.getHotCitiesByRegionId(regionId);
    }

    // 更新热门城市信息
    @PutMapping("/{id}")
    public HotCity updateHotCity(@PathVariable Long id, @RequestBody HotCity hotCity) {
        hotCity.setId(id); // 确保更新时保持正确的ID
        return hotCityService.saveOrUpdateHotCity(hotCity);
    }
}
