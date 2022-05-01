package com.example.demo.model;


import com.example.demo.exceptions.CodeLengthException;
import com.example.demo.exceptions.PriceLessThanZeroException;
import com.example.demo.exceptions.ProductExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public void addNewProduct(Product product) {
        Optional<Product> productByCode = productRepository
                .findProductByCode(product.getCode());

        if(productByCode.isPresent()){
            throw new ProductExistsException("Product with " + product.getCode() + " already exists!");
        }if(product.getCode().length()!=10){
            throw new CodeLengthException("Code " + product.getCode() +  " invalid");
        }if(product.getPriceHrk().compareTo(BigDecimal.ZERO)==-1){
            throw new PriceLessThanZeroException("Negative price");
        }
        productRepository.save(product);

    }

    public void deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if (!exists){
            throw new ProductExistsException("Product with id " + productId + " does not exist!");
        }
        productRepository.deleteById(productId);
    }

    @Transactional
    public void updateProduct(Long productId, String name, BigDecimal priceHrk) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductExistsException(
                        "Product with id " + productId + " does not exist."
                ));

        if (name!=null && name.length()>0 &&
                !Objects.equals(product.getName(), name)){
            product.setName(name);
        }

        if(priceHrk != null){
            if(priceHrk.compareTo(BigDecimal.ZERO)!=-1 &&
                    !Objects.equals(product.getPriceHrk(), priceHrk)){
                product.setPriceHrk(priceHrk);
            }
        }
    }


}
