package com.example.hacksilesia.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    String index() {
        return "index";
    }

    @GetMapping("/login")
    String logInToTheSiteViewPage(ModelMap model){
        if (model.get("user") == null) {
            return "login";
        }
        return "redirect:/";
    }

    @GetMapping("/about")
    String about() { return "about"; }

    @GetMapping("/project")
    String project() { return "project"; }

    @GetMapping("/tracks")
    String tracks() { return "tracks"; }

}
