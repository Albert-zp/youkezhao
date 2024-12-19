package com.youkezhao.service;

import com.youkezhao.entity.Attraction;
import com.youkezhao.repository.AttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttractionService {

    private final AttractionRepository attractionRepository;

    @Autowired
    public AttractionService(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    // 查询所有景点
    public List<Attraction> getAllAttractions() {
        return attractionRepository.findAll();
    }

    // 根据地区ID查询景点
    public List<Attraction> getAttractionsByRegion(Long regionId) {
        return attractionRepository.findByRegionId(regionId);
    }

    // 创建或更新景点
    public Attraction saveOrUpdateAttraction(Attraction attraction) {
        return attractionRepository.save(attraction);
    }

    // 删除景点
    public void deleteAttraction(Long id) {
        attractionRepository.deleteById(id);
    }
}
