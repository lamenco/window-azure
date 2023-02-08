package com.example.demo.init;

import com.example.demo.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {
    private final UserRoleService userRoleService;
    private final ColorService colorService;
    private final ChamberService chamberService;
    private final MaterialService materialService;
    private final ModelService modelService;

    public DatabaseInit(UserRoleService userRoleService, ColorService colorService, ChamberService chamberService, MaterialService materialService, ModelService modelService) {
        this.userRoleService = userRoleService;
        this.colorService = colorService;
        this.chamberService = chamberService;
        this.materialService = materialService;
        this.modelService = modelService;
    }

    @Override
    public void run(String... args) throws Exception {
        userRoleService.init();
        colorService.init();
        chamberService.init();
        materialService.init();
        modelService.init();
    }
}
