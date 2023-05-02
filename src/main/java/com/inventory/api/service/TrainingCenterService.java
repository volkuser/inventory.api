package com.inventory.api.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import com.inventory.api.model.EquipmentType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import com.inventory.api.model.TrainingCenter;
import com.inventory.api.repo.TrainingCenterRepository;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class TrainingCenterService {

    private TrainingCenterRepository trainingCenterRepository;

    // base crud options

    // reading

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<List<TrainingCenter>> findAll() {
        return CompletableFuture.completedFuture(trainingCenterRepository.findAll());
    }

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<TrainingCenter> findById(Long id) {
        Optional<TrainingCenter> trainingCenter = trainingCenterRepository.findById(id);
        return CompletableFuture.completedFuture(trainingCenter.get());
    }

    // editing

    @Async
    @Transactional
    public CompletableFuture<TrainingCenter> create(@Valid @NotNull TrainingCenter trainingCenter) {
        return CompletableFuture.completedFuture(trainingCenterRepository.save(trainingCenter));
    }

    @Async
    @Transactional
    public CompletableFuture<TrainingCenter> update(@Valid @NotNull TrainingCenter trainingCenter, Long id) {
        trainingCenter.setTrainingCenterId(id);
        return CompletableFuture.completedFuture(trainingCenterRepository.save(trainingCenter));
    }

    @Async
    @Transactional
    public CompletableFuture<Void> delete(Long id) {
        trainingCenterRepository.deleteById(id);
        return CompletableFuture.completedFuture(null);
    }

    // specific actions

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<Long> findFirstId() {
        Optional<TrainingCenter> trainingCenter = trainingCenterRepository.findFirstByOrderByTrainingCenterIdAsc();
        return CompletableFuture.completedFuture(trainingCenter.map(TrainingCenter::getTrainingCenterId).orElse(null));
    }
}
