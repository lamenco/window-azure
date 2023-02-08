package com.example.demo.service;

import com.example.demo.models.dto.DoorOfferDto;
import com.example.demo.models.dto.WindowOfferDto;
import com.example.demo.models.user.WindowShopperUserDetails;

public interface OfferService {
    void addWindow(WindowOfferDto windowOfferDto, WindowShopperUserDetails userDetails);

    void addDoor(DoorOfferDto doorOfferDto, WindowShopperUserDetails userDetails);
}
