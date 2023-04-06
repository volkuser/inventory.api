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

    @GetMapping
    public CompletableFuture<List<EquipmentType>> getAll() {
        return equipmentTypeService.findAll();
    }

    @PostMapping
    public CompletableFuture<EquipmentType> create(@Valid @RequestBody EquipmentType equipmentType) {
        return equipmentTypeService.create(equipmentType);
    }

    @GetMapping("/{id}")
    public CompletableFuture<EquipmentType> getOne(@PathVariable Long id) {
        return equipmentTypeService.findById(id);
    }

    @PutMapping("/{id}")
    public CompletableFuture<EquipmentType> update(@Valid @RequestBody EquipmentType equipmentType, @PathVariable Long id) {
        return equipmentTypeService.update(equipmentType, id);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<Void> delete(@PathVariable Long id) {
        return equipmentTypeService.delete(id);
    }
}