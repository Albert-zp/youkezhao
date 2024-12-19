package com.youkezhao.repository;

import com.youkezhao.entity.HotCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotCityRepository extends JpaRepository<HotCity, Long> {

    // 根据热门排名查找热门城市
    List<HotCity> findByHotRank(int hotRank);

    // 根据区域ID查找热门城市
    List<HotCity> findByRegionId(Long regionId);
}
