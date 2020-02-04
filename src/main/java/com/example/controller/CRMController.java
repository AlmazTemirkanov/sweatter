package com.example.controller;

import com.example.domain.CRM;
import com.example.model.CRMRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class CRMController {

    @Autowired
    private CRMRepo crmRepo;


    @GetMapping("/crm")
    public String filter_crm(@RequestParam (required = false) String filter_crm,
                             Model model) {
        Iterable <CRM> crm = null;
        if (filter_crm != null && !filter_crm.isEmpty()  ){
            crm = crmRepo.findBySrIgnoreCaseContaining(filter_crm);
        } else {
            crmRepo.findAll();
        }
        model.addAttribute("crm", crm);
        model.addAttribute("filter_crm", filter_crm);

        return "crm";
    }

    @GetMapping("/delete_crm/{id}")
    public String delete_crm(@PathVariable Integer id, Map<String, Object> model) {
        crmRepo.deleteById(id);
        return "redirect:/crm_admin";
    }

    @GetMapping("/crm_admin")
    public String filter_crm_admin(@RequestParam (required = false) String filter_crm_admin,
                           Model model) {
        Iterable <CRM> crm = null;
        if (filter_crm_admin != null && !filter_crm_admin.isEmpty()  ){
            crm = crmRepo.findBySrIgnoreCaseContaining(filter_crm_admin);
        } else {
            crmRepo.findAll();
        }
        model.addAttribute("crm", crm);
        model.addAttribute("filter_crm_admin", filter_crm_admin);

        return "crm_admin";
    }

    @GetMapping("/add_crm")
    public String add_crm (Map<String, Object> model) {
        Iterable <CRM> crm = crmRepo.findAll();
        model.put("crm",crm);
        return "add_crm";
    }

    @PostMapping ("/add_crm")
    public String add_crm_new (@RequestParam String sr,
                               Model model){
        CRM crm = new CRM (sr);
        crmRepo.save(crm);
        return "crm_admin";
    }

    @GetMapping("/edit_crm/{id}")
    public String editId_crm(@PathVariable Integer id, Model model ) {
        Iterable<CRM> crm = crmRepo.findAllById(id);

        model.addAttribute("id", crm);
        model.addAttribute("sr", crm);
        return "edit_crm";
    }

    @PostMapping ("/update_crm")
    public String update (@RequestParam (value = "id", required = false) Integer id,
                          @ModelAttribute CRM crm){
        crmRepo.findAllById(id);
        crmRepo.save(crm);

        return "crm_admin";
    }

}
