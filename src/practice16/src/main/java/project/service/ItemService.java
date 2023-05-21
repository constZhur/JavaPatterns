package project.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.model.Item;

import java.util.List;


@Service
public class ItemService {

    private final SessionFactory sessionFactory;
//    private Session session;

    @Autowired
    public ItemService(SessionFactory sessionFactory) {
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
    public void addItem(Item item){
        Session session = sessionFactory.getCurrentSession();
        session.persist(item);
    }

    @Transactional
    public void deleteItem(Integer id){
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Item.class, id));
    }

    @Transactional
    public List<Item> show(){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Item p", Item.class).getResultList();
    }

    @Transactional
    public List<Item> filterByName() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Item> itemCriteriaQuery = builder.createQuery(Item.class);
        Root<Item>root = itemCriteriaQuery.from(Item.class);

        itemCriteriaQuery.select(root).orderBy(builder.asc(root.get("name")));
        Query<Item> query = session.createQuery(itemCriteriaQuery);
        return query.getResultList();
    }

    @Transactional
    public List<Item> filterByDate() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Item> itemCriteriaQuery = builder.createQuery(Item.class);
        Root<Item>root = itemCriteriaQuery.from(Item.class);

        itemCriteriaQuery.select(root).orderBy(builder.asc(root.get("date")));
        Query<Item> query = session.createQuery(itemCriteriaQuery);
        return query.getResultList();
    }

    @Transactional
    public List<Item> filterByPrice() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Item> itemCriteriaQuery = builder.createQuery(Item.class);
        Root<Item>root = itemCriteriaQuery.from(Item.class);

        itemCriteriaQuery.select(root).orderBy(builder.asc(root.get("price")));
        Query<Item> query = session.createQuery(itemCriteriaQuery);
        return query.getResultList();
    }
}
