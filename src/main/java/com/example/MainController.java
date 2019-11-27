package com.example;

import com.example.domain.Message;
import com.example.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "World")
                        String name, Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
public String main(Map<String, Object> model){
        Iterable<Message> messages = messageRepo.findAll();
        model.put("some", messages);
        return "main";
    }

}