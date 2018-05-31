package demo;

import demo.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    private ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item findOne(long id) {
        Item item = itemRepository.findOne(id);
        if (null == item) throw new IllegalArgumentException("Item does not exist!");

        return itemRepository.findOne(id);
    }
}
