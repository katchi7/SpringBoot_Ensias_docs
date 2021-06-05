package com.ensias.Ensias_docs.controllers;

import com.ensias.Ensias_docs.models.Element;
import com.ensias.Ensias_docs.models.User;
import com.ensias.Ensias_docs.services.ElementService;
import com.ensias.Ensias_docs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller

@RequestMapping("/ensiasdocs")
public class HomeController {
    @Autowired
    private ElementService es;

    @Autowired
    private UserService us;

    @RequestMapping("/home")

    public String home(Model model) {
          //User user =us;


        ArrayList<Element> elements= (ArrayList<Element>) es.getElementsByUser(1);
        model.addAttribute(elements);


        return "Home";

    }


}
