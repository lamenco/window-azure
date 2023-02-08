package com.example.demo.web;

import com.example.demo.models.user.WindowShopperUserDetails;
import com.example.demo.models.view.DoorViewModel;
import com.example.demo.models.view.WindowViewModel;
import com.example.demo.repository.WindowOfferRepository;
import com.example.demo.service.impl.DoorServiceImpl;
import com.example.demo.service.impl.WindowServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class CartController {
    private final WindowServiceImpl windowService;
    private final DoorServiceImpl doorService;
    private final WindowOfferRepository windowOfferRepository;

    public CartController(WindowServiceImpl windowService, DoorServiceImpl doorService, WindowOfferRepository windowOfferRepository) {

        this.windowService = windowService;
        this.doorService = doorService;
        this.windowOfferRepository = windowOfferRepository;
    }

    @GetMapping("/cart")
    public String myCart(Model model, @AuthenticationPrincipal WindowShopperUserDetails userDetails){
        List<WindowViewModel> windows = windowService.findWindowsByUsername(userDetails.getUsername());
        List<DoorViewModel> doors = doorService.findDoorsByUsername(userDetails.getUsername());

        model.addAttribute("windows",windows);
        model.addAttribute("doors",doors);

        model.addAttribute("windowsPrice",windows
                .stream()
                .map(windowViewModel -> windowViewModel.getPrice()).reduce((a,b)->BigDecimal.valueOf(a.doubleValue()+b.doubleValue())).orElse(null));

        model.addAttribute("doorPrice",doors
                .stream()
                .map(doorViewModel -> doorViewModel.getPrice()).reduce((a,b)->BigDecimal.valueOf(a.doubleValue()+b.doubleValue())).orElse(null));
        return "cart";
    }

    @GetMapping("/cart/delete/{id}")
    public String removeById(@PathVariable Long id){
        windowOfferRepository.deleteById(id);
        return "redirect:/cart";
    }
}
