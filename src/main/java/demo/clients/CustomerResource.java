package demo.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@FeignClient(name = "customer")
public interface CustomerResource {

    @GetMapping("/")
    Collection<Customer> findAll();

    @GetMapping("/{customerId}")
    Customer getOne(@PathVariable("customerId") long customerId);

}
