package com.thucdozz.japaneseVocabExtension.services;

import com.thucdozz.japaneseVocabExtension.dto.request.UserCreationRequest;
import com.thucdozz.japaneseVocabExtension.entities.User;
import com.thucdozz.japaneseVocabExtension.repositories.IUserRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    // Add methods to interact with the userRepository as needed
    public User createUser (UserCreationRequest request){
        User user = new User();

        //validate
        if(userRepository.existsByUsername(request.getUsername())){
            throw new IllegalArgumentException("Username already exists");
        }

        user.setUsername(request.getUsername());
        user.setPassword_hash(request.getPassword_hash());
        user.setEmail(request.getEmail());
        user.setCreated_at(request.getCreated_at());
        return userRepository.save(user);
    }

    // lấy tất cả user
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // lấy user theo id
    public User getUserById(UUID userId) {
        return userRepository.findById(userId).orElse(null);
    }
}