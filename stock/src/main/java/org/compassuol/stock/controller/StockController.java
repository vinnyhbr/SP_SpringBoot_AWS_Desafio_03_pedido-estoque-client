package org.compassuol.stock.controller;

import lombok.RequiredArgsConstructor;
import org.compassuol.stock.domain.Product;
import org.compassuol.stock.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {

    private final ProductService productService;

    @GetMapping("/{name}")
    public Product getProduct(@PathVariable String name) {
        return productService.findByname(name);
    }

    @PutMapping("/{name}/update")
    public void updateStock(@PathVariable String name, @RequestParam int quantity) {
        productService.updateStock(name, quantity);
    }
    @GetMapping("/{name}/{quantity}")
    public ResponseEntity<Boolean> checkAvailability(
            @PathVariable String name, @PathVariable int quantity) {
        boolean available = productService.checkAvailability(name, quantity).isPresent();
        return ResponseEntity.ok(available);
    }
    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }
}
