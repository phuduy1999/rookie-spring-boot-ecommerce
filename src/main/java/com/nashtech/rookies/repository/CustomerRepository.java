package com.nashtech.rookies.repository;

import com.nashtech.rookies.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
