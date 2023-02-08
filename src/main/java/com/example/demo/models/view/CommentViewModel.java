package com.example.demo.models.view;

public class CommentViewModel {

    private String authorName;
    private String message;

    public CommentViewModel() {
    }

    public CommentViewModel(String authorName, String message) {
        this.authorName = authorName;
        this.message = message;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
