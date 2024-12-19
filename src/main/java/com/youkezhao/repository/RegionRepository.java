package com.youkezhao.repository;

import com.youkezhao.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {

    // 根据父级ID查找区域（子区域）
    List<Region> findByParentId(Long parentId);

    // 根据层级查询区域（1 = 省，2 = 市）
    List<Region> findByLevel(Integer level);

    // 根据sortOrder字段升序排列查询区域
    List<Region> findByOrderBySortOrderAsc();

    // 根据父级区域ID和sortOrder字段排序查找区域
    List<Region> findByParentIdOrderBySortOrderAsc(Long parentId);

    // 根据名称查找区域（用于判断区域名称是否存在）
    boolean existsByName(String name);

    // 根据名称和ID查找区域，排除当前区域
    boolean existsByNameAndIdNot(String name, Long id);
}
