package com.inventory.api.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import jakarta.validation.Valid;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/paginated")
    public CompletableFuture<List<EquipmentUnit>> getAllEquipmentUnitsPaginated(@RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
                                                                                @RequestParam(value = "limit", defaultValue = "20") @Min(1) @Max(100) Integer limit) {
        return equipmentUnitService.findAllPaginated(offset, limit);
    }

    @GetMapping("/count")
    public CompletableFuture<Long> getEquipmentUnitCount(){
        return equipmentUnitService.getCountOfElements();
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
