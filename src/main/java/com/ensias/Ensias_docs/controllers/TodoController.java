package com.ensias.Ensias_docs.controllers;

import com.ensias.Ensias_docs.dto.ElementCreationFormDto;
import com.ensias.Ensias_docs.dto.ElementModifDto;
import com.ensias.Ensias_docs.models.Element;
import com.ensias.Ensias_docs.models.User;
import com.ensias.Ensias_docs.models.todos;
import com.ensias.Ensias_docs.services.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ensiasdocs")
public class TodoController {
    final UserService userService;

    public TodoController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/todo")
    public String getTodo(Model model){

        User user = userService.getCurrentUser();

        addAttributes(model,user);
        return "todo";

    }

    @PostMapping("/todo")
    public String  creerTodo( @RequestParam("todo_name") String todo_name,@RequestParam("todo_date") String todo_date){
        User user = userService.getCurrentUser();
        userService.createTodo(todo_name,todo_date,user);
        return "redirect:/ensiasdocs/todo";
    }

    @PostMapping("/todo/done")
    public String todoDone(@RequestParam("todo_id") int todo_id,@RequestParam("update_done") String done ){
        int todo_done = done.equals("done")?1:0;
        userService.updateTodoDone(todo_id,todo_done);
        return "redirect:/ensiasdocs/todo";
    }

    @PostMapping("/todo/delete")
    public String todoDelete(@RequestParam("todo_id") int todo_id){

        userService.deleteTodo(todo_id);
        return "redirect:/ensiasdocs/todo";
    }


    private void addAttributes(Model model,User user){

        boolean auth = user!=null;
        model.addAttribute("auth",auth);
        if(user!=null)model.addAttribute("user",user);
    }

}
