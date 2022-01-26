package mvc.controllers;


import mvc.entites.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import mvc.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductsController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/showProducts")
    public String showProducts(Model uiModel) {

        List<Product> products = productService.getProducts();

        uiModel.addAttribute("products", products);

        return "products";
    }

    @RequestMapping(path = "/showProductById/{sid}", method = RequestMethod.GET)
    public String showProductById(@PathVariable("sid") int id, Model uiModel) {
        Product product = productService.getProductId(id);
        uiModel.addAttribute("product", product);
        return "product";
    }

    @RequestMapping("/showForm")
    public String showFormProduct(Model uiModel) {
        Product product = new Product();
        uiModel.addAttribute("product", product);
        return "product-form";
    }


    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("product") Product product) {
        productService.setProduct(product);
        return "product";
    }


}
