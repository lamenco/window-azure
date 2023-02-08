package com.example.demo.models.dto;

import com.example.demo.models.enums.ChamberEnum;
import com.example.demo.models.enums.ColorsEnum;
import com.example.demo.models.enums.MaterialEnum;
import com.example.demo.models.enums.ModelEnum;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class DoorOfferDto {
    private double height;
    private double width;
    private ModelEnum model;
    private MaterialEnum material;
    private ChamberEnum chamber;
    private ColorsEnum color;
    private double price;
    @Min(value = 50,message = "Must be greater than 50cm")
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    @Min(value = 50,message = "Must be greater than 50cm")
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    @NotNull(message = "Please choose a material")
    public MaterialEnum getMaterial() {
        return material;
    }

    public void setMaterial(MaterialEnum material) {
        this.material = material;
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
