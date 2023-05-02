package com.inventory.api.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

// import com.inventory.api.exception.UserNotFoundException;
import com.inventory.api.model.User;
import com.inventory.api.repo.UserRepository;

import lombok.AllArgsConstructor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;

    // base crud options

    // reading

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<List<User>> findAll() {
        return CompletableFuture.completedFuture(userRepository.findAll());
    }

    @Async
    @Transactional(readOnly = true)
    public CompletableFuture<User> findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return CompletableFuture.completedFuture(user.get());
    }

    // editing

    @Async
    @Transactional
    public CompletableFuture<User> create(@Valid @NotNull User user) {
        return CompletableFuture.completedFuture(userRepository.save(user));
    }

    @Async
    @Transactional
    public CompletableFuture<User> update(@Valid @NotNull User user, Long id) {
        user.setUserId(id);
        return CompletableFuture.completedFuture(userRepository.save(user));
    }

    @Async
    @Transactional
    public CompletableFuture<Void> delete(Long id) {
        userRepository.deleteById(id);
        return CompletableFuture.completedFuture(null);
    }
}
