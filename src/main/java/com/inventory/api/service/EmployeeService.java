package com.inventory.api.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import com.inventory.api.model.Employee;
import com.inventory.api.repo.EmployeeRepository;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    // base crud options

    // reading

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<List<Employee>> findAll() {
        return CompletableFuture.completedFuture(employeeRepository.findAll());
    }

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<Employee> findById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return CompletableFuture.completedFuture(employee.get());
    }

    // editing

    @Async
    @Transactional
    public CompletableFuture<Employee> create(@Valid @NotNull Employee employee) {
        return CompletableFuture.completedFuture(employeeRepository.save(employee));
    }

    @Async
    @Transactional
    public CompletableFuture<Employee> update(@Valid @NotNull Employee employee, Long id) {
        employee.setEmployeeId(id);
        return CompletableFuture.completedFuture(employeeRepository.save(employee));
    }

    @Async
    @Transactional
    public CompletableFuture<Void> delete(Long id) {
        employeeRepository.deleteById(id);
        return CompletableFuture.completedFuture(null);
    }
}
