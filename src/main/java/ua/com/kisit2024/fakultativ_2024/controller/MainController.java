package ua.com.kisit2024.fakultativ_2024.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
    @GetMapping("/")
    public String getPageHome(Model model){
        model.addAttribute("hello", "Hello Student!");
        return "index";
    }
}
