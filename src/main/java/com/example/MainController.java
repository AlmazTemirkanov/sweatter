package com.example;

import com.example.domain.Message;
import com.example.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/login")
    public String greeting(Map<String, Object> model) {
        return "/login";
    }

    @GetMapping ("/")
    public String main(Map<String, Object> model){
        return "main";
    }


    @PostMapping("/admin")
    public String admin(Map<String, Object> model) {
        return "/admin";
    }


@PostMapping ("/main")
    public String add(@RequestParam String text,@RequestParam String selo, Map<String, Object> model){
        Message message = new Message(text, selo);
        messageRepo.save(message);
    Iterable<Message> messages = messageRepo.findAll();
    model.put("messages", messages);
        return "main";
}
@PostMapping ("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable <Message> messages;
        if (filter !=null && !filter.isEmpty()){
            messages = messageRepo.findBySeloIgnoreCaseStartingWith(filter);
        } else {
            messages = messageRepo.findAll();
        }
    model.put("messages", messages);
    return "main";
}
}