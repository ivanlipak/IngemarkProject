package com.example.demo.model;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            ProductRepository repository)
    {
        return args -> {
                    Product a = new Product(
                            "324312423",
                            "naziv",
                            BigDecimal.valueOf(22),
                            BigDecimal.valueOf(22),
                            "fdsafsaf",
                            Boolean.TRUE
                    );

                    Product b = new Product(
                            "11111111",
                            "naziv3",
                            BigDecimal.valueOf(33),
                            BigDecimal.valueOf(33),
                            "fsfsdfasfdsaf",
                            Boolean.TRUE
                    );
                    repository.saveAll(
                            List.of(a,b)
                    );
        };
    }
}
