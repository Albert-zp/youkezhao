package com.youkezhao.repository;

import com.youkezhao.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    // 根据景点ID查询所有的图片
    List<Image> findByAttractionId(Long attractionId);

    // 根据区域ID查询所有的图片
    List<Image> findByRegionId(Long regionId);
}
