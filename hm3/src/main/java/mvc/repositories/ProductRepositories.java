//package mvc.repositories;
//
//import mvc.entites.Product;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class ProductRepositories {
//    private List<Product> products = new ArrayList<>();
//
//    public ProductRepositories() {
//        products.add(new Product(1, "apple", 1000));
//    }
//
//    public List<Product> getProducts() {
//        return products;
//    }
//    public Product getProductId(int id) {
//        return products.get(id);
//    }
//
//    public void setProduct(Product product) {
//        product.setId(products.size() + 1);
//        products.add(product);
//    }
//}
