package com.example.controller;

import com.example.domain.SMS;
import com.example.model.SMSRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class SMSController {

    @Autowired
    private SMSRepo smsRepo;

    @GetMapping("/sms")
    public String filter_sms (@RequestParam (required = false) String filter_sms, Model model ) {
        Iterable <SMS> sms = null;
        if (filter_sms !=null && !filter_sms.isEmpty()){
            sms = smsRepo.findByDateIgnoreCaseContaining(filter_sms);
        } else {
            smsRepo.findAll();
        }
        model.addAttribute("sms", sms);
        model.addAttribute("filter_sms", filter_sms);
        return "sms";
    }

    @GetMapping("/sms_admin")
    public String filter_sms_admin (@RequestParam (required = false) String filter_sms_admin, Model model ) {
        Iterable <SMS> sms = null;
        if (filter_sms_admin !=null && !filter_sms_admin.isEmpty()){
            sms = smsRepo.findByDateIgnoreCaseContaining(filter_sms_admin);
        } else {
            smsRepo.findAll();
        }
        model.addAttribute("sms", sms);
        model.addAttribute("filter_sms_admin", filter_sms_admin);
        return "sms_admin";
    }

    @GetMapping("/add_sms")
    public String add_sms (Map<String, Object> model) {
        Iterable <SMS> sms = smsRepo.findAll();
        model.put("sms",sms);
        return "add_sms";
    }

    @PostMapping("add_sms")
    public String add_sms_new (@RequestParam String date, @RequestParam String topic,
                               @RequestParam String initiator, @RequestParam String text_topic,
                               @RequestParam String pull, @RequestParam String comments,
                               Model model){
        SMS sms = new SMS (date, topic, initiator, text_topic, pull, comments);
        smsRepo.save(sms);
        return "sms_admin";
    }

    @GetMapping("/delete_sms/{id}")
    public String delete_sms(@PathVariable Integer id, Map<String, Object> model) {
        smsRepo.deleteById(id);
        return "redirect:/sms_admin";
    }


    @GetMapping("/edit_sms/{id}")
    public String editId_sms(@PathVariable Integer id, Model model ) {
        Iterable<SMS> sms = smsRepo.findAllById(id);

        model.addAttribute("id", sms);
        model.addAttribute("date", sms);
        model.addAttribute("topic", sms);
        model.addAttribute("initiator", sms);
        model.addAttribute("text_topic", sms);
        model.addAttribute("pull", sms);
        model.addAttribute("comments", sms);

        return "edit_sms";
    }

    @PostMapping ("/update_sms")
    public String update_sms (@RequestParam (value = "id", required = false) Integer id,
                          @ModelAttribute SMS sms){
        smsRepo.findById(id);
        smsRepo.save(sms);

        return "sms_admin";
    }


}
