package com.inventory.api.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import com.inventory.api.model.EquipmentStatus;
import com.inventory.api.repo.EquipmentStatusRepository;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class EquipmentStatusService {

    private EquipmentStatusRepository equipmentStatusRepository;

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<List<EquipmentStatus>> findAll() {
        return CompletableFuture.completedFuture(equipmentStatusRepository.findAll());
    }

    @Async
    @Transactional
    public CompletableFuture<EquipmentStatus> create(@Valid @NotNull EquipmentStatus equipmentStatus) {
        return CompletableFuture.completedFuture(equipmentStatusRepository.save(equipmentStatus));
    }

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<EquipmentStatus> findById(Long id) {
        Optional<EquipmentStatus> equipmentStatus = equipmentStatusRepository.findById(id);
        return CompletableFuture.completedFuture(equipmentStatus.get());
    }

    @Async
    @Transactional
    public CompletableFuture<EquipmentStatus> update(@Valid @NotNull EquipmentStatus equipmentStatus, Long id) {
        equipmentStatus.setEquipmentStatusId(id);
        return CompletableFuture.completedFuture(equipmentStatusRepository.save(equipmentStatus));
    }

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<Void> delete(Long id) {
        equipmentStatusRepository.deleteById(id);
        return CompletableFuture.completedFuture(null);
    }
}
