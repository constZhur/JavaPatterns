package patterns.practicies;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Sort;
import patterns.practicies.model.Item;
import patterns.practicies.repositories.ItemRepository;
import patterns.practicies.service.ItemService;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    private Item item1;
    private Item item2;

    @Before
    public void setUp() {
        item1 = new Item("item1", String.valueOf(new Date()), 10);
        item2 = new Item("item2", String.valueOf(new Date()), 20);
    }

    @Test
    public void testFindAll() {
        when(itemRepository.findAll()).thenReturn(Arrays.asList(item1, item2));

        List<Item> items = itemService.findAll();

        verify(itemRepository, times(1)).findAll();
        assertEquals(2, items.size());
        assertTrue(items.contains(item1));
        assertTrue(items.contains(item2));
    }

    @Test
    public void testFindOneWithExistingItem() {
        when(itemRepository.findById(1)).thenReturn(Optional.of(item1));

        Item foundItem = itemService.findOne(1);

        verify(itemRepository, times(1)).findById(1);
        assertNotNull(foundItem);
        assertEquals(item1, foundItem);
    }

    @Test
    public void testFindOneWithNonExistingItem() {
        when(itemRepository.findById(3)).thenReturn(Optional.empty());

        Item foundItem = itemService.findOne(3);

        verify(itemRepository, times(1)).findById(3);
        assertNull(foundItem);
    }

    @Test
    public void testSave() {
        itemService.save(item1);

        verify(itemRepository, times(1)).save(item1);
    }

    @Test
    public void testUpdate() {
        lenient().when(itemRepository.findById(1)).thenReturn(Optional.of(item1));

        Item updatedItem = new Item("updated item1", String.valueOf(new Date()), 15);
        itemService.update(1, updatedItem);

        verify(itemRepository, times(1)).save(updatedItem);
    }

    @Test
    public void testDelete() {
        itemService.delete(1);

        verify(itemRepository, times(1)).deleteById(1);
    }

    @Test
    public void testFilterByName() {
        when(itemRepository.findAll(Sort.by("name"))).thenReturn(Arrays.asList(item1, item2));

        List<Item> items = itemService.filterByName();

        verify(itemRepository, times(1)).findAll(Sort.by("name"));
        assertEquals(2, items.size());
        assertTrue(items.contains(item1));
        assertTrue(items.contains(item2));
    }

    @Test
    public void testFilterByDate() {
        when(itemRepository.findAll(Sort.by("date"))).thenReturn(Arrays.asList(item1, item2));

        List<Item> items = itemService.filterByDate();

        verify(itemRepository, times(1)).findAll(Sort.by("date"));
        assertEquals(2, items.size());
        assertTrue(items.contains(item1));
        assertTrue(items.contains(item2));
    }

    @Test
    public void testFilterByPrice() {
        when(itemRepository.findAll(Sort.by("price"))).thenReturn(Arrays.asList(item1, item2));

        List<Item> items = itemService.filterByPrice();

        verify(itemRepository, times(1)).findAll(Sort.by("price"));
        assertEquals(2, items.size());
        assertTrue(items.contains(item1));
        assertTrue(items.contains(item2));
    }
}
