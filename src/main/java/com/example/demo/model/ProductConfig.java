package com.example.demo.model;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            ProductRepository repository)
    {
        return args -> {
                    Product product1 = new Product(
                            "1234567891",
                            "ProdcutOne",
                            BigDecimal.valueOf(58),
                            "Description of product ProdcutOne",
                            Boolean.TRUE
                    );

                    Product product2 = new Product(
                            "12345678892",
                            "ProdcutTwo",
                            BigDecimal.valueOf(33),
                            "Description of product ProdcutTwo",
                            Boolean.TRUE
                    );
                    repository.saveAll(
                            List.of(product1, product2)
                    );
        };
    }
}
