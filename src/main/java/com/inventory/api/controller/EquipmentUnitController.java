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

import com.inventory.api.model.EquipmentUnit;
import com.inventory.api.service.EquipmentUnitService;

@AllArgsConstructor
@RestController
@RequestMapping("/equipment-units")
public class EquipmentUnitController {

    private EquipmentUnitService equipmentUnitService;

    @GetMapping
    public CompletableFuture<List<EquipmentUnit>> getAllEquipmentUnits() {
        return equipmentUnitService.findAll();
    }

    @PostMapping
    public CompletableFuture<EquipmentUnit> createEquipmentUnit(@Valid @RequestBody EquipmentUnit equipmentUnit) {
        return equipmentUnitService.create(equipmentUnit);
    }

    @GetMapping("/{id}")
    public CompletableFuture<EquipmentUnit> getEquipmentUnitById(@PathVariable(value = "id") Long equipmentUnitId) {
        return equipmentUnitService.findById(equipmentUnitId);
    }

    @PutMapping("/{id}")
    public CompletableFuture<EquipmentUnit> updateEquipmentUnit(@PathVariable(value = "id") Long equipmentUnitId,
                                                                @Valid @RequestBody EquipmentUnit equipmentUnitDetails) {
        return equipmentUnitService.update(equipmentUnitDetails, equipmentUnitId);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<Void> deleteEquipmentUnit(@PathVariable(value = "id") Long equipmentUnitId) {
        return equipmentUnitService.delete(equipmentUnitId);
    }
}
