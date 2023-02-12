package com.inventory.api.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import jakarta.validation.Valid;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.api.model.TrainingCenter;
import com.inventory.api.service.TrainingCenterService;

@Component
@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {

    private TrainingCenterService trainingCenterService;

    @GetMapping
    public CompletableFuture<List<TrainingCenter>> getAllTrainingCenters() {
        return trainingCenterService.findAll();
    }

    @PostMapping
    public CompletableFuture<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
        return trainingCenterService.create(trainingCenter);
    }

    @GetMapping("/{id}")
    public CompletableFuture<TrainingCenter> getTrainingCenterById(@PathVariable(value = "id") Long trainingCenterId) {
        return trainingCenterService.findById(trainingCenterId);
    }

    @PutMapping("/{id}")
    public CompletableFuture<TrainingCenter> updateTrainingCenter(@PathVariable(value = "id") Long trainingCenterId,
                                               @Valid @RequestBody TrainingCenter trainingCenterDetails) {
        return trainingCenterService.update(trainingCenterDetails, trainingCenterId);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<Void> deleteTrainingCenter(@PathVariable(value = "id") Long trainingCenterId) {
        trainingCenterService.delete(trainingCenterId);
    }
}
