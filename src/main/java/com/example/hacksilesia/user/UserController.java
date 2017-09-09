package com.example.hacksilesia.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    String index() {
        return "index";
    }

    @GetMapping("/about")
    String about() { return "about"; }

    @GetMapping("/project")
    String project() { return "project"; }

}
