package com.nashtech.rookies.repository;

import com.nashtech.rookies.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
