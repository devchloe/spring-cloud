package demo.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "itemservice")
public interface ItemResource {

    @GetMapping(value = "/", consumes = "application/json;charset=UTF-8")
    List<Item> findAll();

    @GetMapping("/{itemId}")
    Item getOne(@PathVariable("itemId") long itemId);
}
