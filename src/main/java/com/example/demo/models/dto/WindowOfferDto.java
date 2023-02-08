package com.example.demo.models.dto;

import com.example.demo.models.enums.ChamberEnum;
import com.example.demo.models.enums.ColorsEnum;
import com.example.demo.models.enums.ModelEnum;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class WindowOfferDto {
    private double height;
    private double width;
    private ModelEnum model;
    private ChamberEnum chamber;
    private ColorsEnum color;
    private double price;
    @Min(value = 30,message = "Must be greater than 30cm")
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    @Min(value = 30,message = "Must be greater than 30cm")
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    @NotNull(message = "Please choose a chamber")
    public ChamberEnum getChamber() {
        return chamber;
    }

    public void setChamber(ChamberEnum chamber) {
        this.chamber = chamber;
    }
    @NotNull(message = "Please choose a color")
    public ColorsEnum getColor() {
        return color;
    }

    public void setColor(ColorsEnum color) {
        this.color = color;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @NotNull(message = "Please choose a model")
    public ModelEnum getModel() {
        return model;
    }

    public void setModel(ModelEnum model) {
        this.model = model;
    }
}
