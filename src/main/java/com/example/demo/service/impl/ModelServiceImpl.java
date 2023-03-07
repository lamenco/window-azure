package com.example.demo.service.impl;

import com.example.demo.models.entity.Material;
import com.example.demo.models.entity.Model;
import com.example.demo.models.enums.MaterialEnum;
import com.example.demo.models.enums.ModelEnum;
import com.example.demo.repository.ModelRepository;
import com.example.demo.service.ModelService;
import org.springframework.stereotype.Service;


import java.util.Arrays;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public void init() {
        if (modelRepository.count() == 0) {
            Arrays.stream(ModelEnum.values()).forEach(modelEnum -> {
                Model model = new Model();
                model.setModel(modelEnum);
                modelRepository.save(model);
            });
        }
    }

    @Override
    public Model findByModel(ModelEnum model) {
        return modelRepository.findByModel(model).orElse(null);
    }


}
