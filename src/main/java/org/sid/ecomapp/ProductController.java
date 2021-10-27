package org.sid.ecomapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String index(Model model){
        return "index";
    }
    @GetMapping("/products")
    public String products(Model model){
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

}
