package com.example.demo.web;

import com.example.demo.models.dto.CommentCreationtDto;
import com.example.demo.models.dto.WindowOfferDto;

import com.example.demo.models.view.CommentViewModel;
import com.example.demo.service.CommentService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        return "details-Kommerling";
    }
    @GetMapping("/products/VIVA")
    private String detailsVIVA(Model model){
        model.addAttribute("commentCreationtDto",new CommentCreationtDto());
        return "details-VIVA";
    }


}
