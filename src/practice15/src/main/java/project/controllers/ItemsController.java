package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.Item;
import project.service.ItemService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemsController {
    private final ItemService itemService;

    @Autowired
    ItemsController(ItemService itemService){
        this.itemService = itemService;
    }

//    @GetMapping()
//    public String showItems(Model model){
//        model.addAttribute("items", itemService.show());
//        return "/items";
//    }
//
//    @GetMapping("/createItem")
//    public String createItem(Model model){
//        return "redirect:/items";
//    }
//
//    @GetMapping("/deleteItem")
//    public String deleteItem(Model model){
//        return "redirect:/items";
//    }
//    private List<Item> items = new ArrayList<>();
    @GetMapping("/showItems")
    public String showItem(Model model){
        List<Item> itemList = itemService.show();
        model.addAttribute("items", itemList);
        return "items/showItems";
    }


    @GetMapping("/createItem")
    public String createItem(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "date", required = false) String date,
                              @RequestParam(value = "price", required = false) Integer price) {
        itemService.addItem(new Item(name, date, price));
        return "items/createItem";
    }


    @GetMapping("/deleteItem")
    public String deleteItem(@RequestParam(value = "id", required = false) Integer id, Model model) {
        itemService.deleteItem(id);
        return "items/deleteItem";
    }

}
