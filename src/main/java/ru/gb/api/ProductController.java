package ru.gb.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.model.Product;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;
@Controller
@RequestMapping("/products")
public class ProductController {
    private final List<Product> products = List.of(
            new Product(1L, "Product #1", 100L),
            new Product(2L, "Product #2", 200L),
            new Product(3L, "Product #3", 300L),
            new Product(4L, "Product #4", 400L),
            new Product(5L, "Product #5", 500L)
    );

    @GetMapping("/{id}")
    @ResponseBody
    public Product getProduct(@PathVariable Long id) {
        Product product = products.stream()
                .filter(it -> Objects.equals(id, it.getId()))
                .findFirst()
                .orElse(null);

        return product;
    }

    @PostMapping("/addproduct")
    public Product addProduct(@RequestBody Product product){
        products.add(new Product(product.getId(), product.getTitle(), product.getCost()));
        return getProduct(product.getId());
    }


    @GetMapping
    public String getProducts(Model model, HttpServletResponse response) {
        model.addAttribute("productList", products);
        //response.setHeader("ProductsList", "xxxxx");
        return "products";
    }
}
