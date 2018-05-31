package demo;

import demo.domain.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class ItemRepository {

    List<Item> items;

    private ItemRepository() {
        items = new ArrayList<>();

        items.add(new Item("바나나", 550));
        items.add(new Item("사과", 700));
        items.add(new Item("딸기", 4000));
        items.add(new Item("참외", 600));
        items.add(new Item("수박", 9000));

        items.get(0).setId(1l);
        items.get(1).setId(2l);
        items.get(2).setId(3l);
        items.get(3).setId(4l);
        items.get(4).setId(5l);
    }

    public Collection<Item> findAll() {
        return items;
    }

    public Item findOne(long id) {
        if(id == 1l) return items.get(0);
        else if (id == 2l) return items.get(1);
        else if (id == 3l) return items.get(2);
        else if (id == 4l) return items.get(3);
        else if (id == 5l) return items.get(4);

        return null;
    }
}
