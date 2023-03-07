package com.example.demo.models.entity;

import com.example.demo.models.enums.ModelEnum;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "windows")
public class Window extends BaseEntity{

    private double height;
    private double width;
    private Model model;
    private Colors color;
    private Chambers chamber;
    private BigDecimal price;

    private User user;
    public Window() {
    }

    public Window(double height, double width, Model model, Colors color, Chambers chamber, User user) {
        this.height = height;
        this.width = width;
        this.model = model;
        this.color = color;
        this.chamber = chamber;
        this.user = user;
    }

    public double getHeight() {
        return height;
    }

    public Window setHeight(double height) {
        this.height = height;
        return this;
    }

    public double getWidth() {
        return width;
    }

    public Window setWidth(double width) {
        this.width = width;
        return this;
    }

    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public Window setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
    @ManyToOne
    public Colors getColor() {
        return color;
    }

    public Window setColor(Colors color) {
        this.color = color;
        return this;
    }
    @ManyToOne
    public Chambers getChamber() {
        return chamber;
    }

    public Window setChamber(Chambers chamber) {
        this.chamber = chamber;
        return this;
    }
    @ManyToOne
    public Model getModel() {
        return model;
    }

    public Window setModel(Model model) {
        this.model = model;
        return this;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public Window setUser(User user) {
        this.user = user;
        return this;
    }
}
