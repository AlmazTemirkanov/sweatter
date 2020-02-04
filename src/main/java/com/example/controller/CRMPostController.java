package com.example.controller;


import com.example.domain.CRMPost;
import com.example.model.CRMPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class CRMPostController {
    @Autowired
    private CRMPostRepo crmPostRepo;


    @GetMapping("/crmpost")
    public String filter_crm(@RequestParam(required = false) String filter_crmpost,
                             Model model) {
        Iterable <CRMPost> crmpost = null;
        if (filter_crmpost != null && !filter_crmpost.isEmpty()  ){
            crmpost = crmPostRepo.findBySrIgnoreCaseContaining(filter_crmpost);
        } else {
            crmPostRepo.findAll();
        }
        model.addAttribute("crmpost", crmpost);
        model.addAttribute("filter_crmpost", filter_crmpost);

        return "crmpost";
    }

    @GetMapping("/delete_crmpost/{id}")
    public String delete_crmpost(@PathVariable Integer id, Map<String, Object> model) {
        crmPostRepo.deleteById(id);
        return "redirect:/crmpost_admin";
    }

    @GetMapping("/crmpost_admin")
    public String filter_crmpost_admin(@RequestParam (required = false) String filter_crmpost_admin,
                                   Model model) {
        Iterable <CRMPost> crmpost = null;
        if (filter_crmpost_admin != null && !filter_crmpost_admin.isEmpty()  ){
            crmpost = crmPostRepo.findBySrIgnoreCaseContaining(filter_crmpost_admin);
        } else {
            crmPostRepo.findAll();
        }
        model.addAttribute("crmpost", crmpost);
        model.addAttribute("filter_crmpost_admin", filter_crmpost_admin);

        return "crmpost_admin";
    }

    @GetMapping("/add_crmpost")
    public String add_crmpost (Map<String, Object> model) {
        Iterable <CRMPost> crm = crmPostRepo.findAll();
        model.put("crmpost",crm);
        return "add_crmpost";
    }

    @PostMapping ("/add_crmpost")
    public String add_crmpost_new (@RequestParam String sr,
                               Model model){
        CRMPost crmpost = new CRMPost (sr);
        crmPostRepo.save(crmpost);
        return "crmpost_admin";
    }

    @GetMapping("/edit_crmpost/{id}")
    public String editId_crmpost(@PathVariable Integer id, Model model ) {
        Iterable<CRMPost> crmpost = crmPostRepo.findAllById(id);

        model.addAttribute("id", crmpost);
        model.addAttribute("sr", crmpost);
        return "edit_crmpost";
    }

    @PostMapping ("/update_crmpost")
    public String update (@RequestParam (value = "id", required = false) Integer id,
                          @ModelAttribute CRMPost crm){
        crmPostRepo.findAllById(id);
        crmPostRepo.save(crm);

        return "crmpost_admin";
    }

}
