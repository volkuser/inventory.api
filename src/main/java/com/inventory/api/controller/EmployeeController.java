package com.inventory.api.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import jakarta.validation.Valid;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.api.model.Employee;
import com.inventory.api.service.EmployeeService;

@AllArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping("/")
    public CompletableFuture<List<Employee>> findAll() {
        return employeeService.findAll();
    }

    @PostMapping("/")
    public CompletableFuture<Employee> create(@Valid @RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @GetMapping("/{id}")
    public CompletableFuture<Employee> findById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @PutMapping("/{id}")
    public CompletableFuture<Employee> update(@Valid @RequestBody Employee employee, @PathVariable Long id) {
        return employeeService.update(employee, id);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<Void> delete(@PathVariable Long id) {
        return employeeService.delete(id);
    }
}