package com.thucdozz.japaneseVocabExtension.controllers;

import com.thucdozz.japaneseVocabExtension.dto.UserCreationRequest;
import com.thucdozz.japaneseVocabExtension.entities.User;
import com.thucdozz.japaneseVocabExtension.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public User createUser(@RequestBody UserCreationRequest request) {
        // Implementation for creating a user
        return userService.createUser(request); // Placeholder return
    }
}
