package com.nashtech.rookies.repository;

import com.nashtech.rookies.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
