package com.youkezhao.service;

import com.youkezhao.entity.Region;
import com.youkezhao.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    private final RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    // 获取所有区域
    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }

    // 根据ID获取区域
    public Optional<Region> getRegionById(Long id) {
        return regionRepository.findById(id);
    }

    // 根据父级ID获取区域
    public List<Region> getRegionsByParentId(Long parentId) {
        return regionRepository.findByParentId(parentId);
    }

    // 创建或更新区域
    public Region saveOrUpdateRegion(Region region) {
        return regionRepository.save(region);
    }

    // 删除区域
    public void deleteRegion(Long id) {
        regionRepository.deleteById(id);
    }

    // 检查区域名称是否存在
    public boolean existsByName(String name) {
        return regionRepository.existsByName(name);
    }

    // 检查除当前区域外，是否存在相同名称的区域
    public boolean existsByNameAndIdNot(String name, Long id) {
        return regionRepository.existsByNameAndIdNot(name, id);
    }
}
