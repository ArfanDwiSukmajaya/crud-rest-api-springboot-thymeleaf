package com.example.frontend.controller;

import com.example.frontend.model.Region;
import com.example.frontend.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/region")
public class RegionController {
    final RegionService regionService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("regions", regionService.getAll());
        return "region/index";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model){
        model.addAttribute("region", regionService.getById(id));
        return "region/detail";
    }

    // Create Data
    @GetMapping("/create")
    public String create(Region region){
        return "region/create_form";
    }
    
    @PostMapping
    public String created(Region region){
        System.out.println("tanggl" + region.getRegion_date());
        regionService.create(region);
        return "redirect:/region";

    }
//    Update
    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model){
        model.addAttribute("region", regionService.getById(id));
        return "region/update_form";
    }

    @PutMapping("/{id}")
    public String updated(@PathVariable Long id, Region region){
        regionService.update(id, region);
        return "redirect:/region";
    }

//    Delete data
    @DeleteMapping("/{id}")
    public String deleted(@PathVariable Long id){
        regionService.delete(id);
        return "redirect:/region";
    }


}
