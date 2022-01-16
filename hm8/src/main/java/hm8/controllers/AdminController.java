package hm8.controllers;

import hm8.entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admins")
public class AdminController {

    @GetMapping("/")
    public String adminsPanel() {
        return "admins";
    }
    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        model.addAttribute("products", new Product());
        return "productForm";
    }
}
