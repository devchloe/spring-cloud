package demo.repository;

import demo.domain.Order;
import demo.domain.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class OrderRepository {

    private List<Order> orders;

    @Autowired
    private OrderRepository() {
        orders = new ArrayList<>();

        Order order1 = new Order(1);
        order1.getOrderItems().add(new OrderItem(1l, 5));
        order1.getOrderItems().add(new OrderItem(2l, 3));
        order1.getOrderItems().add(new OrderItem(4l, 2));
        order1.setId(1l);
        orders.add(order1);

        Order order2 = new Order(1);
        order2.getOrderItems().add(new OrderItem(1l, 5));
        order2.getOrderItems().add(new OrderItem(2l, 3));
        order2.getOrderItems().add(new OrderItem(4l, 2));
        order2.setId(2l);
        orders.add(order2);


        Order order3 = new Order(2);
        order3.getOrderItems().add(new OrderItem(3l, 2));
        order3.getOrderItems().add(new OrderItem(4l, 3));
        order3.getOrderItems().add(new OrderItem(5l, 1));
        order3.setId(3l);
        orders.add(order3);

        Order order4 = new Order(2);
        order4.getOrderItems().add(new OrderItem(1l, 2));
        order4.getOrderItems().add(new OrderItem(4l, 3));
        order4.setId(4l);
        orders.add(order4);
    }

    public Order save(Order order) {
        order.setId(5l);
        orders.add(order);

        return order;
    }

    public Order findOne(long orderId) {
        return orders.stream().filter(i -> (i.getId() == orderId)).findFirst().get();
    }

    public Collection<Order> findAll() {
        return orders;
    }

    public void delete(long id) {
        orders.remove(4);
    }
}
