package com.example.controller;

import com.example.domain.Prepaid;
import com.example.model.PrepaidRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@Controller
public class PrepaidController {

    @Autowired
    private PrepaidRepo prepaidRepo;

    @PostMapping("filter_prepaid")
    public String filter_prepaid(@RequestParam String filter_prepaid, Map<String, Object> model) {
        Iterable <Prepaid> prepaid;
        if (filter_prepaid !=null && !filter_prepaid.isEmpty()){
            prepaid = prepaidRepo.findBycountryIgnoreCaseContaining(filter_prepaid);
        } else {
            prepaid = prepaidRepo.findAll();
        }
        model.put("prepaid", prepaid);

        return "prepaid";
    }

    @GetMapping("/prepaid_admin")
    public String prepaid_admin (Map<String, Object> model) {
        Iterable <Prepaid> prepaid = prepaidRepo.findAll();
        model.put("message", prepaid);
        return "prepaid_admin";
    }

    @PostMapping("filter_prepaid_admin")
    public String filter_prepaid_admin(@RequestParam String filter_prepaid_admin, Map<String, Object> model) {
        Iterable <Prepaid> prepaid;
        if (filter_prepaid_admin !=null && !filter_prepaid_admin.isEmpty()){
            prepaid = prepaidRepo.findBycountryIgnoreCaseContaining(filter_prepaid_admin);
        } else {
            prepaid = prepaidRepo.findAll();
        }
        model.put("prepaid", prepaid);

        return "prepaid_admin";
    }

    @GetMapping("/filter_prepaid_admin")
    public String filter_prepaid_admin (Map<String, Object> model) {
        Iterable <Prepaid> prepaid = prepaidRepo.findAll();
        model.put("message", prepaid);
        return "prepaid_admin";
    }

    @GetMapping("/delete_prepaid/{id}")
    public String delete_prepaid(@PathVariable Integer id, Map<String, Object> model) {
        prepaidRepo.deleteById(id);
        return "redirect:/prepaid_admin";
    }

    @GetMapping("/edit_prepaid/{id}")
    public String edit_prepaidID (@PathVariable Integer id, Model model ) {
        Iterable <Prepaid> messages = prepaidRepo.findAllById(id);

        model.addAttribute("id", messages);
        model.addAttribute("tariff_zone", messages);
        model.addAttribute("country", messages);
        model.addAttribute("company", messages);
        model.addAttribute("name_network", messages);
        model.addAttribute("mnc", messages);
        model.addAttribute("pmn", messages);
        model.addAttribute("network", messages);

        return "edit_prepaid";
    }

    @PostMapping ("/update_prepaid")
    public String update_prepaid (@RequestParam (value = "id", required = false) Integer id,
                                  @ModelAttribute Prepaid prepaid){
        prepaidRepo.findAllById(id);
        prepaidRepo.save(prepaid);
        return "prepaid_admin";
    }

    @GetMapping("/add_prepaid")
    public String add_prepaid (Map<String, Object> model) {
        Iterable <Prepaid> messages = prepaidRepo.findAll();
        model.put("message",messages);
        return "add_prepaid";
    }

    @PostMapping ("/add_prepaid")
    public String add_prepaid_new (@RequestParam String tariff_zone, @RequestParam String country,
                               @RequestParam String company, @RequestParam String name_network,
                               @RequestParam String mnc, @RequestParam String pmn,
                               @RequestParam String network,
                               Model model){
        Prepaid prepaid = new Prepaid (tariff_zone, country, company, name_network, mnc, pmn, network);
        prepaidRepo.save(prepaid);
        return "prepaid_admin";
    }

}
