package com.youkezhao.repository;

import com.youkezhao.entity.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AttractionRepository extends JpaRepository<Attraction, Long> {

    // 根据地区ID查询景点（例如查询某个省市的所有景点）
    List<Attraction> findByRegionId(Long regionId);
}
