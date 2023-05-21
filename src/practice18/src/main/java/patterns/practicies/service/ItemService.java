package patterns.practicies.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import patterns.practicies.model.Item;
import patterns.practicies.repositories.ItemRepository;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item findOne(Integer id){
        Optional<Item> foundItem = itemRepository.findById(id);
        return foundItem.orElse(null);
    }


    @Transactional
    public void save(Item item){
        itemRepository.save(item);
    }

    @Transactional
    public void update(Integer id, Item updatedItem){
        updatedItem.setId(id);
        itemRepository.save(updatedItem);
    }

    @Transactional
    public void delete(Integer id){
        itemRepository.deleteById(id);
    }


    public List<Item> filterByName() {
        return itemRepository.findAll(Sort.by("name"));
    }

    public List<Item> filterByDate() {
        return itemRepository.findAll(Sort.by("date"));
    }

    public List<Item> filterByPrice() {
        return itemRepository.findAll(Sort.by("price"));
    }
}
