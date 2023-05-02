package com.inventory.api.controller;

import java.util.List;
import java.util.UUID;
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

    // base crud options

    // reading

    @GetMapping
    private CompletableFuture<List<EquipmentUnit>> findAll() {
        return equipmentUnitService.findAll();
    }

    @GetMapping("/{id}")
    public CompletableFuture<EquipmentUnit> findById(@PathVariable(value = "id") Long equipmentUnitId) {
        return equipmentUnitService.findById(equipmentUnitId);
    }

    // editing

    @PostMapping
    private CompletableFuture<EquipmentUnit> create(@Valid @RequestBody EquipmentUnit equipmentUnit) {
        return equipmentUnitService.create(equipmentUnit);
    }

    @PutMapping("/{id}")
    private CompletableFuture<EquipmentUnit> update(@PathVariable(value = "id") Long equipmentUnitId,
                                                                @Valid @RequestBody EquipmentUnit equipmentUnitDetails) {
        return equipmentUnitService.update(equipmentUnitDetails, equipmentUnitId);
    }

    @DeleteMapping("/{id}")
    private CompletableFuture<Void> delete(@PathVariable(value = "id") Long equipmentUnitId) {
        return equipmentUnitService.delete(equipmentUnitId);
    }

    // specific actions

    // pagination

    @GetMapping("/paginated")
    private CompletableFuture<List<EquipmentUnit>> getAllEquipmentUnitsPaginated(@RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
                                                                                 @RequestParam(value = "limit", defaultValue = "20") @Min(1) @Max(100) Integer limit) {
        return equipmentUnitService.findAllPaginated(offset, limit);
    }

    @PostMapping("/exist-paginated")
    private CompletableFuture<List<EquipmentUnit>> getEquipmentUnitsPaginated(
            @RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
            @RequestParam(value = "limit", defaultValue = "20") @Min(1) @Max(100) Integer limit,
            @RequestBody List<EquipmentUnit> equipmentUnits) {
        return equipmentUnitService.findExistPaginated(offset, limit, equipmentUnits);
    }


    @GetMapping("/count")
    private CompletableFuture<Long> getEquipmentUnitCount(){
        return equipmentUnitService.getCountOfElements();
    }

    // for work with qr-code

    @GetMapping("/guid/{guidCode}")
    private CompletableFuture<EquipmentUnit> getEquipmentUnitByGuidCode(@PathVariable UUID guidCode) {
        return equipmentUnitService.findByGuidCode(guidCode);
    }

    // search

    @PostMapping("/search")
    private CompletableFuture<List<EquipmentUnit>> searchEquipmentUnitsByInventoryNumber(@RequestParam(name = "query") String query,
                                                                                        @RequestBody List<EquipmentUnit> equipmentUnits) {
        return equipmentUnitService.findByInventoryNumber(query, equipmentUnits);
    }

    // filter

    @PostMapping("/by-equipment/{equipmentId}")
    private CompletableFuture<List<EquipmentUnit>> getAllEquipmentUnitsByEquipment(@PathVariable Long equipmentId, @RequestBody List<EquipmentUnit> equipmentUnits) {
        return equipmentUnitService.findByEquipment(equipmentId, equipmentUnits);
    }

    @PostMapping("/by-location/{locationId}")
    private CompletableFuture<List<EquipmentUnit>> getAllEquipmentUnitsByLocation(@PathVariable Long locationId, @RequestBody List<EquipmentUnit> equipmentUnits) {
        return equipmentUnitService.findByLocation(locationId, equipmentUnits);
    }

}
