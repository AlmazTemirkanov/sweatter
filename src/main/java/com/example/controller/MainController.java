package com.example.controller;

import com.example.domain.Message;
import com.example.model.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;


    @GetMapping ("/")
    public String main(Model model){
        return "main";
    }

    @GetMapping("/login")
    public String login(Map<String, Object> model) {
        return "/login";
    }

    @GetMapping("/filter")
    public String filter(Map<String, Object> model) {
        return "/";
    }


//    @PostMapping ("filter")
//    public String filter(@RequestParam String filter, Map<String, Object> model){
//        Iterable <Message> messages;
//        if (filter !=null && !filter.isEmpty()){
//            messages = messageRepo.findBySeloIgnoreCaseStartingWith(filter);
//        } else {
//            messages = messageRepo.findAll();
//        }
//    model.put("messages", messages);
//    return "main";
//}

    @PostMapping ("filterAd")
    public String filterAd(@RequestParam String filterAd, Map<String, Object> model){
        Iterable <Message> messages;
       if (filterAd !=null && !filterAd.isEmpty()){
           messages = messageRepo.findBySeloIgnoreCaseStartingWith(filterAd);
       } else {
           messages = messageRepo.findAll();
       }
        model.put("messages", messages);
        return "/admin";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Map<String, Object> model) {
        messageRepo.deleteById(id);
        return "/admin";
    }

    @GetMapping("/admin")
    public String admin (Map<String, Object> model) {
        Iterable <Message> messages = messageRepo.findAll();
        model.put("message",messages);
        return "/admin";
    }


    @GetMapping("/add")
    public String add (Map<String, Object> model) {
        Iterable <Message> messages = messageRepo.findAll();
        model.put("message",messages);
        return "/add";
    }


    @PostMapping ("/add")
    public String add(@RequestParam String area, @RequestParam String district, @RequestParam String region, @RequestParam String selo,
                      @RequestParam String voice, @RequestParam String WCDMA, @RequestParam String LTE,
                       Map<String, Object> model){
        Message message = new Message(area, district, region, selo, voice, WCDMA, LTE);
        messageRepo.save(message);
        return "/admin";
    }

    @GetMapping("/edit/{id}")
    public String editId(@PathVariable Integer id, Model model ) {
        Iterable <Message> messages;
        messages = messageRepo.findAllById(id);

        model.addAttribute("area", messages);
        model.addAttribute("district", messages);
        model.addAttribute("region", messages);
        model.addAttribute("selo", messages);
        model.addAttribute("voice", messages);
        model.addAttribute("WCDMA", messages);
        model.addAttribute("LTE", messages);

        return "/edit";
    }

    @PostMapping ("/update")
    public String update (@RequestParam Integer id, @RequestParam String area, @RequestParam String district, @RequestParam String region, @RequestParam String selo,
                         @RequestParam String voice, @RequestParam String WCDMA, @RequestParam String LTE,
                          Model model){
        Iterable <Message> messages;
        return "/admin";
    }


}

