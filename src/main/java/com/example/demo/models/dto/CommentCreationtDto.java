package com.example.demo.models.dto;

public class CommentCreationtDto {
    private String username;
    private String message;
    private String model;
    public CommentCreationtDto() {
    }

    public CommentCreationtDto(String username, String message, String model) {
        this.username = username;
        this.message = message;
        this.model=model;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
