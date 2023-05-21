package project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.Item;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemsController {
    private List<Item> items = new ArrayList<>();

    @GetMapping("/createItem")
    public String createOrder(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "date", required = false) String date,
                              @RequestParam(value = "price", required = false) int price, Model model) {
        Item item = new Item(name, date, price);
        items.add(item);
        model.addAttribute("item", item);
        return "items/createItem";
    }

    @GetMapping("/showItems")
    public String showOrders(Model model){
        model.addAttribute("items", items);
        return "items/showItems";
    }

    @GetMapping("/deleteItem")
    public String deleteOrder(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "date", required = false) String date,
                              @RequestParam(value = "price", required = false) Integer price, Model model) {
        Item toDelete = new Item(name, date, price);
        items.removeIf(i -> i.getName().equals(name) && i.getCreationDate().equals(date) && i.getPrice().equals(price));
        model.addAttribute("item", toDelete);
        return "/items/deleteItem";
    }

}
