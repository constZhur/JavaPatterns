package patterns.practicies.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import patterns.practicies.model.Order;
import patterns.practicies.repositories.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional(readOnly = true)
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public List<Order> findAll() {
        log.info("Find all orders");
        return orderRepository.findAll();
    }

    public Order findOne(Integer id){
        log.info("Find order by id = {}", id);
        Optional<Order> foundOrder = orderRepository.findById(id);
        return foundOrder.orElse(null);
    }


    @Transactional
    public void save(Order order){
        log.info("Saving order: {}", order);
        orderRepository.save(order);
    }

    @Transactional
    public void update(Integer id, Order updatedOrder){
        log.info("Updating order with id = {}. New order: {}" , id, updatedOrder);
        updatedOrder.setId(id);
        orderRepository.save(updatedOrder);
    }

    @Transactional
    public void delete(Integer id){
        log.info("Removing order by id = {}", id);
        orderRepository.deleteById(id);
    }


    public List<Order> filterByDate() {
        log.info("Getting all orders sorted by date");
        return orderRepository.findAll(Sort.by("date"));
    }

}
