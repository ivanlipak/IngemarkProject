package com.example.demo.model;



import org.json.JSONArray;
import org.json.JSONObject;
import javax.persistence.*;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


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
    @Transient
    private BigDecimal priceEur;
    private String description;
    private Boolean isAvailable;

    public Product(long id, String code, String name, BigDecimal priceHrk,
                    String description, Boolean isAvailable) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.priceHrk = priceHrk;
        this.description = description;
        this.isAvailable = isAvailable;
    }

    public Product(){
    }

    public Product(String code, String name, BigDecimal priceHrk,
                    String description, Boolean isAvailable) {
        this.code = code;
        this.name = name;
        this.priceHrk = priceHrk;
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

    public BigDecimal getPriceEur() {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.hnb.hr/tecajn/v1?valuta=EUR")).build();
        String object = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();

        JSONArray jsonArray = new JSONArray(object);
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        String eurString = jsonObject.getString("Srednji za devize");
        BigDecimal eur = new BigDecimal(eurString
                .replace(',', '.'));
        return eur.multiply(this.priceHrk);
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
                ", priceEur=" + getPriceEur() +
                ", description='" + description + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
