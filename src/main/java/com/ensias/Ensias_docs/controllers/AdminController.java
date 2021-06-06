package com.ensias.Ensias_docs.controllers;

import com.ensias.Ensias_docs.dto.ElementCreationFormDto;
import com.ensias.Ensias_docs.dto.ElementModifDto;
import com.ensias.Ensias_docs.models.Element;
import com.ensias.Ensias_docs.models.User;
import com.ensias.Ensias_docs.services.ElementService;
import com.ensias.Ensias_docs.services.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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


    @GetMapping("/modifier-module")
    public String getModifierModule(){return "redirect:/ensiasdocs/admin";}

    @PostMapping("/modifier-module")
    public String modifierModule(Model model,@Valid @ModelAttribute("element_modification") ElementModifDto element,Errors errors){
        if(!errors.hasErrors()){
            elementService.updateElement(element.getAsElement());
            return "redirect:/ensiasdocs/admin";
        }
        else System.out.println(errors);
        addAttributes(model);
        return "admin";
    }


    @GetMapping("/ajouter-examen")
    public String getAjouterExam(){return "redirect:/ensiasdocs/admin";}
    @PostMapping("/ajouter-examen")
    public String ajouterExam(Model model, @RequestParam("elm_module") String elm_id,@RequestParam("examen") String examen)  {
        try {
        if(elm_id!=null && !elm_id.trim().equals("") && examen!=null && !examen.trim().equals("")){
            int id = Integer.parseInt(elm_id);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(examen);
            elementService.updateExam(id,date);
            return "redirect:/ensiasdocs/admin";
        }
        } catch (ParseException | NumberFormatException e) {

        }
        addAttributes(model);
        return "admin";
    }

    private void addAttributes(Model model){
        User user = userService.getCurrentUser();
        boolean auth = user!=null;
        model.addAttribute("auth",auth);
        if(user!=null)model.addAttribute("user",user);

        List<Element> modules = elementService.getAllElements();
        model.addAttribute("modules",modules);

        ElementCreationFormDto element_creation = new ElementCreationFormDto();
        model.addAttribute("element_creation",element_creation);

        ElementModifDto element_modification = new ElementModifDto();
        model.addAttribute("element_modification",element_modification);

    }
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String HandleException(MissingServletRequestParameterException e){
        System.out.println("name " + e.getMessage());
        return "redirect:/ensiasdocs/admin";
    }
}

