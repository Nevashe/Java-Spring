package com.example.hm4.mvcAnother.serviceB;

import com.example.hm4.mvcAnother.entitesB.ProductB;
import com.example.hm4.mvcAnother.repositoriesB.ProductRepositoriesB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceB {
    private ProductRepositoriesB productRepositories = new ProductRepositoriesB();

    public List<ProductB> getProducts() {
        List<ProductB> products = productRepositories.getProducts();
        return products;
    }

    public ProductB getProductId(int id) {
        ProductB product = productRepositories.getProductId(id-1);
        return product;
    }
    @Autowired
    public void setProductRepository(ProductRepositoriesB productRepositories) {
        this.productRepositories = productRepositories;
    }

    public void setProduct(ProductB product) {
        productRepositories.setProduct(product);
    }
}
