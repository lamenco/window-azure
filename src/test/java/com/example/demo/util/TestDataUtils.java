package com.example.demo.util;

import com.example.demo.models.entity.*;
import com.example.demo.models.entity.Window;
import com.example.demo.models.enums.ChamberEnum;
import com.example.demo.models.enums.ColorsEnum;
import com.example.demo.models.enums.ModelEnum;
import com.example.demo.models.enums.UserRoleEnum;
import com.example.demo.repository.*;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class TestDataUtils {
    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private ColorRepository colorRepository;
    private ChamberRepository chamberRepository;
    private MaterialRepository materialRepository;
    private WindowOfferRepository windowOfferRepository;
    private ModelRepository modelRepository;
    private DoorOfferRepository doorOfferRepository;


    public TestDataUtils(DoorOfferRepository doorOfferRepository,UserRepository userRepository, UserRoleRepository userRoleRepository, ColorRepository colorRepository, ChamberRepository chamberRepository, MaterialRepository materialRepository, WindowOfferRepository windowOfferRepository, ModelRepository modelRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.colorRepository = colorRepository;
        this.chamberRepository = chamberRepository;
        this.materialRepository = materialRepository;
        this.windowOfferRepository = windowOfferRepository;
        this.modelRepository = modelRepository;
        this.doorOfferRepository = doorOfferRepository;
    }

    private void initRoles(){
        if (userRoleRepository.count() == 0) {
            UserRole adminRole = new UserRole().setUserRole(UserRoleEnum.ADMIN);
            UserRole userRole = new UserRole().setUserRole(UserRoleEnum.USER);

            userRoleRepository.save(adminRole);
            userRoleRepository.save(userRole);
        }
    }

    public User createTestAdmin(String username){
        initRoles();
        User admin = new User("admin", "Admin", "a@a", "123",
                List.of(new UserRole().setUserRole(UserRoleEnum.USER),
                        new UserRole().setUserRole(UserRoleEnum.ADMIN)));

        return userRepository.save(admin);
    }
    public User createTestUser(String username){
        initRoles();

        var user = new User().
                setUsername(username).
                setFullName("Pesho").
                setEmail("b@b").
                setPassword("123").
                setUserRole(userRoleRepository.
                        findAll().stream().
                        filter(r -> r.getUserRole() != UserRoleEnum.ADMIN).
                        toList());

        user.setId(15L);
        return userRepository.save(user);
    }
    public Window createTestOffer(User seller){
        Chambers c = new Chambers(ChamberEnum.FIVE_CHAMBER);
        Colors color = new Colors(ColorsEnum.WHITE);
        Model model = new Model(ModelEnum.VIVAPLAST);

        chamberRepository.save(c);
        colorRepository.save(color);
        modelRepository.save(model);
        var windowOffer = new Window().setHeight(45).setWidth(53)
                .setChamber(c)
                .setColor(color)
                .setModel(model)
                .setPrice(BigDecimal.valueOf(213))
                .setUser(seller);
        windowOffer.setId(10L);
      return   windowOfferRepository.save(windowOffer);
    }
    public void cleanUpDatabase(){
        windowOfferRepository.deleteAll();
        doorOfferRepository.deleteAll();
        userRepository.deleteAll();
        userRoleRepository.deleteAll();
        colorRepository.deleteAll();
        modelRepository.deleteAll();
        materialRepository.deleteAll();
        chamberRepository.deleteAll();
    }
}
