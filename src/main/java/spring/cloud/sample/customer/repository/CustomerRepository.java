package spring.cloud.sample.customer.repository;

import spring.cloud.sample.customer.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
