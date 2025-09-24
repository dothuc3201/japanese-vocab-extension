package com.thucdozz.japaneseVocabExtension.services;

import com.thucdozz.japaneseVocabExtension.dto.request.UserCreationRequest;
import com.thucdozz.japaneseVocabExtension.entities.User;
import com.thucdozz.japaneseVocabExtension.repositories.IUserRepository;
import com.thucdozz.japaneseVocabExtension.mapper.IUserMapper;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IUserMapper userMapper;

    // Add methods to interact with the userRepository as needed
    public User createUser (UserCreationRequest request){
        User user = new User();
        //validate
        if(userRepository.existsByUsername(request.getUsername())){
            throw new IllegalArgumentException("Username already exists");
        }

        user = userMapper.toUser(request);
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