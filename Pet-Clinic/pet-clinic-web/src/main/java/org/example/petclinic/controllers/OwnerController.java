package org.example.petclinic.controllers;

import org.example.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/owners")
@Controller

public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

//    @RequestMapping({"/owners", "owners/index", "owners/index.html"})
@RequestMapping({"","/", "/index", "/index.html"})

public String getOwners(Model model) {

    model.addAttribute("owners", ownerService.findAll());

    return "owners/index";
}
    @RequestMapping("/find")
    public String findOwners(){
        return "notimplemented";
    }
}
