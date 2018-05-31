package demo;

import demo.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ItemController {

    private ItemService itemService;
    private ItemRepository itemRepository;

    @Autowired
    private ItemController(ItemService itemService, ItemRepository itemRepository) {
        this.itemService = itemService;
        this.itemRepository = itemRepository;
    }

    @GetMapping("/")
    public Collection<Item> items() throws Exception {
//        throw new Exception("!!");
        return itemRepository.findAll();
    }

    @GetMapping("/{id}")
    public Item get(@PathVariable long id) {
        return itemService.findOne(id);
    }

    // TODO CRUD item
    // TODO search item : findByNameContaining(@Param("name") String name), findByName(@Param("name") String name)
}
