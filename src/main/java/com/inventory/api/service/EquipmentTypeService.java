package com.inventory.api.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import com.inventory.api.model.EquipmentType;
import com.inventory.api.repo.EquipmentTypeRepository;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class EquipmentTypeService {

    private EquipmentTypeRepository equipmentTypeRepository;

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<List<EquipmentType>> findAll() {
        return CompletableFuture.completedFuture(equipmentTypeRepository.findAll());
    }

    @Async
    @Transactional
    public CompletableFuture<EquipmentType> create(@Valid @NotNull EquipmentType equipmentType) {
        return CompletableFuture.completedFuture(equipmentTypeRepository.save(equipmentType));
    }

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<EquipmentType> findById(Long id) {
        Optional<EquipmentType> equipmentType = equipmentTypeRepository.findById(id);
        return CompletableFuture.completedFuture(equipmentType.get());
    }

    @Async
    @Transactional
    public CompletableFuture<EquipmentType> update(@Valid @NotNull EquipmentType equipmentType, Long id) {
        equipmentType.setEquipmentTypeId(id);
        return CompletableFuture.completedFuture(equipmentTypeRepository.save(equipmentType));
    }

    @Async
    @Transactional
    public CompletableFuture<Void> delete(Long id) {
        equipmentTypeRepository.deleteById(id);
        return CompletableFuture.completedFuture(null);
    }
}
