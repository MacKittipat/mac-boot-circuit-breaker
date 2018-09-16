package com.mackittipat.customerservice;

import com.mackittipat.customerservice.model.Customer;
import com.mackittipat.customerservice.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableCircuitBreaker
@SpringBootApplication
public class App {

    private final static Logger log = LoggerFactory.getLogger(App.class);

    @Autowired
    private ProductService productService;

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

    @RequestMapping("/customers/{id}")
    public Customer findCustomer(@PathVariable int id) {

        log.info("Finding customer (id={})", id);

        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Mac");
        customer.setPurchasedProductList(productService.findProductByCustomerId(id));

        return customer;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
