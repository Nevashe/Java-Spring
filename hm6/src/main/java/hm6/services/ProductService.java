package hm6.services;

import hm6.entities.Product;
import hm6.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;



    private static final int scrapProduct = 2;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {

        List<Product> products = (List<Product>) productRepository.findAll();
      //  return Product.withCategory(products);
        return products;

    }

    public void removeById(Long productId) {
        productRepository.deleteById(productId);
    }

    public List<Product> getTenProducts(int num) {
        int shift = scrapProduct * (num - 1);
        int scrap = scrapProduct;
        return (List<Product>) productRepository.myQuery(shift, scrap);
    }


    public long getSizeProducts() {
        return productRepository.count();
    }
    public static int getScrapProduct() {
        return scrapProduct;
    }
}