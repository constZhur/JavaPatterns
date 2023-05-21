package patterns.practicies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import patterns.practicies.model.Item;
import patterns.practicies.service.ItemService;

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
    public String showItems(Model model){
        model.addAttribute("items", itemService.findAll());
        return "items/showItems";
    }


    @GetMapping("/createItem")
    public String createItem(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "date", required = false) String date,
                              @RequestParam(value = "price", required = false) Integer price) {
        itemService.save(new Item(name, date, price));
        return "items/createItem";
    }


    @GetMapping("/deleteItem")
    public String deleteItem(@RequestParam(value = "id", required = false) Integer id, Model model) {
        itemService.delete(id);
        return "items/deleteItem";
    }

    @GetMapping("/sortedByDate")
    @ResponseBody
    public String showItemsSortedByDate() {
        return itemService.filterByDate().toString();
    }

    @GetMapping("/sortedByName")
    @ResponseBody
    public String showItemsSortedByName() {
        return itemService.filterByName().toString();
    }

    @GetMapping("/sortedByPrice")
    @ResponseBody
    public String showItemsSortedByPrice() {
        return itemService.filterByPrice().toString();
    }
}
