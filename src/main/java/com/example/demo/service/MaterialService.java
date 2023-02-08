package com.example.demo.service;

import com.example.demo.models.entity.Material;
import com.example.demo.models.enums.MaterialEnum;

public interface MaterialService {
    void init();

    Material findByMaterial(MaterialEnum material);
}
