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
    private Model model;

    public Door() {
    }

    public Door(double height, double width, Material material, Colors color, Chambers chamber, BigDecimal price, Model model, User user) {
        this.height = height;
        this.width = width;
        this.material = material;
        this.color = color;
        this.chamber = chamber;
        this.price = price;
        this.model = model;
        this.user = user;
    }

    private User user;

    public double getHeight() {
        return height;
    }

    public Door setHeight(double height) {
        this.height = height;
        return  this;
    }

    public double getWidth() {
        return width;
    }

    public Door setWidth(double width) {
        this.width = width;
        return  this;
    }
    @ManyToOne
    public Material getMaterial() {
        return material;
    }

    public Door setMaterial(Material material) {
        this.material = material;
        return  this;
    }
    @ManyToOne
    public Colors getColor() {
        return color;
    }

    public Door setColor(Colors color) {
        this.color = color;
        return  this;
    }
    @ManyToOne
    public Chambers getChamber() {
        return chamber;
    }

    public Door setChamber(Chambers chamber) {
        this.chamber = chamber;
        return  this;
    }
    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public Door setPrice(BigDecimal price) {
        this.price = price;
        return  this;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public Door setUser(User user) {
        this.user = user;
        return  this;
    }
    @ManyToOne
    public Model getModel() {
        return model;
    }

    public Door setModel(Model model) {
        this.model = model;
        return  this;
    }
}
