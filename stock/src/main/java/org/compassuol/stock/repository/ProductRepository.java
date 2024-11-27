package org.compassuol.stock.repository;

import org.compassuol.stock.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
