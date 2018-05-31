package demo;

import demo.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CustomerApp {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerApp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostConstruct
    public void generateInitialData() {
        customerRepository.save(new Customer("Willams", "James", "Willams.James@some.com", "Allston Street", "Anacortes"));
        customerRepository.save(new Customer("Davis", "Andrew", "Davis.Andrew@some.com", "Market Street", "Bellevue"));
        customerRepository.save(new Customer("Martinez", "Mason", "Martinez.Mason@some.com", "Harvard Avenue", "Buckley"));
        customerRepository.save(new Customer("Willams", "Tyler", "Willams.Tyler@some.com", "Chiswick Road", "Carnation"));
        customerRepository.save(new Customer("Wilson", "Lucas", "Wilson.Lucas@some.com", "St. Paul Street", "Duvall"));
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerApp.class, args);
    }
}
