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
    private CustomerClient customerClient;
    private ItemClient itemApi;

    @Autowired
    private OrderController(OrderService orderService, OrderRepository orderRepository, CustomerClient customerClient, ItemClient itemApi) {
        super();
        this.orderService = orderService;
        this.orderRepository = orderRepository;
        this.customerClient = customerClient;
        this.itemApi = itemApi;
    }

    @GetMapping("/items")
    @ResponseBody
    public Collection<Item> getItems() { return itemApi.findAll(); }

    @GetMapping("/customers")
    @ResponseBody
    public Collection<Customer> customers() { return customerClient.findAll(); }

    @GetMapping("/")
    @ResponseBody
    public Collection<Order> orders() { return orderService.getAllOrders(); }

    @GetMapping("/{id}")
    @ResponseBody
    public Order get(@PathVariable("id") long id) {
        return orderRepository.findOne(id);
    }

    @GetMapping("/{id}/price")
    @ResponseBody
    public double getPrice(@PathVariable("id") long id) {
        return orderService.getPrice(id);
    }

    @PostMapping("/")
    @ResponseBody
    public Order order(@RequestBody Order order) {
        return orderService.order(order);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable long id) {
        orderRepository.delete(id);
    }
}
