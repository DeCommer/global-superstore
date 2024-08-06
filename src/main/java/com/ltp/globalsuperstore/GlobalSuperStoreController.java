package com.ltp.globalsuperstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GlobalSuperStoreController {

    List<Item> items = new ArrayList<>();
    
    @GetMapping("/")
    public String getForm(Model model) {
        model.addAttribute("item", new Item()); //Bindes model to Item object.
        model.addAttribute("categories", Constants.CATEGORIES); //Maps to Constants.java array.
        return "form";
    }

    @PostMapping("/submitItem")
    public String submitItemHandler(Item item) {
        items.add(item);
        return "redirect:/inventory";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model) {
        model.addAttribute("items", items);
        return "inventory";
    }

    @PostMapping("/inventory")
    public String updateById(Model model, @RequestParam(required = false) String id) {
        System.out.println("id: " + id);
        return "form";
    }
}
