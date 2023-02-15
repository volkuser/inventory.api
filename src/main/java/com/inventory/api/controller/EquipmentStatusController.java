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

import com.inventory.api.model.EquipmentStatus;
import com.inventory.api.service.EquipmentStatusService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/equipment-statuses")
public class EquipmentStatusController {

    private EquipmentStatusService equipmentStatusService;

    @GetMapping
    public CompletableFuture<List<EquipmentStatus>> getAllEquipmentStatuses() {
        return equipmentStatusService.findAll();
    }

    @PostMapping
    public CompletableFuture<EquipmentStatus> createEquipmentStatus(@Valid @RequestBody EquipmentStatus equipmentStatus) {
        return equipmentStatusService.create(equipmentStatus);
    }

    @GetMapping("/{id}")
    public CompletableFuture<EquipmentStatus> getEquipmentStatusById(@PathVariable(value = "id") Long equipmentStatusId) {
        return equipmentStatusService.findById(equipmentStatusId);
    }

    @PutMapping("/{id}")
    public CompletableFuture<EquipmentStatus> updateEquipmentStatus(@PathVariable(value = "id") Long equipmentStatusId,
                                                                    @Valid @RequestBody EquipmentStatus equipmentStatusDetails) {
        return equipmentStatusService.update(equipmentStatusDetails, equipmentStatusId);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<Void> deleteEquipmentStatus(@PathVariable(value = "id") Long equipmentStatusId) {
        return equipmentStatusService.delete(equipmentStatusId);
    }
}
