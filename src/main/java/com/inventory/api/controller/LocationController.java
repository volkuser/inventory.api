package com.inventory.api.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import jakarta.validation.Valid;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import com.inventory.api.model.Location;
import com.inventory.api.service.LocationService;

@AllArgsConstructor
@RestController
@RequestMapping("/locations")
public class LocationController {

    private LocationService locationService;

    // base crud options

    // reading

    @GetMapping
    private CompletableFuture<List<Location>> findAll() {
        return locationService.findAll();
    }

    @GetMapping("/{id}")
    private CompletableFuture<Location> findById(@PathVariable(value = "id") Long locationId) {
        return locationService.findById(locationId);
    }

    // editing

    @PostMapping
    private CompletableFuture<Location> create(@Valid @RequestBody Location location) {
        return locationService.create(location);
    }

    @PutMapping("/{id}")
    private CompletableFuture<Location> update(@PathVariable(value = "id") Long locationId,
                                                      @Valid @RequestBody Location locationDetails) {
        return locationService.update(locationDetails, locationId);
    }

    @DeleteMapping("/{id}")
    private CompletableFuture<Void> delete(@PathVariable(value = "id") Long locationId) {
        return locationService.delete(locationId);
    }

    // specific actions

    @GetMapping("/get-by-center-and-number")
    private CompletableFuture<Location> getLocationByTrainingCenterIdAndLocationNumber(
            @RequestParam(value = "trainingCenterId") Long trainingCenterId,
            @RequestParam(value = "locationNumber") String locationNumber) {
        return locationService.findByTrainingCenterIdAndLocationNumber(trainingCenterId, locationNumber);
    }
}
