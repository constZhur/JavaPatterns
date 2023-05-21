package project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.Order;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    private List <Order> orders = new ArrayList<>();

    @GetMapping("/createOrder")
    public String createOrder(@RequestParam(value = "date", required = false) String orderDate, Model model){
        Order order = new Order(orderDate);
        orders.add(order);
        model.addAttribute("order", orderDate);
        return "orders/createOrder";
    }

    @GetMapping("/showOrders")
    public String showOrders(Model model){
        model.addAttribute("orders", orders);
        return "orders/showOrders";
    }

    @GetMapping("/deleteOrder")
    public String deleteOrder(@RequestParam(value = "date", required = false) String orderDate, Model model){
        orders.removeIf(i -> i.getOrderDate().equals(orderDate));
        model.addAttribute("order", orderDate);
        return "/orders/deleteOrder";
    }
}
