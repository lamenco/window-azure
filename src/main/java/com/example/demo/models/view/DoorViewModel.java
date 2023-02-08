package com.example.demo.models.view;

import com.example.demo.models.enums.ColorsEnum;
import com.example.demo.models.enums.MaterialEnum;

import java.math.BigDecimal;

public class DoorViewModel {
    private Long id;

    private double height;
    private double width;
    private MaterialEnum material;
    private ColorsEnum color;
    private String image;
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public MaterialEnum getMaterial() {
        return material;
    }

    public void setMaterial(MaterialEnum material) {
        this.material = material;
    }

    public ColorsEnum getColor() {
        return color;
    }

    public void setColor(ColorsEnum color) {
        this.color = color;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
