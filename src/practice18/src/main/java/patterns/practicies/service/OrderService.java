package patterns.practicies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import patterns.practicies.model.Order;
import patterns.practicies.repositories.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findOne(Integer id){
        Optional<Order> foundOrder = orderRepository.findById(id);
        return foundOrder.orElse(null);
    }


    @Transactional
    public void save(Order order){
        orderRepository.save(order);
    }

    @Transactional
    public void update(Integer id, Order updatedOrder){
        updatedOrder.setId(id);
        orderRepository.save(updatedOrder);
    }

    @Transactional
    public void delete(Integer id){
        orderRepository.deleteById(id);
    }


    public List<Order> filterByDate() {
        return orderRepository.findAll(Sort.by("date"));
    }

}
