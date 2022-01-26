package Market.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import Market.entites.Category;
import Market.entites.Product;
import Market.repositories.CategoriesRepository;
import Market.repositories.ProductRepository;
import Market.utils.exception.ImageNotSavesException;
import Market.utils.exception.ProductNotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private CategoriesRepository categoriesRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Autowired
    public void setCategoriesRepository(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
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

    public void saveImage(MultipartFile file, String fileName) {
        Path path = Paths.get("C:\\Users\\Aleksey\\JavaModule2\\Java-Spring-1\\" +
                "hm11\\src\\main\\resources\\static\\images\\products\\" + fileName + ".jpg");
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

    public Page<Product> getProductsWithPagingAndFiltering(int pageNumber, int pageSize, Specification<Product> productSpecification) {
        return productRepository.findAll(productSpecification, PageRequest.of(pageNumber, pageSize));
    }

}