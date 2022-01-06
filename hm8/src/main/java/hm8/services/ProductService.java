package hm8.services;

import hm8.entities.Product;
import hm8.repositories.ProductRepository;
import hm8.utils.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById((id));
        if (!product.isPresent()) {
            throw new ProductNotFoundException("Product with id = " + id + " not found");
        }
        return product.get();
    }

    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }
}