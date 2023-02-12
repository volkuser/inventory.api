package com.inventory.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventory.api.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

