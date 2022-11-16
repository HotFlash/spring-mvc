package ru.gb.service;

import org.springframework.stereotype.Service;
import ru.gb.data.Product;
import ru.gb.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void changePrice(Long studentId, Integer delta) {
        Product product = productRepository.findById(studentId);
        product.setPrice(product.getPrice() + delta);
    }
}
