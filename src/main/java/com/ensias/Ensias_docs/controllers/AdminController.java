package com.ensias.Ensias_docs.controllers;

import com.ensias.Ensias_docs.dto.ElementCreationFormDto;
import com.ensias.Ensias_docs.models.Element;
import com.ensias.Ensias_docs.models.User;
import com.ensias.Ensias_docs.services.ElementService;
import com.ensias.Ensias_docs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/ensiasdocs/admin")
public class AdminController {
    @Autowired
    UserService userService;

    @Autowired
    ElementService elementService;
    @GetMapping("")
    public String getAdmin(Model model){
        addAttributes(model);
        return "admin";
    }

    @PostMapping("/creer-module")
    public String creerModule(Model model, @ModelAttribute("elemen_creation") @Valid ElementCreationFormDto elemment, Errors errors){


        if(!errors.hasErrors()){
            elementService.createElement(elemment.getAsElement());
            return "redirect:/ensiasdocs/admin";
        }
        addAttributes(model);
        return "admin";

    }

    @GetMapping("/creer-module")
    public String getCreerModule(){return "redirect:/ensiasdocs/admin";}

    private void addAttributes(Model model){
        User user = userService.getCurrentUser();
        boolean auth = user!=null;
        model.addAttribute("auth",auth);
        if(user!=null)model.addAttribute("user",user);

        List<Element> modules = elementService.getAllElements();
        model.addAttribute("modules",modules);

        ElementCreationFormDto element_creation = new ElementCreationFormDto();
        model.addAttribute("element_creation",element_creation);

    }
}
