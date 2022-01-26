package Market.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import Market.entites.Product;
import Market.services.ProductService;

@Controller
@RequestMapping("/admins")
public class AdminController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String adminsPanel() {
        return "admins";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        model.addAttribute("products", new Product());
        return "productForm";
    }

    @PostMapping(value  = "/addProduct",
            produces ={"application/json"})
    public String addProduct(@ModelAttribute Product p, MultipartFile file) {
        Product product = p;
        product.setId(0L);
        productService.save(product, file);
        return "/admins";
    }
}
