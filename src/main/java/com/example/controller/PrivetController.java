package com.example.controller;

import com.example.domain.Privet;
import com.example.model.PrivetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Map;

@Controller
public class PrivetController {

    @Autowired
   private PrivetRepo privetRepo;

    @PostMapping("filter_privet")
    public String filter_privet(@RequestParam String filter_privet,
                                Map<String, Object> model) {
       Iterable <Privet> privet;
        if (filter_privet != null && !filter_privet.isEmpty()  ){
            privet = privetRepo.findByAuthorIgnoreCaseContaining(filter_privet);
        } else {
            privet = privetRepo.findAll();
        }
        model.put("privet", privet);

        return "privet";
    }

    @GetMapping("/filter_privet")
    public String filter_privet (Map<String, Object> model) {
        Iterable <Privet> privet = privetRepo.findAll();
        model.put("privet", privet);
        return "redirect:/privet";
    }
}
