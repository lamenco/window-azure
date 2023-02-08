package com.example.demo.service.impl;

import com.example.demo.models.entity.Colors;
import com.example.demo.models.entity.Material;
import com.example.demo.models.enums.ColorsEnum;
import com.example.demo.models.enums.MaterialEnum;
import com.example.demo.repository.MaterialRepository;
import com.example.demo.service.MaterialService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MaterialServiceImpl implements MaterialService {
    private final MaterialRepository materialRepository;

    public MaterialServiceImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public void init() {
        if (materialRepository.count() == 0) {
            Arrays.stream(MaterialEnum.values()).forEach(materialEnum -> {
                Material material = new Material();
                material.setMaterial(materialEnum);
                materialRepository.save(material);
            });
        }
    }

    @Override
    public Material findByMaterial(MaterialEnum material) {
        return materialRepository.findByMaterial(material).orElse(null);
    }
}
