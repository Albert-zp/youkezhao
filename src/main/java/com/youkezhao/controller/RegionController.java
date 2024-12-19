package com.youkezhao.controller;

import com.youkezhao.entity.Region;
import com.youkezhao.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/regions")
public class RegionController {

    private final RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    // 获取所有区域
    @GetMapping
    public List<Region> getAllRegions() {
        return regionService.getAllRegions();
    }

    // 根据ID获取区域
    @GetMapping("/{id}")
    public ResponseEntity<Region> getRegionById(@PathVariable Long id) {
        Optional<Region> region = regionService.getRegionById(id);
        if (region.isPresent()) {
            return ResponseEntity.ok(region.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // 根据父级ID获取区域
    @GetMapping("/parent/{parentId}")
    public List<Region> getRegionsByParentId(@PathVariable Long parentId) {
        return regionService.getRegionsByParentId(parentId);
    }

    // 创建新区域
    @PostMapping
    public ResponseEntity<String> createRegion(@RequestBody Region region) {
        if (regionService.existsByName(region.getName())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("区域名称已存在！");
        }

        Region savedRegion = regionService.saveOrUpdateRegion(region);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("区域创建成功，ID: " + savedRegion.getId());
    }

    // 更新区域
    @PutMapping("/{id}")
    public ResponseEntity<String> updateRegion(@PathVariable Long id, @RequestBody Region region) {
        // 首先检查区域是否存在
        Optional<Region> existingRegion = regionService.getRegionById(id);
        if (existingRegion.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("区域不存在，无法更新！");
        }

        // 检查名称是否唯一，排除当前区域
        if (regionService.existsByNameAndIdNot(region.getName(), id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("区域名称已存在！");
        }

        region.setId(id);  // 保持原来的ID
        regionService.saveOrUpdateRegion(region);
        return ResponseEntity.status(HttpStatus.OK)
                .body("区域更新成功！");
    }

    // 删除区域
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRegion(@PathVariable Long id) {
        Optional<Region> region = regionService.getRegionById(id);
        if (region.isPresent()) {
            regionService.deleteRegion(id);
            return ResponseEntity.status(HttpStatus.OK).body("区域删除成功！");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("区域不存在，无法删除！");
        }
    }
}
