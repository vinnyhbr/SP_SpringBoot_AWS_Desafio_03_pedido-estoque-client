package org.compassuol.stock.service;

import lombok.RequiredArgsConstructor;
import org.compassuol.stock.domain.Product;
import org.compassuol.stock.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public Product save(Product product){
        return repository.save(product);
    }

    public Product findByname(String name){
        return repository.findByName(name);
    }
    
}
