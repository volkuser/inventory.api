package com.inventory.api.controller;

import com.inventory.api.model.User;
import com.inventory.api.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    // base crud options

    // reading

    @GetMapping
    private CompletableFuture<List<User>> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    private CompletableFuture<User> findById(@PathVariable(value = "id") Long userId) {
        return userService.findById(userId);
    }

    // editing

    @PostMapping
    private CompletableFuture<User> create(@Valid @RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/{id}")
    private CompletableFuture<User> update(@PathVariable(value = "id") Long userId,
                                              @Valid @RequestBody User userDetails) {
        return userService.update(userDetails, userId);
    }

    @DeleteMapping("/{id}")
    private CompletableFuture<Void> delete(@PathVariable(value = "id") Long userId) {
        return userService.delete(userId);
    }
}
