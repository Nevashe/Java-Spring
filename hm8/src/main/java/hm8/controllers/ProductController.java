package hm8.controllers;

import hm8.entities.Pages;
import hm8.entities.Product;
import hm8.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    @ModelAttribute("products")
    public List<Product> shopPage(Model model, @RequestParam int page) {

        //        List<Product> allProducts = productService.getAllProducts();
        List<Product> tenProducts;
        if(page == 0 || page == 1){
            tenProducts = productService.getTenProducts(1);
        }else {
            tenProducts = productService.getTenProducts(page);
        }
        long size = productService.getSizeProducts();

        //model.addAttribute("products", tenProducts);
        int tmp = ((int)size)%ProductService.getScrapProduct()== 0? 0:1;
        int numberPages = ((int)size)/ProductService.getScrapProduct()+tmp;

        List<Pages> pages = new ArrayList<>(numberPages);
        if(size>1){
            for (int i = 0; i < numberPages; i++) {
                pages.add(new Pages(i+1));
            }
        }
        model.addAttribute("pages", pages);
        return tenProducts;
    }

    @GetMapping("/products/{id}")
    @ModelAttribute("product")
    public String shopProduct(Model model, @PathVariable(value = "id") Long ProductId) {
        Product product = productService.getProductById(ProductId);
        model.addAttribute(product);
        return "product";
    }
    @PostMapping("/products")
    @ModelAttribute("products")
    public Product addProduct(@RequestBody Product product) {
        product.setId(0L);
        product = productService.saveOrUpdate(product);
        return product;
    }

    @PutMapping(path = "/products", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ModelAttribute("products")
    public Product updateProduct(@RequestBody Product product) {
        product = productService.saveOrUpdate(product);
        return product;
    }

    @ModelAttribute("products")
    @DeleteMapping(path="/remove/{id}")
    public String removeById(@PathVariable(value = "id") Long productId,
                             @RequestParam(value = "page") int page) {
        productService.removeById(productId);

        return "redirect:/products?page=" + page;
    }
}