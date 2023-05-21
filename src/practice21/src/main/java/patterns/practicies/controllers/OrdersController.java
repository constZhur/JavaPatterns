package patterns.practicies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import patterns.practicies.model.Order;
import patterns.practicies.service.OrderService;

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
        model.addAttribute("orders", orderService.findAll());
        return "orders/showOrders";
    }

    @GetMapping("/createOrder")
    public String createOrder(@RequestParam(value = "date", required = false) String orderDate, Model model){
        orderService.save(new Order(orderDate));
        model.addAttribute("order", orderDate);
        return "orders/createOrder";
    }

    @GetMapping("/deleteOrder")
    public String deleteOrder(@RequestParam(value = "id", required = false) Integer id, Model model){
        orderService.delete(id);
//        model.addAttribute("order", orderDate);
        return "orders/deleteOrder";
    }


    @GetMapping("/sortedByDate")
    @ResponseBody
    public String showItemsSortedByDate() {
        return orderService.filterByDate().toString();
    }
}
