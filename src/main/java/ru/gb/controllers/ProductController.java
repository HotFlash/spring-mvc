package ru.gb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.data.Product;
import ru.gb.service.ProductService;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/products/change_price")
    public void changePrice(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changePrice(productId, delta);
    }
}
