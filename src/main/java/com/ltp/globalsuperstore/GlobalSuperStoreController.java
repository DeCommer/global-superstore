package com.ltp.globalsuperstore;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GlobalSuperStoreController {
    
    @GetMapping("/")
    public String getForm(Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("categories", Constants.CATEGORIES);
        return "form";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model) {
        model.addAttribute("inventory");
        return "inventory";
    }
}
