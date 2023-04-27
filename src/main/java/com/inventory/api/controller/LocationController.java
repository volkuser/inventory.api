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

    @GetMapping
    private CompletableFuture<List<Location>> getAllLocations() {
        return locationService.findAll();
    }

    @PostMapping
    private CompletableFuture<Location> createLocation(@Valid @RequestBody Location location) {
        return locationService.create(location);
    }

    @GetMapping("/{id}")
    private CompletableFuture<Location> getLocationById(@PathVariable(value = "id") Long locationId) {
        return locationService.findById(locationId);
    }

    @PutMapping("/{id}")
    private CompletableFuture<Location> updateLocation(@PathVariable(value = "id") Long locationId,
                                                      @Valid @RequestBody Location locationDetails) {
        return locationService.update(locationDetails, locationId);
    }

    @DeleteMapping("/{id}")
    private CompletableFuture<Void> deleteLocation(@PathVariable(value = "id") Long locationId) {
        return locationService.delete(locationId);
    }

    @GetMapping("/get-by-center-and-number")
    private CompletableFuture<Location> getLocationByTrainingCenterIdAndLocationNumber(
            @RequestParam(value = "trainingCenterId") Long trainingCenterId,
            @RequestParam(value = "locationNumber") String locationNumber) {
        return locationService.findByTrainingCenterIdAndLocationNumber(trainingCenterId, locationNumber);
    }
}
