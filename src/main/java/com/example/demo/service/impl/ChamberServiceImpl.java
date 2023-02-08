package com.example.demo.service.impl;

import com.example.demo.models.entity.Chambers;
import com.example.demo.models.entity.Colors;
import com.example.demo.models.enums.ChamberEnum;
import com.example.demo.models.enums.ColorsEnum;
import com.example.demo.repository.ChamberRepository;
import com.example.demo.service.ChamberService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ChamberServiceImpl implements ChamberService {
    private final ChamberRepository chamberRepository;
    public ChamberServiceImpl(ChamberRepository chamberRepository) {
        this.chamberRepository = chamberRepository;
    }

    @Override
    public void init() {
        if (chamberRepository.count() == 0) {
            Arrays.stream(ChamberEnum.values()).forEach(chamberEnum -> {
                Chambers chambers = new Chambers();
                chambers.setChamber(chamberEnum);
                chamberRepository.save(chambers);
            });
        }
    }

    @Override
    public Chambers findByChamber(ChamberEnum chamber) {
        return chamberRepository.findByChamber(chamber).orElse(null);
    }
}
