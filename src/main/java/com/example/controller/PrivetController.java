package com.example.controller;

import com.example.domain.Privet;
import com.example.model.PrivetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Map;

@Controller
public class PrivetController {

    @Autowired
   private PrivetRepo privetRepo;

    @GetMapping("/privet" )
    public String filter_privet(@RequestParam (required = false) String filter_privet,
                                Model model) {
       Iterable <Privet> privet = null;
        if (filter_privet != null && !filter_privet.isEmpty()  ){
            privet = privetRepo.findByAuthorIgnoreCaseContaining(filter_privet);
        } else {
            privetRepo.findAll();
        }
        model.addAttribute("privet", privet);
        model.addAttribute("filter_privet", filter_privet);

        return "privet";
    }


    @GetMapping("/filter_title" )
    public String filter_privet_author (@RequestParam (required = false) String filter_privet_title,
                                Model model) {
        Iterable <Privet> privet = null;
        if (filter_privet_title != null && !filter_privet_title.isEmpty()  ){
            privet = privetRepo.findByTitleIgnoreCaseContaining(filter_privet_title);
        } else {
            privetRepo.findAll();
        }
        model.addAttribute("privet", privet);
        model.addAttribute("filter_privet_title", filter_privet_title);

        return "privet";
    }

}
