package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class CustomerApp {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerApp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // TODO generateTestData() customerRepository.save()
    
    public static void main(String[] args) {
        SpringApplication.run(CustomerApp.class, args);
    }
}
