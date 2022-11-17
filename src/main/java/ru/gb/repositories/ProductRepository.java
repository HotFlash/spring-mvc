package ru.gb.repositories;

import org.springframework.stereotype.Component;
import ru.gb.data.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(List.of(
                new Product(1L, "Ручка", 150L),
                new Product(2L, "Блокнот", 500L),
                new Product(3L, "Карандаш", 100L)
        ));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public void deleteById(Long id) {
        products.removeIf(s -> s.getId().equals(id));
    }

    public Product findById(Long id) {
        return products.stream().filter(s -> s.getId().equals(id)).findFirst().get();
    }
}
