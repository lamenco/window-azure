package com.example.demo.models.dto;

import com.example.demo.models.enums.ModelEnum;

public class CommentCreationtDto {
    private String username;
    private String message;
    private ModelEnum model;
    public CommentCreationtDto() {
    }

    public CommentCreationtDto(String username, String message, ModelEnum model) {
        this.username = username;
        this.message = message;
        this.model = model;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ModelEnum getModel() {
        return model;
    }

    public void setModel(ModelEnum model) {
        this.model = model;
    }
}
