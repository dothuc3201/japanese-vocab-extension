package com.thucdozz.japaneseVocabExtension.controllers;

import com.thucdozz.japaneseVocabExtension.dto.request.UserCreationRequest;
import com.thucdozz.japaneseVocabExtension.dto.response.ApiResponse;
import com.thucdozz.japaneseVocabExtension.entities.User;
import com.thucdozz.japaneseVocabExtension.services.UserService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> response = new ApiResponse<>(userService.createUser(request));
        return response;
    }

    // lấy tất cả user
    @GetMapping
    public ApiResponse<List<User>> getUsers() {
        ApiResponse<List<User>> response = new ApiResponse<>(userService.getUsers());
        return response;
    }

    @GetMapping("/{userId}")
    public ApiResponse<User> getUserById(@PathVariable("userId") UUID userId) {
        ApiResponse<User> response = new ApiResponse<>(userService.getUserById(userId));
        return response;
    }
}