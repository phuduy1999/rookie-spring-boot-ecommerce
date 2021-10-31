package com.nashtech.rookies.repository;

import com.nashtech.rookies.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    boolean existsProductByCategoryId(Long id);
}
