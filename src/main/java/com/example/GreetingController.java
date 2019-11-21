package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam
                    (name="name", required=false, defaultValue="World")
                    String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(
            @RequestParam(name="name", required=false, defaultValue="main page") String name, Model model) {
        model.addAttribute("name", name);
        return "main";
    }

    @GetMapping("/almaz")
    public String almaz(
            @RequestParam
                    (name="name", required=false, defaultValue="World")
                    String name, Model model) {
        model.addAttribute("name", name);
        return "almaz";
    }

}