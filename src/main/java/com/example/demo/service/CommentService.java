package com.example.demo.service;

import com.example.demo.models.dto.CommentCreationtDto;
import com.example.demo.models.enums.ModelEnum;
import com.example.demo.models.view.CommentViewModel;

import java.util.List;

public interface CommentService {
     CommentViewModel createComment(CommentCreationtDto commentCreationtDto);
     List<CommentViewModel> getAllComments(ModelEnum modelEnum);
}
