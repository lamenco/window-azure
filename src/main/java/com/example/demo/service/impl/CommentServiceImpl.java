package com.example.demo.service.impl;

import com.example.demo.models.dto.CommentCreationtDto;
import com.example.demo.models.entity.*;
import com.example.demo.models.enums.ModelEnum;
import com.example.demo.models.view.CommentViewModel;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CommentService;
import com.example.demo.service.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final ModelService modelService;

    private final ModelMapper modelMapper;

    public CommentServiceImpl(UserRepository userRepository, CommentRepository commentRepository, ModelService modelService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.modelService = modelService;
        this.modelMapper = modelMapper;
    }

    public CommentViewModel createComment(CommentCreationtDto commentCreationtDto) {
        User author = userRepository.findByUsername(commentCreationtDto.getUsername()).orElse(null);
        Comment comment = new Comment();
        comment.setCreated(LocalDateTime.now());
        comment.setModel(modelService.findByModel(commentCreationtDto.getModel()));
        comment.setAuthor(author);
        comment.setText(commentCreationtDto.getMessage());
        commentRepository.save(comment);

        return new CommentViewModel(author.getUsername(), comment.getText());
    }

    public List<CommentViewModel> getAllComments(ModelEnum modelEnum) {

        List<Comment> comments = commentRepository.findCommentsByModel_Model(modelEnum).get();
        return comments.stream().map(comment ->
                new CommentViewModel(comment.getAuthor().getUsername(), comment.getText()))
                .collect(Collectors.toList());

    }
}
