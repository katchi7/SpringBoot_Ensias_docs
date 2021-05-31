package com.ensias.Ensias_docs.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

    @RequestMapping("/")

    public String index() {

        return "index";

    }

    /**
     * registering page
     * Still not working (need beans + session management!)
     * */

    @GetMapping("register")
    public String getRegister(){
        return "inscription";
    }

}
