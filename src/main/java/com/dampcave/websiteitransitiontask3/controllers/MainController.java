package com.dampcave.websiteitransitiontask3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/login")
    public String sign( Model model) {
        model.addAttribute("title", "Вход");
        return "login";
    }


    @GetMapping("/")
    public String home( Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    @GetMapping("/oops")
    public String oops( Model model) {
        model.addAttribute("title", "don't worry");
        return "dont-worry";
    }


}
