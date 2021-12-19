package mvc.service;

import mvc.entites.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mvc.repositories.ProductRepositories;

import java.util.List;

@Service
public class ProductService {
    private ProductRepositories productRepositories = new ProductRepositories();

    public List<Product> getProducts() {
        List<Product> products = productRepositories.getProducts();
        return products;
    }

    public Product getProductId(int id) {
        Product product = productRepositories.getProductId(id-1);
        return product;
    }
    @Autowired
    public void setProductRepository(ProductRepositories productRepositories) {
        this.productRepositories = productRepositories;
    }

    public void setProduct(Product product) {
        productRepositories.setProduct(product);
    }
}
