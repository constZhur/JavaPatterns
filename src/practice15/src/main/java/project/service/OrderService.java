package project.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.model.Order;

import java.util.List;

@Service
public class OrderService {
    private final SessionFactory sessionFactory;
//    private Session session;

    @Autowired
    public OrderService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//    @PostConstruct
//    private void init() {
//        session = sessionFactory.openSession();
//    }
//
//    @PreDestroy
//    private void finish() {
//        session.close();
//        sessionFactory.close();
//    }
    @Transactional
    public void addOrder(Order order){
        Session session = sessionFactory.getCurrentSession();
        session.persist(order);
    }

    @Transactional
    public void deleteItem(Integer id){
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Order.class, id));
    }

    @Transactional
    public List<Order> show(){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select o from Order o", Order.class).getResultList();
    }
}
