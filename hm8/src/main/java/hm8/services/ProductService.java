package hm8.services;

import hm8.entities.Category;
import hm8.entities.Product;
import hm8.repositories.CategoriesRepository;
import hm8.repositories.ProductRepository;
import hm8.utils.ImageNotSavesException;
import hm8.utils.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private CategoriesRepository categoriesRepository;


    private static final int scrapProduct = 2;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Autowired
    public void setCategoriesRepository(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
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

    public Boolean getProductByTitle(String s) {
        Optional<Product> product = productRepository.findByTitle(s);
        if (product.isPresent()) {
            throw new ProductNotFoundException("Product with name = " + s + " exists");
        }
        return false;
    }

    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }
    public void saveImage(MultipartFile file, String fileName) {
        Path path = Paths.get("C:\\Users\\Aleksey\\JavaModule2\\Java-Spring-1\\" +
                "hm8\\src\\main\\resources\\static\\images\\products\\" + fileName + ".jpg");
        try {
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            // место под логирование
        }
        if(Files.notExists(path)){
            throw new ImageNotSavesException("File save error");
        }
    }

    public Product save(Product product, MultipartFile file) {
        if(!getProductByTitle(product.getTitle())){
            String nameCategory = product.getId_category().getCategory();
            Optional<Category> category =  categoriesRepository.findByCategory(nameCategory);
            if(!category.isPresent()){
                Category categoryForSave = new Category(nameCategory);
                categoriesRepository.save(categoryForSave);
            } else {
                product.setId_category(category.get());
            }
            product.setPathImg(product.getTitle() + ".jpg");
            saveImage(file, product.getTitle());

            return productRepository.save(product);
        }
        return product;
    }
}