package com.inventory.api.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import jakarta.validation.Valid;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.api.model.EquipmentType;
import com.inventory.api.service.EquipmentTypeService;

@AllArgsConstructor
@RestController
@RequestMapping("/equipment-types")
public class EquipmentTypeController {
    private EquipmentTypeService equipmentTypeService;

    // base crud options

    // reading

    @GetMapping
    private CompletableFuture<List<EquipmentType>> findAll() {
        return equipmentTypeService.findAll();
    }

    @GetMapping("/{id}")
    private CompletableFuture<EquipmentType> findById(@PathVariable Long id) {
        return equipmentTypeService.findById(id);
    }

    // editing

    @PostMapping
    private CompletableFuture<EquipmentType> create(@Valid @RequestBody EquipmentType equipmentType) {
        return equipmentTypeService.create(equipmentType);
    }

    @PutMapping("/{id}")
    private CompletableFuture<EquipmentType> update(@Valid @RequestBody EquipmentType equipmentType, @PathVariable Long id) {
        return equipmentTypeService.update(equipmentType, id);
    }

    @DeleteMapping("/{id}")
    private CompletableFuture<Void> delete(@PathVariable Long id) {
        return equipmentTypeService.delete(id);
    }

    // specific actions

    @GetMapping("/first-id")
    private CompletableFuture<Long> getFirstId() {
        return equipmentTypeService.findFirstId();
    }
}