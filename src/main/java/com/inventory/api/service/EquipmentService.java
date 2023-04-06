package com.inventory.api.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import com.inventory.api.model.EquipmentType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import com.inventory.api.model.Equipment;
import com.inventory.api.repo.EquipmentRepository;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class EquipmentService {
    private EquipmentRepository equipmentRepository;
    private EquipmentTypeService equipmentTypeService;

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<List<Equipment>> findAll() {
        return CompletableFuture.completedFuture(equipmentRepository.findAll());
    }

    @Async
    @Transactional
    public CompletableFuture<Equipment> create(@Valid @NotNull Equipment equipment) {
        return CompletableFuture.completedFuture(equipmentRepository.save(equipment));
    }

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<Equipment> findById(Long id) {
        Optional<Equipment> equipment = equipmentRepository.findById(id);
        return CompletableFuture.completedFuture(equipment.get());
    }

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<List<Equipment>> findByEquipmentType(Long equipmentTypeId) {
        EquipmentType equipmentType = equipmentTypeService.findById(equipmentTypeId).join();
        List<Equipment> equipmentList = equipmentRepository.findByEquipmentType(equipmentType);
        return CompletableFuture.completedFuture(equipmentList);
    }

    @Async
    @Transactional
    public CompletableFuture<Equipment> update(@Valid @NotNull Equipment equipment, Long id) {
        equipment.setEquipmentId(id);
        return CompletableFuture.completedFuture(equipmentRepository.save(equipment));
    }

    @Async
    @Transactional
    public CompletableFuture<Void> delete(Long id) {
        equipmentRepository.deleteById(id);
        return CompletableFuture.completedFuture(null);
    }
}