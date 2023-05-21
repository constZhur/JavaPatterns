package patterns.practicies;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Sort;
import patterns.practicies.model.Order;
import patterns.practicies.repositories.OrderRepository;
import patterns.practicies.service.OrderService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void testFindAll() {
        //given
        List<Order> orders = Arrays.asList(new Order(1, "Order 1"), new Order(2, "Order 2"));
        when(orderRepository.findAll()).thenReturn(orders);

        //when
        List<Order> result = orderService.findAll();

        //then
        assertEquals(orders, result);
    }

    @Test
    public void testFindOne() {
        //given
        int orderId = 1;
        Order order = new Order(orderId, "Order 1");
        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));

        //when
        Order result = orderService.findOne(orderId);

        //then
        assertEquals(order, result);
    }

    @Test
    public void testSave() {
        //given
        Order order = new Order(1, "Order 1");

        //when
        orderService.save(order);

        //then
        verify(orderRepository).save(order);
    }

    @Test
    public void testUpdate() {
        //given
        int orderId = 1;
        Order updatedOrder = new Order(orderId, "Updated Order");
        lenient().when(orderRepository.findById(orderId)).thenReturn(Optional.of(new Order(orderId, "Old Order")));

        //when
        orderService.update(orderId, updatedOrder);

        //then
        verify(orderRepository).save(updatedOrder);
    }

    @Test
    public void testDelete() {
        //given
        int orderId = 1;

        //when
        orderService.delete(orderId);

        //then
        verify(orderRepository).deleteById(orderId);
    }

    @Test
    public void testFilterByDate() {
        //given
        List<Order> orders = Arrays.asList(new Order(1, "Order 1"), new Order(2, "Order 2"));
        when(orderRepository.findAll(Sort.by("date"))).thenReturn(orders);

        //when
        List<Order> result = orderService.filterByDate();

        //then
        assertEquals(orders, result);
    }
}
