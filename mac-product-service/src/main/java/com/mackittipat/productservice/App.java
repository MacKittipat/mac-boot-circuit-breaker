package com.mackittipat.productservice;

import com.mackittipat.productservice.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
public class App {

    private final static Logger log = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

    @RequestMapping("/products/customers/{customerId}")
    public List<Product> findByCustomerId(@PathVariable int customerId) {

        log.info("Finding products of customer (id={})", customerId);

        if(customerId > 1) {
            try {
                Thread.sleep(12000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Apple");
        product1.setPrice(30.00F);

        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Mango");
        product2.setPrice(20.00F);

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        return productList;
    }
}
