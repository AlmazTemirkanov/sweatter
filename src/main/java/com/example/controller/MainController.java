package com.example.controller;

import com.example.domain.Message;
import com.example.model.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping
    public String add (@RequestParam String LTE, @RequestParam String WCDMA, @RequestParam String area, @RequestParam String district, @RequestParam String region, @RequestParam String selo, @RequestParam String tag, @RequestParam String text, @RequestParam String voice, Map<String, Object> model){
        Message message = new Message(LTE, WCDMA, area, district, region, selo, tag, text, voice);
        messageRepo.save(message);
        Iterable <Message> messages = messageRepo.findAll();
        model.put("message",messages);
        return "/admin";
    }


    @GetMapping("/admin")
    public String admin(Map<String, Object> model) {
        return "/admin";
    }

    @GetMapping("/edit")
    public String edit (Map<String, Object> model) {
        return "/edit";
    }

    @GetMapping("/filter")
    public String filter(Map<String, Object> model) {
        return "/";
    }



    @PostMapping ("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable <Message> messages;
        if (filter !=null && !filter.isEmpty()){
            messages = messageRepo.findBySeloIgnoreCaseStartingWith(filter);
        } else {
            messages = messageRepo.findBySeloIgnoreCaseStartingWith(filter);
        }
    model.put("messages", messages);
    return "main";
}

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Map<String, Object> model) {

        messageRepo.deleteById(id);
        Iterable <Message> messages = messageRepo.findAll();
        model.put("message",messages);
        return "/main";
    }
}