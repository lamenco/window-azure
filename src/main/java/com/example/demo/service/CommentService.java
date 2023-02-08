package com.example.demo.service;

import com.example.demo.models.dto.CommentCreationtDto;
import com.example.demo.models.view.CommentViewModel;

import java.util.List;

public interface CommentService {
    void add(CommentCreationtDto commentCreationtDto, String username);

    List<CommentViewModel> gettAllComents();
}
