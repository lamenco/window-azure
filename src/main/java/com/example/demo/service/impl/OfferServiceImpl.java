package com.example.demo.service.impl;

import com.example.demo.models.dto.DoorOfferDto;
import com.example.demo.models.dto.WindowOfferDto;
import com.example.demo.models.entity.Door;
import com.example.demo.models.entity.Window;
import com.example.demo.models.user.WindowShopperUserDetails;
import com.example.demo.repository.DoorOfferRepository;
import com.example.demo.repository.WindowOfferRepository;
import com.example.demo.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class OfferServiceImpl implements OfferService {
    private final ModelMapper modelMapper;
    private final WindowOfferRepository windowOfferRepository;
    private final DoorOfferRepository doorOfferRepository;
    private final ChamberService chamberService;
    private final ColorService colorService;
    private final MaterialService materialService;
    private final UserService userService;

    public OfferServiceImpl(ModelMapper modelMapper, WindowOfferRepository windowOfferRepository, DoorOfferRepository doorOfferRepository, ChamberService chamberService, ColorService colorService, MaterialService materialService, UserService userService) {
        this.modelMapper = modelMapper;
        this.windowOfferRepository = windowOfferRepository;
        this.doorOfferRepository = doorOfferRepository;
        this.chamberService = chamberService;
        this.colorService = colorService;
        this.materialService = materialService;
        this.userService = userService;
    }

    @Override
    public void addWindow(WindowOfferDto windowOfferDto, WindowShopperUserDetails userDetails) {
        Window window = modelMapper.map(windowOfferDto, Window.class);
        window.setColor(colorService.findByColor(windowOfferDto.getColor()));
        window.setChamber(chamberService.findByChamber(windowOfferDto.getChamber()));
        window.setUser(userService.findByUsername(userDetails.getUsername()));
        double calculatePrice = windowOfferDto.getHeight() * windowOfferDto.getWidth();
        if (windowOfferDto.getChamber().name().equals("FIVE_CHAMBER")) {
            calculatePrice *= 1.1;
        } else {
            calculatePrice *= 1.3;
        }
        if (windowOfferDto.getColor().name().equals("White")) {
            calculatePrice /= 60;
        } else {
            calculatePrice /= 50;
        }
        BigDecimal price =new BigDecimal(calculatePrice).setScale(2, RoundingMode.DOWN);
        window.setPrice(price);
        windowOfferRepository.save(window);
    }

    @Override
    public void addDoor(DoorOfferDto doorOfferDto, WindowShopperUserDetails userDetails) {
        Door door = modelMapper.map(doorOfferDto, Door.class);
        door.setColor(colorService.findByColor(doorOfferDto.getColor()));
        door.setMaterial(materialService.findByMaterial(doorOfferDto.getMaterial()));
        door.setChamber(chamberService.findByChamber(doorOfferDto.getChamber()));
        door.setUser(userService.findByUsername(userDetails.getUsername()));
        double calculatePrice = doorOfferDto.getHeight() * doorOfferDto.getWidth();
        if (doorOfferDto.getChamber().name().equals("FIVE_CHAMBER")) {
            calculatePrice *= 1.1;
        } else {
            calculatePrice *= 1.3;
        }
        if (doorOfferDto.getColor().name().equals("White")) {
            calculatePrice /= 60;
        } else {
            calculatePrice /= 50;
        }
        if(doorOfferDto.getMaterial().name().equals("PVC")){
            calculatePrice *= 1.2;
        } else {
            calculatePrice *= 1.1;
        }
        BigDecimal price =new BigDecimal(calculatePrice).setScale(2, RoundingMode.DOWN);
        door.setPrice(price);
        doorOfferRepository.save(door);
    }
}
