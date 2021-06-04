package com.ensias.Ensias_docs.controllers;


import com.ensias.Ensias_docs.models.User;
import com.ensias.Ensias_docs.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {



    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")

    public String index() {

        return "index";

    }

    /**
     * registering page
     * Still not working (need beans + session management!)
     * */

    @GetMapping("register")
    public String getRegister(Model model){
        User user = new User();
        model.addAttribute(user);
        return "inscription";
    }

    @GetMapping("login")
    public String getlogin(Model model) {
        User user = new User();
        model.addAttribute(user);
        return "connexion";
    }

    @PostMapping("register")
    public String inscription(User user,Model model){
        userService.saveUser(user);
        model.addAttribute("user_registered",true);
        return "inscription";
    }

}
