package com.inventory.api.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

// import com.inventory.api.exception.TrainingCenterNotFoundException;
import com.inventory.api.model.TrainingCenter;
import com.inventory.api.repo.TrainingCenterRepository;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TrainingCenterService {

    private TrainingCenterRepository trainingCenterRepository;

    @Async
    public CompletableFuture<List<TrainingCenter>> findAll() {
        return CompletableFuture.completedFuture(trainingCenterRepository.findAll());
    }

    @Async
    public CompletableFuture<TrainingCenter> create(@Valid @NotNull TrainingCenter trainingCenter) {
        return CompletableFuture.completedFuture(trainingCenterRepository.save(trainingCenter));
    }

    @Async
    public CompletableFuture<TrainingCenter> findById(Long id) {
        Optional<TrainingCenter> trainingCenter = trainingCenterRepository.findById(id);
        /* if (!trainingCenter.isPresent()) {
            throw new TrainingCenterNotFoundException(id);
        }*/
        return CompletableFuture.completedFuture(trainingCenter.get());
    }

    @Async
    public CompletableFuture<TrainingCenter> update(@Valid @NotNull TrainingCenter trainingCenter, Long id) {
        Optional<TrainingCenter> oldTrainingCenter = trainingCenterRepository.findById(id);
        /* if (!oldTrainingCenter.isPresent()) {
            // throw new TrainingCenterNotFoundException(id);
        }*/
        trainingCenter.setTrainingCenterId(id);
        return CompletableFuture.completedFuture(trainingCenterRepository.save(trainingCenter));
    }

    @Async
    public CompletableFuture<Void> delete(Long id) {
        trainingCenterRepository.deleteById(id);
        return CompletableFuture.completedFuture(null);
    }
}
