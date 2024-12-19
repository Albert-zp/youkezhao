package com.youkezhao.service;

import com.youkezhao.entity.Image;
import com.youkezhao.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    // 获取某个景点的所有图片
    public List<Image> getImagesByAttractionId(Long attractionId) {
        return imageRepository.findByAttractionId(attractionId);
    }

    // 获取某个区域的所有图片
    public List<Image> getImagesByRegionId(Long regionId) {
        return imageRepository.findByRegionId(regionId);
    }

    // 创建或更新图片
    public Image saveOrUpdateImage(Image image) {
        return imageRepository.save(image);
    }

    // 删除图片
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }
}
