package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.Order;
import project.service.OrderService;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    private final OrderService orderService;

    @Autowired
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/showOrders")
    public String showOrders(Model model){
        List<Order> orderList = orderService.show();
        model.addAttribute("orders", orderList);
        return "orders/showOrders";
    }

    @GetMapping("/createOrder")
    public String createOrder(@RequestParam(value = "date", required = false) String orderDate, Model model){
        orderService.addOrder(new Order(orderDate));
//        model.addAttribute("order", orderDate);
        return "orders/createOrder";
    }

    @GetMapping("/deleteOrder")
    public String deleteOrder(@RequestParam(value = "id", required = false) Integer id, Model model){
        orderService.deleteItem(id);
//        model.addAttribute("order", orderDate);
        return "orders/deleteOrder";
    }
}
