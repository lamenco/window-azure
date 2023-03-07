package com.example.demo.models.view;

import com.example.demo.models.enums.ColorsEnum;
import com.example.demo.models.enums.ModelEnum;

import java.math.BigDecimal;

public class WindowViewModel {
    private Long id;
    private double height;
    private double width;
    private ColorsEnum color;
    private String image;
    private BigDecimal price;
    private ModelEnum model;
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

    public ModelEnum getModel() {
        return model;
    }

    public void setModel(ModelEnum model) {
        this.model = model;
    }
}
