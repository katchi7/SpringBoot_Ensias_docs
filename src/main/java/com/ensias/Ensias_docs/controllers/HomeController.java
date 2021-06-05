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
import java.util.List;

@Controller

@RequestMapping("/ensiasdocs")
public class HomeController {
    @Autowired
    private ElementService es;

    @Autowired
    private UserService us;

    public HomeController(ElementService es) {
          this.es=es;
    }

    @RequestMapping("/home")

    public String home(Model model ){
       User user= us.getCurrentUser();
       List<Element> elements=  es.getElementsByUser(user.getUser_id());
        model.addAttribute("modules",elements);
        model.addAttribute("user",user);

        return "Home";

    }


}
