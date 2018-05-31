package demo;

import demo.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findOne(long id) {
        Customer customer = customerRepository.findOne(id);
        if (null == customer) throw new IllegalArgumentException("Customer does not exist!");

        return customerRepository.findOne(id);
    }
}
