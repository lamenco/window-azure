package com.example.demo.models.entity;

import com.example.demo.models.enums.ChamberEnum;

import javax.persistence.*;

@Entity
@Table(name = "chambers")
public class Chambers extends BaseEntity{
    private ChamberEnum chamber;

    public Chambers() {
    }
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public ChamberEnum getChamber() {
        return chamber;
    }

    public void setChamber(ChamberEnum chamber) {
        this.chamber = chamber;
    }
}
