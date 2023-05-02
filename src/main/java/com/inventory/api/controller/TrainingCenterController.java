package com.inventory.api.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import jakarta.validation.Valid;

import lombok.AllArgsConstructor;

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

@AllArgsConstructor
@RestController
@RequestMapping("/training-centers")
public class TrainingCenterController {

    private TrainingCenterService trainingCenterService;

    // base crud options

    // reading

    @GetMapping
    private CompletableFuture<List<TrainingCenter>> findAll() {
        return trainingCenterService.findAll();
    }

    @GetMapping("/{id}")
    private CompletableFuture<TrainingCenter> findById(@PathVariable(value = "id") Long trainingCenterId) {
        return trainingCenterService.findById(trainingCenterId);
    }

    // editing

    @PostMapping
    private CompletableFuture<TrainingCenter> create(@Valid @RequestBody TrainingCenter trainingCenter) {
        return trainingCenterService.create(trainingCenter);
    }

    @PutMapping("/{id}")
    private CompletableFuture<TrainingCenter> update(@PathVariable(value = "id") Long trainingCenterId,
                                               @Valid @RequestBody TrainingCenter trainingCenterDetails) {
        return trainingCenterService.update(trainingCenterDetails, trainingCenterId);
    }

    @DeleteMapping("/{id}")
    private CompletableFuture<Void> delete(@PathVariable(value = "id") Long trainingCenterId) {
        return trainingCenterService.delete(trainingCenterId);
    }

    // specific actions

    @GetMapping("/first-id")
    private CompletableFuture<Long> getFirstId() {
        return trainingCenterService.findFirstId();
    }
}
