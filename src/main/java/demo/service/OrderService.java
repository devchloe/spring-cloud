package demo.service;

import demo.repository.OrderRepository;
import demo.clients.CustomerApi;
import demo.clients.ItemApi;
import demo.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private CustomerApi customerApi;
    private ItemApi itemApi;

    @Autowired
    private OrderService(OrderRepository orderRepository, CustomerApi customerApi, ItemApi itemApi) {
        super();
        this.orderRepository = orderRepository;
        this.customerApi = customerApi;
        this.itemApi = itemApi;
    }

    public Order order(Order order) {
        if (order.getNumberOfItems() == 0) { throw new IllegalArgumentException("No items to order!"); }
        if (!customerApi.isValidCustomerId(order.getCustomerId())) { throw new IllegalArgumentException("Customer does not exist!"); }

        return orderRepository.save(order);
    }

    public double getPrice(long orderId) {
        return orderRepository.findOne(orderId).totalPrice(itemApi);
    }

    public Collection<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().forEach(e -> orders.add(e));
        return orders;
    }

}
