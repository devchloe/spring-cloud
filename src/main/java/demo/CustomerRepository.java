package demo;

import demo.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class CustomerRepository {

    List<Customer> customers;

    private CustomerRepository() {
        customers = new ArrayList<Customer>();
        customers.add(new Customer("Eberhard", "Wolff",
                "eberhard.wolff@gmail.com", "Unter den Linden", "Berlin"));
        customers.add(new Customer("Rod", "Johnson",
                "rod@somewhere.com", "Market Street", "San Francisco"));
        customers.get(0).setId(1l);
        customers.get(1).setId(2l);
    }

    public Collection<Customer> findAll() {
        return customers;
    }

    public Customer findOne(long id) {
        if (id == 1l) return customers.get(0);
        else if (id == 2l) return customers.get(1);

        return null;
    }
}
