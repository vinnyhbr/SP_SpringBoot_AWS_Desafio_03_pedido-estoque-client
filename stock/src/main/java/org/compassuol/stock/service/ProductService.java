package org.compassuol.stock.service;

import lombok.RequiredArgsConstructor;
import org.compassuol.stock.domain.Product;
import org.compassuol.stock.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product save(Product product){
        return productRepository.save(product);
    }

    public Optional<Product>  checkAvailability(String name, int quantity) {
        Optional<Product> product = Optional.ofNullable(productRepository.findByName(name));
        if (product.isPresent() && product.get().getQuantity() >= quantity) {
            return product;
        }
        return Optional.empty();
    }

    public Product findByname(String name){
        return productRepository.findByName(name);
    }
    public void updateStock(String name, int quantity) {
        Product product = productRepository.findByName(name);
        if (product == null || product.getQuantity() < quantity) {
            throw new IllegalArgumentException("Insufficient stock for the product: " + name);
        }
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
    }
}
