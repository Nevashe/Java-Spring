package com.example.hm4.mvcAnother.repositoriesB;

import com.example.hm4.mvcAnother.entitesB.ProductB;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepositoriesB {
    private List<ProductB> products = new ArrayList<>();

    public ProductRepositoriesB() {
        products.add(new ProductB(1, "apple", 1000));
    }

    public List<ProductB> getProducts() {
        return products;
    }
    public ProductB getProductId(int id) {
        return products.get(id);
    }

    public void setProduct(ProductB product) {
        product.setId(products.size() + 1);
        products.add(product);
    }
}
