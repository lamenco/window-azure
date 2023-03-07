package com.example.demo.service;

import com.example.demo.models.entity.Model;
import com.example.demo.models.enums.ModelEnum;

public interface ModelService {
    void init();


    Model findByModel(ModelEnum model);
}
