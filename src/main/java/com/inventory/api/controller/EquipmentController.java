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

    // base crud options

    // reading

    @GetMapping
    private CompletableFuture<List<Equipment>> findAll() {
        return equipmentService.findAll();
    }

    @GetMapping("/{equipmentId}")
    private CompletableFuture<Equipment> findById(@PathVariable Long equipmentId) {
        return equipmentService.findById(equipmentId);
    }

    // editing

    @PostMapping
    private CompletableFuture<Equipment> create(@Valid @RequestBody Equipment equipment) {
        return equipmentService.create(equipment);
    }

    @PutMapping("/{equipmentId}")
    private CompletableFuture<Equipment> update(@Valid @RequestBody Equipment equipment, @PathVariable Long equipmentId) {
        return equipmentService.update(equipment, equipmentId);
    }

    @DeleteMapping("/{equipmentId}")
    private CompletableFuture<Void> delete(@PathVariable Long equipmentId) {
        return equipmentService.delete(equipmentId);
    }

    // specific actions

    @GetMapping("/equipmentType/{equipmentTypeId}")
    private CompletableFuture<List<Equipment>> findByEquipmentType(@PathVariable Long equipmentTypeId) {
        return equipmentService.findByEquipmentType(equipmentTypeId);
    }

    @GetMapping("/first-id")
    private CompletableFuture<Long> getFirstId() {
        return equipmentService.findFirstId();
    }
}