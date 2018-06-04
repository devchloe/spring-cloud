package spring.cloud.sample.controller;

import spring.cloud.sample.service.CustomerService;
import spring.cloud.sample.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    private CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public Collection<Customer> customers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable long id) {
        return customerService.findOne(id);
    }

    // TODO CRUD customer

}
