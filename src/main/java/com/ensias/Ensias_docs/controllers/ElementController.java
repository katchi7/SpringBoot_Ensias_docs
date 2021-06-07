package com.ensias.Ensias_docs.controllers;

import com.ensias.Ensias_docs.models.Element;
import com.ensias.Ensias_docs.models.User;
import com.ensias.Ensias_docs.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ensiasdocs/module")
public class ElementController {
    /*
    private final UserService userService;

    public ElementController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{module_id}")
    public String getElement(Model model, @PathVariable("module_id") int module_id){

        User user = userService.getCurrentUser();
        addAttributes(model,user,module_id);
        return "module";
    }

    private void addAttributes(Model model,User user,int module_id){

        boolean auth = user!=null;
        model.addAttribute("auth",auth);
        if(user!=null)model.addAttribute("user",user);
        Element element = null;
        for (Element e : user.getElements()){
            if(e.getElm_id() == module_id){
                element = e;
                break;
            }
        }
        if(element!=null) model.addAttribute("module",element);
        model.addAttribute("inscrit",element!=null);
    }

     */
}
