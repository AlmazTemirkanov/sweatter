package com.example.controller;

import com.example.domain.Postpaid;
import com.example.model.PostpaidRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@Controller
public class PostpaidController {

    @Autowired
    private PostpaidRepo postpaidRepo;

    @PostMapping("filter_postpaid")
    public String filter_postpaid (@RequestParam String filter_postpaid, Map<String, Object> model ) {
        Iterable <Postpaid> postpaid;
        if (filter_postpaid !=null && !filter_postpaid.isEmpty()){
            postpaid = postpaidRepo.findByCountryIgnoreCaseStartingWith(filter_postpaid);
        } else {
            postpaid = postpaidRepo.findAll();
        }
        model.put("postpaid", postpaid);
        return "postpaid";


    }

    @GetMapping("/postpaid_admin")
    public String postpaid_admin (Map<String, Object> model) {
        Iterable <Postpaid> postpaid = postpaidRepo.findAll();
        model.put("message", postpaid);
        return "postpaid_admin";
    }

    @PostMapping("filter_postpaid_admin")
    public String filter_postpaid_admin(@RequestParam String filter_postpaid_admin, Map<String, Object> model) {
        Iterable <Postpaid> postpaid;
        if (filter_postpaid_admin !=null && !filter_postpaid_admin.isEmpty()){
            postpaid = postpaidRepo.findByCountryIgnoreCaseStartingWith(filter_postpaid_admin);
        } else {
            postpaid = postpaidRepo.findAll();
        }
        model.put("postpaid", postpaid);

        return "postpaid_admin";
    }

    @GetMapping("/delete_postpaid/{id}")
    public String delete_postpaid(@PathVariable Integer id, Map<String, Object> model) {
        postpaidRepo.deleteById(id);
        return "redirect:/postpaid_admin";
    }

    @GetMapping("/edit_postpaid/{id}")
    public String edit_postpaid (@PathVariable Integer id, Model model ) {
        Iterable <Postpaid> messages = postpaidRepo.findAllById(id);

        model.addAttribute("id", messages);
        model.addAttribute("tariff_zone", messages);
        model.addAttribute("country", messages);
        model.addAttribute("company", messages);
        model.addAttribute("name_network", messages);
        model.addAttribute("mnc", messages);
        model.addAttribute("pmn", messages);
        model.addAttribute("network", messages);

        return "edit_postpaid";
    }

    @PostMapping ("/update_postpaid")
    public String update_postpaid (@RequestParam (value = "id", required = false) Integer id,
                                   @ModelAttribute Postpaid postpaid){
        postpaidRepo.findAllById(id);
        postpaidRepo.save(postpaid);
        return "postpaid_admin";
    }
    @GetMapping("/add_postpaid")
    public String add_postpaid (Map<String, Object> model) {
        Iterable <Postpaid> messages = postpaidRepo.findAll();
        model.put("message",messages);
        return "add_postpaid";
    }

    @PostMapping ("/add_postpaid")
    public String add_postpaid_new (@RequestParam String tariff_zone, @RequestParam String country,
                                @RequestParam String company, @RequestParam String name_network,
                                @RequestParam String mnc, @RequestParam String pmn,
                                @RequestParam String network,
                                Model model){
        Postpaid postpaid = new Postpaid (tariff_zone, country, company, name_network, mnc, pmn, network);
        postpaidRepo.save(postpaid);
        return "postpaid_admin";
    }
}
