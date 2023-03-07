package com.example.demo.models.entity;

import com.example.demo.models.enums.ColorsEnum;

import javax.persistence.*;

@Entity
@Table(name = "colors")
public class Colors extends BaseEntity{
    private ColorsEnum color;

    public Colors() {
    }

    public Colors(ColorsEnum color) {
        this.color = color;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public ColorsEnum getColor() {
        return color;
    }

    public void setColor(ColorsEnum color) {
        this.color = color;
    }
}
