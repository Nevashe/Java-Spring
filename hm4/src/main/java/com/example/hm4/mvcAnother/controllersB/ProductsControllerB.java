package com.example.hm4.mvcAnother.controllersB;


import com.example.hm4.Hm4Application;
import com.example.hm4.mvcAnother.entitesB.ProductB;
import com.example.hm4.mvcAnother.serviceB.ProductServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductsControllerB {
    private ProductServiceB productService;

    @Autowired
    public void setProductService(ProductServiceB productService) {
        this.productService = productService;
    }

    @RequestMapping("/showProducts")
    public String showProducts(Model uiModel) {

        List<ProductB> products = productService.getProducts();

        uiModel.addAttribute("products", products);

            return "products";
    }

    @RequestMapping(path = "/showProductById/{sid}", method = RequestMethod.GET)
    public String showProductById(@PathVariable("sid") int id, Model uiModel) {
        ProductB product = productService.getProductId(id);
        uiModel.addAttribute("product", product);
        return "product";
    }

    @RequestMapping("/showForm")
    public String showFormProduct(Model uiModel) {
        ProductB product = new ProductB();
        uiModel.addAttribute("product", product);
        return "product-form";
    }


    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("product") ProductB product) {
        productService.setProduct(product);
        return "product";
    }
    @RequestMapping("/test")
    public String helloWorld() {
        return "index";
    }

}
