package com.example.demo.models.entity;

import com.example.demo.models.enums.ModelEnum;
import jdk.jfr.Enabled;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "models")
public class Model extends BaseEntity{
    private ModelEnum model;

    public Model() {
    }
    @Enumerated(EnumType.STRING)
    public ModelEnum getModel() {
        return model;
    }

    public void setModel(ModelEnum model) {
        this.model = model;
    }
}
