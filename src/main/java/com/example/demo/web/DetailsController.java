package com.example.demo.web;

import com.example.demo.models.dto.CommentCreationtDto;
import com.example.demo.models.dto.WindowOfferDto;

import com.example.demo.service.CommentService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DetailsController {
    private final CommentService commentService;

    public DetailsController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/products")
    private String details(){
        return "details";
    }

    @GetMapping("/products/Kommerling")
    private String detailsKommerling(Model model){
        model.addAttribute("commentCreationtDto",new CommentCreationtDto());
        model.addAttribute("kommerling",commentService.gettAllComents());
        return "details-Kommerling";
    }

    @PostMapping("/products/Kommerling")
    public String comment(@Valid CommentCreationtDto commentCreationtDto,
                          @AuthenticationPrincipal UserDetails userDetails){

        commentService.add(commentCreationtDto,userDetails.getUsername());

        return "details-Kommerling";
    }

}
