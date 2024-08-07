package com.ltp.globalsuperstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// import com.ltp.globalsuperstore.Item;

@Controller
public class GlobalSuperStoreController {

    List<Item> items = new ArrayList<>();
    
    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) { //requestparam i sfor populating update fields in form
        // int idx = getIdxFromId(id);
        model.addAttribute("item", getIdxFromId(id) == Constants.NOT_FOUND ? new Item() : items.get(getIdxFromId(id))); //Bindes model to Item object.
        model.addAttribute("categories", Constants.CATEGORIES); //Maps to Constants.java array.
        return "form";
    }

    @PostMapping("/submitItem")
    public String submitItemHandler(Item item, RedirectAttributes redirectAttributes) {
        int idx = getIdxFromId(item.getId());

        if (idx == Constants.NOT_FOUND) {
            items.add(item);
        } else {
            items.set(idx, item);
        }
        // redirectAttributes.addFlashAttribute("status", Constants.SUCCESS_STATUS);
        return "redirect:/inventory";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model) {
        model.addAttribute("items", items);
        return "inventory";
    }

    public int getIdxFromId(String id) {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }

}