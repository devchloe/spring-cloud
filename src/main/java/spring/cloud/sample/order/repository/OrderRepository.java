package spring.cloud.sample.order.repository;

import spring.cloud.sample.order.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
