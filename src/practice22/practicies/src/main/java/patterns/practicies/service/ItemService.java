package patterns.practicies.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import patterns.practicies.model.Item;
import patterns.practicies.repositories.ItemRepository;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll() {
        log.info("Find all items");
        return itemRepository.findAll();
    }

    public Item findOne(Integer id){
        log.info("Find item by id = {}", id);
        Optional<Item> foundItem = itemRepository.findById(id);
        return foundItem.orElse(null);
    }


    @Transactional
    public void save(Item item){
        log.info("Saving item: {}", item);
        itemRepository.save(item);
    }

    @Transactional
    public void update(Integer id, Item updatedItem){
        log.info("Updating item with id = {}. New item: {}" , id, updatedItem);
        updatedItem.setId(id);
        itemRepository.save(updatedItem);
    }

    @Transactional
    public void delete(Integer id){
        log.info("Removing item by id = {}", id);
        itemRepository.deleteById(id);
    }


    public List<Item> filterByName() {
        log.info("Getting all items sorted by name");
        return itemRepository.findAll(Sort.by("name"));
    }

    public List<Item> filterByDate() {
        log.info("Getting all items sorted by date");
        return itemRepository.findAll(Sort.by("date"));
    }

    public List<Item> filterByPrice() {
        log.info("Getting all items sorted by price");
        return itemRepository.findAll(Sort.by("price"));
    }
}
