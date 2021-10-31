package com.nashtech.rookies.repository;

import com.nashtech.rookies.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
