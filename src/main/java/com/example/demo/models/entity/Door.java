package com.example.demo.models.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "doors")
public class Door extends BaseEntity{
    private double height;
    private double width;
    private Material material;
    private Colors color;
    private Chambers chamber;
    private BigDecimal price;
    private String model;



    private User user;

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
    @ManyToOne()
    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
    @ManyToOne()
    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }
    @ManyToOne()
    public Chambers getChamber() {
        return chamber;
    }

    public void setChamber(Chambers chamber) {
        this.chamber = chamber;
    }
    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
