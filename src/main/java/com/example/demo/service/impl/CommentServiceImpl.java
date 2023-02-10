package com.example.demo.service.impl;

import com.example.demo.models.dto.CommentCreationtDto;
import com.example.demo.models.entity.Comment;
import com.example.demo.models.entity.User;
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

    public CommentViewModel createComment(CommentCreationtDto commentDto) {
        User author = userRepository.findByUsername(commentDto.getUsername()).get();
        Comment comment = new Comment();
        comment.setCreated(LocalDateTime.now());
        comment.setAuthor(author);
        comment.setModel(modelService.findByModel(commentDto.getModel()));
        comment.setText(commentDto.getMessage());

        commentRepository.save(comment);

        return new CommentViewModel(author.getFullName(),comment.getText());
    }

    @Override
    public void add(CommentCreationtDto commentCreationtDto, String username) {
        User author = userRepository.findByUsername(username).orElse(null);
        Comment comment = new Comment();
        comment.setCreated(LocalDateTime.now());
        comment.setAuthor(author);
        comment.setModel("Kommerling");
        comment.setText(commentCreationtDto.getMessage());

        commentRepository.save(comment);
    }

    @Override
    public List<CommentViewModel> gettAllComents() {
        return commentRepository.findAllByModelOrderByCreated("Kommerling")
                .stream()
                .map(comment -> {
                    CommentViewModel commentViewModel =new CommentViewModel();
                    commentViewModel.setAuthorName(comment.getAuthor().getUsername());
                    commentViewModel.setText(comment.getText());
                    return commentViewModel;
                }).collect(Collectors.toList());
    }
}
