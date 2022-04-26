package com.example.demo.model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.persistence.*;
import javax.persistence.Id;
import java.io.*;
import java.math.BigDecimal;

@Entity
@Table
public class Product{

    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;
    private String code;
    private String name;
    private BigDecimal priceHrk;
    private BigDecimal priceEur;
    private String description;
    private Boolean isAvailable;

    public Product(long id, String code, String name, BigDecimal priceHrk, BigDecimal priceEur, String description, Boolean isAvailable) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.priceHrk = priceHrk;
        this.priceEur = priceEur;
        this.description = description;
        this.isAvailable = isAvailable;
    }

    public Product(){
    }

    public Product(String code, String name, BigDecimal priceHrk, BigDecimal priceEur, String description, Boolean isAvailable) {
        this.code = code;
        this.name = name;
        this.priceHrk = priceHrk;
        this.priceEur = priceEur;
        this.description = description;
        this.isAvailable = isAvailable;
    }

    public void setPriceEur(BigDecimal priceEur) {
        this.priceEur = priceEur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPriceHrk() {
        return priceHrk;
    }

    public void setPriceHrk(BigDecimal priceHrk) {
        this.priceHrk = priceHrk;
    }

    public BigDecimal getPriceEur(){
        return this.priceEur;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", priceHrk=" + priceHrk +
                ", priceEur=" + priceEur +
                ", description='" + description + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
