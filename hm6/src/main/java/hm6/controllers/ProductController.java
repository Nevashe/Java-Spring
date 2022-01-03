package hm6.controllers;

import hm6.entities.Pages;
import hm6.entities.Product;
import hm6.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping("")
//    public String shopPage(Model model) {
//
//        //        List<Product> allProducts = productService.getAllProducts();
//        List<Product> tenProducts = productService.getTenProducts(1);
//        model.addAttribute("products", tenProducts);
//        return "products";
//    }

    @GetMapping("")
    public String shopPage(Model model, @RequestParam int page) {

        //        List<Product> allProducts = productService.getAllProducts();
        List<Product> tenProducts;
        if(page == 0 || page == 1){
            tenProducts = productService.getTenProducts(1);
        }else {
            tenProducts = productService.getTenProducts(page);
        }
        long size = productService.getSizeProducts();

        model.addAttribute("products", tenProducts);
        int tmp = ((int)size)%ProductService.getScrapProduct()== 0? 0:1;
        int numberPages = ((int)size)/ProductService.getScrapProduct()+tmp;

        List<Pages> pages = new ArrayList<>(numberPages);
        System.out.println(tmp);
        System.out.println(numberPages);
        if(size>1){
            for (int i = 0; i < numberPages; i++) {
                pages.add(new Pages(i+1));
            }
        }
        model.addAttribute("pages", pages);
        return "products";
    }
    @RequestMapping(path="/remove/{id}", method= RequestMethod.GET)
    public String removeById(@PathVariable(value = "id") Long productId,
                             @RequestParam(value = "page") int page) {
        productService.removeById(productId);

        return "redirect:/products?page=" + page;
    }
}