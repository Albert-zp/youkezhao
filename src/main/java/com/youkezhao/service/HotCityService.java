package com.youkezhao.service;

import com.youkezhao.entity.HotCity;
import com.youkezhao.repository.HotCityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotCityService {

    private final HotCityRepository hotCityRepository;

    @Autowired
    public HotCityService(HotCityRepository hotCityRepository) {
        this.hotCityRepository = hotCityRepository;
    }

    // 获取热门城市
    public List<HotCity> getHotCitiesByRegionId(Long regionId) {
        return hotCityRepository.findByRegionId(regionId);
    }

    // 根据热门排名获取热门城市
    public List<HotCity> getHotCitiesByRank(int hotRank) {
        return hotCityRepository.findByHotRank(hotRank);
    }

    // 创建或更新热门城市
    public HotCity saveOrUpdateHotCity(HotCity hotCity) {
        return hotCityRepository.save(hotCity);
    }

    // 删除热门城市
    public void deleteHotCity(Long id) {
        hotCityRepository.deleteById(id);
    }
}
