package org.example.petclinic.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/owners")
@Controller

public class OwnerController {

//    @RequestMapping({"/owners", "owners/index", "owners/index.html"})
@RequestMapping({"","/", "/index", "/index.html"})
    public String getOwners() {
        return "owners/index";
    }
}
