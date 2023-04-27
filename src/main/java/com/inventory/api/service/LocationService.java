package com.inventory.api.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import com.inventory.api.repo.TrainingCenterRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.api.model.Location;
import com.inventory.api.repo.LocationRepository;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;

@Service
@AllArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;
    private final TrainingCenterRepository trainingCenterRepository;

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<List<Location>> findAll() {
        return CompletableFuture.completedFuture(locationRepository.findAll());
    }

    @Async
    @Transactional
    public CompletableFuture<Location> create(@Valid @NotNull Location location) {
        return CompletableFuture.completedFuture(locationRepository.save(location));
    }

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<Location> findById(Long id) {
        Optional<Location> location = locationRepository.findById(id);
        return CompletableFuture.completedFuture(location.get());
    }

    @Async
    @Transactional
    public CompletableFuture<Location> update(@Valid @NotNull Location location, Long id) {
        location.setLocationId(id);
        return CompletableFuture.completedFuture(locationRepository.save(location));
    }

    @Async
    @Transactional
    public CompletableFuture<Void> delete(Long id) {
        locationRepository.deleteById(id);
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<Location> findByTrainingCenterIdAndLocationNumber(Long trainingCenterId, String locationNumber) {
        Optional<Location> location = locationRepository.findByTrainingCenterAndLocationNumber(trainingCenterRepository.findByTrainingCenterId(trainingCenterId), locationNumber);
        return CompletableFuture.completedFuture(location.get());
    }
}
