package com.example.demo.service.impl;

import com.example.demo.models.entity.Window;
import com.example.demo.models.view.WindowViewModel;
import com.example.demo.repository.WindowOfferRepository;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WindowServiceImpl {
    private final WindowOfferRepository windowOfferRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public WindowServiceImpl(WindowOfferRepository windowOfferRepository, ModelMapper modelMapper, UserService userService) {
        this.windowOfferRepository = windowOfferRepository;
         this.modelMapper = modelMapper;
         this.userService = userService;
    }


    public List<WindowViewModel> findWindowsByUsername(String username) {
         return  windowOfferRepository.findByUserUsername(username).stream()
                 .map(window -> {
                     WindowViewModel windowViewModel = modelMapper.map(window,WindowViewModel.class);
                     windowViewModel.setImage(String.format("/images/%s.jpg",windowViewModel.getColor().name().toLowerCase()));
                     return windowViewModel;
                 }).collect(Collectors.toList());
    }


    public Window findWindowsById(Long id) {
      Window window =  windowOfferRepository.findById(id).orElse(null);
        return window;
    }
}
