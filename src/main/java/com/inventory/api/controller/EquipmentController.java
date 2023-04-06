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

import com.inventory.api.model.Equipment;
import com.inventory.api.service.EquipmentService;

@RestController
@RequestMapping("/equipments")
@AllArgsConstructor
public class EquipmentController {
    private EquipmentService equipmentService;

    @GetMapping
    public CompletableFuture<List<Equipment>> findAll() {
        return equipmentService.findAll();
    }

    @PostMapping
    public CompletableFuture<Equipment> create(@Valid @RequestBody Equipment equipment) {
        return equipmentService.create(equipment);
    }

    @GetMapping("/{equipmentId}")
    public CompletableFuture<Equipment> findById(@PathVariable Long equipmentId) {
        return equipmentService.findById(equipmentId);
    }

    @GetMapping("/equipmentType/{equipmentTypeId}")
    public CompletableFuture<List<Equipment>> findByEquipmentType(@PathVariable Long equipmentTypeId) {
        return equipmentService.findByEquipmentType(equipmentTypeId);
    }

    @PutMapping("/{equipmentId}")
    public CompletableFuture<Equipment> update(@Valid @RequestBody Equipment equipment, @PathVariable Long equipmentId) {
        return equipmentService.update(equipment, equipmentId);
    }

    @DeleteMapping("/{equipmentId}")
    public CompletableFuture<Void> delete(@PathVariable Long equipmentId) {
        return equipmentService.delete(equipmentId);
    }
}