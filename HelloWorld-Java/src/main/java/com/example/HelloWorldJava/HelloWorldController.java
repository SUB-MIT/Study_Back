package com.example.HelloWorldJava;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello(@RequestParam String name, Model model) {
        model.addAttribute("name",name);
        return "hello";
    }

}
