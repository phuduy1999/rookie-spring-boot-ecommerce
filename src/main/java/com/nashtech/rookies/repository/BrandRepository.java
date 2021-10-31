package com.nashtech.rookies.repository;

import com.nashtech.rookies.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
