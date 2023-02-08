package com.example.demo.service.impl;

import com.example.demo.models.entity.Colors;
import com.example.demo.models.entity.UserRole;
import com.example.demo.models.enums.ColorsEnum;
import com.example.demo.models.enums.UserRoleEnum;
import com.example.demo.repository.ColorRepository;
import com.example.demo.service.ColorService;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Arrays;

@Service
public class ColorServiceImpl implements ColorService {
    private final ColorRepository colorRepository;

    public ColorServiceImpl(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    @Override
    public void init() {
        if (colorRepository.count() == 0) {
            Arrays.stream(ColorsEnum.values()).forEach(colorsEnum -> {
                Colors colors = new Colors();
                colors.setColor(colorsEnum);
                colorRepository.save(colors);
            });
        }
    }

    @Override
    public Colors findByColor(ColorsEnum color) {
        return colorRepository.findByColor(color).orElse(null);
    }
}
