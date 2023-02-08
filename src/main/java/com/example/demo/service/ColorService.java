package com.example.demo.service;

import com.example.demo.models.entity.Colors;
import com.example.demo.models.enums.ColorsEnum;

public interface ColorService {
    void init();

    Colors findByColor(ColorsEnum color);
}
