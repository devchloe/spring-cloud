package item;

import item.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public Collection<Item> items() throws Exception {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Item get(@PathVariable long id) {
        return itemService.findOne(id);
    }

    // TODO CRUD item
    // TODO search item : findByNameContaining(@Param("name") String name), findByName(@Param("name") String name)
}
