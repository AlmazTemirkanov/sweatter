package com.example.controller;

import com.example.domain.Content;
import com.example.model.ContentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class ContentController {

    @Autowired
    private ContentRepo contentRepo;

    @PostMapping("filter_content")
    public String filter_content (@RequestParam String filter_content, Map<String, Object> model ) {
        Iterable <Content> content;
        if (filter_content !=null && !filter_content.isEmpty()){
            content = contentRepo.findByNumberIgnoreCaseContaining(filter_content);
        } else {
            content = contentRepo.findAll();
        }
        model.put("content", content);
        return "content";
    }

    @PostMapping("filter_content_admin")
    public String filter_content_admin (@RequestParam String filter_content_admin, Map<String, Object> model ) {
        Iterable <Content> content;
        if (filter_content_admin !=null && !filter_content_admin.isEmpty()){
            content = contentRepo.findByNumberIgnoreCaseContaining(filter_content_admin);
        } else {
            content = contentRepo.findAll();
        }
        model.put("content", content);
        return "content_admin";
    }

    @GetMapping("/filter_content")
    public String content (Map<String, Object> model) {
        return "content";
    }

    @GetMapping("/filter_content_admin")
    public String filter_content_admin (Map<String, Object> model) {
        return "content";
    }

    @GetMapping("/add_content")
    public String add_content (Map<String, Object> model) {
        Iterable <Content> contents = contentRepo.findAll();
        model.put("message",contents);
        return "add_content";
    }

    @PostMapping("add_content")
    public String add_content_new (@RequestParam String number, @RequestParam String type,
                                   @RequestParam String service, @RequestParam String provider,
                                   @RequestParam String tariff, @RequestParam String rounding,
                                   Model model){
        Content content = new Content (number, type, service, provider, tariff, rounding);
        contentRepo.save(content);
        return "content_admin";
    }

    @GetMapping ("/content_admin")
    public String content_admin (Model model){
        return "content_admin";
    }

    @GetMapping("/delete_content/{id}")
    public String delete_content(@PathVariable Integer id, Map<String, Object> model) {
        contentRepo.deleteById(id);
        return "redirect:/content_admin";
    }

    @GetMapping("/edit_content/{id}")
    public String edit_content (@PathVariable Integer id, Model model ) {
        Iterable <Content> contents = contentRepo.findAllById(id);

        model.addAttribute("number", contents);
        model.addAttribute("type", contents);
        model.addAttribute("service", contents);
        model.addAttribute("provider", contents);
        model.addAttribute("tariff", contents);
        model.addAttribute("rounding", contents);

        return "edit_content";
    }

    @PostMapping ("/update_content")
    public String update_content (@RequestParam (value = "id", required = false) Integer id,
                                  @ModelAttribute Content content){
        contentRepo.findAllById(id);
        contentRepo.save(content);
        return "content_admin";
    }



}
