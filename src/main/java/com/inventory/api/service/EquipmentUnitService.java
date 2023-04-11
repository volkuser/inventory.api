package com.inventory.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import com.inventory.api.model.Equipment;
import com.inventory.api.model.Location;
import com.inventory.api.repo.EquipmentRepository;
import com.inventory.api.repo.LocationRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import com.inventory.api.model.EquipmentUnit;
import com.inventory.api.repo.EquipmentUnitRepository;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class EquipmentUnitService {

    private EquipmentUnitRepository equipmentUnitRepository;

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<List<EquipmentUnit>> findAll() {
        return CompletableFuture.completedFuture(equipmentUnitRepository.findAll());
    }

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<List<EquipmentUnit>> findAllPaginated(int offset, int limit) {
        Page<EquipmentUnit> equipmentUnitPage = equipmentUnitRepository.findAll(PageRequest.of(offset, limit));
        List<EquipmentUnit> equipmentUnitList = equipmentUnitPage.getContent();
        return CompletableFuture.completedFuture(equipmentUnitList);
    }

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<List<EquipmentUnit>> findExistPaginated(int offset, int limit, List<EquipmentUnit> equipmentUnits) {
        int startIndex = offset * limit;
        int endIndex = Math.min(startIndex + limit, equipmentUnits.size());
        return CompletableFuture.completedFuture(equipmentUnits.subList(startIndex, endIndex));
    }

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<Long> getCountOfElements() {
        return CompletableFuture.completedFuture(equipmentUnitRepository.count());
    }

    @Async
    @Transactional
    public CompletableFuture<EquipmentUnit> create(@Valid @NotNull EquipmentUnit equipmentUnit) {
        return CompletableFuture.completedFuture(equipmentUnitRepository.save(equipmentUnit));
    }

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<EquipmentUnit> findById(Long id) {
        Optional<EquipmentUnit> equipmentUnit = equipmentUnitRepository.findById(id);
        return CompletableFuture.completedFuture(equipmentUnit.get());
    }

    @Async
    @Transactional
    public CompletableFuture<EquipmentUnit> update(@Valid @NotNull EquipmentUnit equipmentUnit, Long id) {
        equipmentUnit.setEquipmentUnitId(id);
        return CompletableFuture.completedFuture(equipmentUnitRepository.save(equipmentUnit));
    }

    @Async
    @Transactional
    public CompletableFuture<Void> delete(Long id) {
        equipmentUnitRepository.deleteById(id);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<EquipmentUnit> findByGuidCode(UUID guidCode) {
        Optional<EquipmentUnit> equipmentUnit = equipmentUnitRepository.findByGuidCode(guidCode);
        return CompletableFuture.completedFuture(equipmentUnit.get());
    }

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<List<EquipmentUnit>> findByInventoryNumber(String searchQuery, List<EquipmentUnit> equipmentUnits) {
        List<EquipmentUnit> matchingEquipmentUnits = new ArrayList<>();
        for (EquipmentUnit equipmentUnit : equipmentUnits) {
            if (equipmentUnit.getInventoryNumber().contains(searchQuery)) {
                matchingEquipmentUnits.add(equipmentUnit);
            }
        }
        return CompletableFuture.completedFuture(matchingEquipmentUnits);
    }

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<List<EquipmentUnit>> findByLocation(Long locationId, List<EquipmentUnit> equipmentUnits) {
        List<EquipmentUnit> matchingEquipmentUnits = new ArrayList<>();
        for (EquipmentUnit equipmentUnit : equipmentUnits) {
            if (equipmentUnit.getLocation().getLocationId().equals(locationId)) {
                matchingEquipmentUnits.add(equipmentUnit);
            }
        }
        return CompletableFuture.completedFuture(matchingEquipmentUnits);
    }

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<List<EquipmentUnit>> findByEquipment(Long equipmentId, List<EquipmentUnit> equipmentUnits) {
        List<EquipmentUnit> matchingEquipmentUnits = new ArrayList<>();
        for (EquipmentUnit equipmentUnit : equipmentUnits) {
            if (equipmentUnit.getEquipment().getEquipmentId().equals(equipmentId)) {
                matchingEquipmentUnits.add(equipmentUnit);
            }
        }
        return CompletableFuture.completedFuture(matchingEquipmentUnits);
    }
}
