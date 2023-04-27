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

    @GetMapping
    private CompletableFuture<List<User>> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping
    private CompletableFuture<User> createUser(@Valid @RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/{id}")
    private CompletableFuture<User> getUserById(@PathVariable(value = "id") Long userId) {
        return userService.findById(userId);
    }

    @PutMapping("/{id}")
    private CompletableFuture<User> updateUser(@PathVariable(value = "id") Long userId,
                                              @Valid @RequestBody User userDetails) {
        return userService.update(userDetails, userId);
    }

    @DeleteMapping("/{id}")
    private CompletableFuture<Void> deleteUser(@PathVariable(value = "id") Long userId) {
        return userService.delete(userId);
    }
}
