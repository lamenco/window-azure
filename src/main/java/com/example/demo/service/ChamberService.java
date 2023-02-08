package com.example.demo.service;

import com.example.demo.models.entity.Chambers;
import com.example.demo.models.enums.ChamberEnum;

public interface ChamberService {
    void init();

    Chambers findByChamber(ChamberEnum chamber);
}
