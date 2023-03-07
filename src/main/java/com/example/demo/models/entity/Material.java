package com.example.demo.models.entity;

import com.example.demo.models.enums.MaterialEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "material")
public class Material extends BaseEntity{
    private MaterialEnum material;
    @Enumerated(EnumType.STRING)
    public MaterialEnum getMaterial() {
        return material;
    }

    public Material(MaterialEnum material) {
        this.material = material;
    }

    public Material() {
    }

    public void setMaterial(MaterialEnum material) {
        this.material = material;
    }
}
