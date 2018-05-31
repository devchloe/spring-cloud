package demo.controller;

import demo.clients.*;
import demo.domain.Order;
import demo.repository.OrderRepository;
import demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class OrderController {

    private OrderService orderService;
    private OrderRepository orderRepository;
    private CustomerApi customerApi;
    private ItemApi itemApi;

    @Autowired
    private OrderController(OrderService orderService, OrderRepository orderRepository, CustomerApi customerApi, ItemApi itemApi) {
        super();
        this.orderService = orderService;
        this.orderRepository = orderRepository;
        this.customerApi = customerApi;
        this.itemApi = itemApi;
    }

    @GetMapping("/items")
    public Collection<Item> getItems() { return itemApi.findAll(); }

    @GetMapping("/customers")
    public Collection<Customer> customers() { return customerApi.findAll(); }

    @GetMapping("/")
    public Collection<Order> orders() { return orderRepository.findAll(); }

    @GetMapping("/{id}")
    public Order get(@PathVariable("id") long id) {
        return orderRepository.findOne(id);
    }

    @GetMapping("/{id}/price")
    public double getPrice(@PathVariable("id") long id) {
        return orderService.getPrice(id);
    }

    @PostMapping("/")
    public String order(@RequestBody Order order) {
        orderService.order(order);
        return "Successfully ordered!";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        orderRepository.delete(id);
        return "Successfully deleted!";
    }
}
