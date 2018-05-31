package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ItemApp {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemApp(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // TODO generateTestData() repository.save()

    public static void main(String[] args) {
        SpringApplication.run(ItemApp.class, args);
    }
}
