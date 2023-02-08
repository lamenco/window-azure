package com.example.demo.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "windows")
public class Window extends BaseEntity{

    private double height;
    private double width;
    private String model;
    private Colors color;
    private Chambers chamber;
    private BigDecimal price;

    private User user;
    public Window() {
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

    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @ManyToOne
    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }
    @ManyToOne
    public Chambers getChamber() {
        return chamber;
    }

    public void setChamber(Chambers chamber) {
        this.chamber = chamber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
