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

import com.inventory.api.model.Location;
import com.inventory.api.service.LocationService;

@AllArgsConstructor
@RestController
@RequestMapping("/locations")
public class LocationController {

    private LocationService locationService;

    @GetMapping
    public CompletableFuture<List<Location>> getAllLocations() {
        return locationService.findAll();
    }

    @PostMapping
    public CompletableFuture<Location> createLocation(@Valid @RequestBody Location location) {
        return locationService.create(location);
    }

    @GetMapping("/{id}")
    public CompletableFuture<Location> getLocationById(@PathVariable(value = "id") Long locationId) {
        return locationService.findById(locationId);
    }

    @PutMapping("/{id}")
    public CompletableFuture<Location> updateLocation(@PathVariable(value = "id") Long locationId,
                                                      @Valid @RequestBody Location locationDetails) {
        return locationService.update(locationDetails, locationId);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<Void> deleteLocation(@PathVariable(value = "id") Long locationId) {
        return locationService.delete(locationId);
    }
}
