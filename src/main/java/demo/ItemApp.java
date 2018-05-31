package demo;

import demo.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ItemApp {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemApp(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PostConstruct
    public void generateInitialData() {
        itemRepository.save(new Item("Banana", 550.0));
        itemRepository.save(new Item("Applie", 700.0));
        itemRepository.save(new Item("Strawberry", 4000.0));
        itemRepository.save(new Item("Peach", 5000.0));
        itemRepository.save(new Item("Water mellon", 9000.0));
    }

    public static void main(String[] args) {
        SpringApplication.run(ItemApp.class, args);
    }
}
