package demo.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CustomerApi {

    private CustomerResource customerClient;

    @Autowired
    private CustomerApi(CustomerResource customerClient) {
        this.customerClient = customerClient;
    }

    public Collection<Customer> findAll() {
        return customerClient.findAll();
    }

    public Customer getOne(long customerId) {
        return customerClient.getOne(customerId);
    }

    // TODO throw exception
    public boolean isValidCustomerId(long customerId) {
        Customer customer = customerClient.getOne(customerId);
        if (null == customer) return false;
        return true;
    }
}
