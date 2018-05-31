package demo.domain;

import demo.clients.ItemApi;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private long id;
    private long customerId;
    private List<OrderItem> orderItems;

    public Order() {
        super();
        orderItems = new ArrayList<OrderItem>();
    }

    public Order(long customerId) {
        super();
        this.customerId = customerId;
        this.orderItems = new ArrayList<OrderItem>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    // TODO addOrderItem, setCustomer

    public int getNumberOfItems() {
        return orderItems.size();
    }

    public double totalPrice(ItemApi itemApi) {
        return orderItems.stream()
                .map((ol) -> ol.getCount() * itemApi.price(ol.getItemId()))
                .reduce(0.0, (d1, d2) -> d1 + d2);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
