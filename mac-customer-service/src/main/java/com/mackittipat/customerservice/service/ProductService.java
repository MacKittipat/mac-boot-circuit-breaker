package com.mackittipat.customerservice.service;

import com.mackittipat.customerservice.App;
import com.mackittipat.customerservice.model.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {

    private final static Logger log = LoggerFactory.getLogger(App.class);

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackProduct")
    public List<Product> findProductByCustomerId(int customerId) {

        log.info("Sending request to product service. customerId={}", customerId);

        ResponseEntity<List<Product>> productResponseEntity = restTemplate.exchange(
                "http://localhost:9002/products/customers/" + customerId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>(){}
        );

        return productResponseEntity.getBody();
    }

    public List<Product> fallbackProduct(int customerId) {

        log.info("Returning fallback product. customerId={}", customerId);

        return Collections.emptyList();
    }
}
