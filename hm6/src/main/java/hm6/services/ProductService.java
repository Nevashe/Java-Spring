package hm6.services;

import hm6.entities.Product;
import hm6.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {

        List<Product> products = (List<Product>) productRepository.findAll();
      //  return Product.withCategory(products);
        return products;

    }
}