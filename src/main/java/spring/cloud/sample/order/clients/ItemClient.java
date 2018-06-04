package spring.cloud.sample.order.clients;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ItemClient {

    private ItemResource itemClient;
    private Collection<Item> itemsCache = null;

    @Autowired
    public ItemClient(ItemResource itemClient) {
        this.itemClient = itemClient;
    }

    @HystrixCommand(fallbackMethod = "getItemsCache")
    public Collection<Item> findAll() {
        this.itemsCache = itemClient.findAll();
        return itemClient.findAll();
    }

    public Collection<Item> getItemsCache() {
        return itemsCache;
    }

    @HystrixCommand(fallbackMethod = "getOneCache")
    public Item getOne(long itemId) {
        return itemClient.getOne(itemId);
    }

    public Item getOneCache(long itemId) {
        return itemsCache.stream().filter(i -> (i.getItemId() == itemId)).findFirst().get();
    }

    @HystrixCommand(fallbackMethod = "priceCache")
    public double price(long itemId) {
        return itemClient.getOne(itemId).getPrice();
    }

    public double priceCache(long itemId) {
        return getOneCache(itemId).getPrice();
    }

}
