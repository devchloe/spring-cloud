package demo.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "item")
public interface ItemClient {

    @GetMapping("/")
    List<Item> findAll();

    @GetMapping("/{itemId}")
    Item getOne(@PathVariable("itemId") long itemId);




}
