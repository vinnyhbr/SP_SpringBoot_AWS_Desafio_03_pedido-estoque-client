package org.compassuol.stock.controller;

import lombok.RequiredArgsConstructor;
import org.compassuol.stock.domain.Product;
import org.compassuol.stock.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {

    private final ProductService productService;

    @GetMapping("/{name}")
    public Product getProduct(@PathVariable String nome) {
        return productService.findByname(nome);
    }

    @PutMapping("/{name}/update")
    public void updateStock(@PathVariable String name, @RequestParam int quantity) {
        productService.updateStock(name, quantity);
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }
}
