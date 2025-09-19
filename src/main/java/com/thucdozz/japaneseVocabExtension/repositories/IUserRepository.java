package com.thucdozz.japaneseVocabExtension.repositories;

import com.thucdozz.japaneseVocabExtension.entities.User;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, UUID> {
    //kiểm tra có tồn tại username
    boolean existsByUsername(String username);
    
    // For example, to find a user by username:
    User findByUsername(String username);

    // Or to find a user by email:
    User findByEmail(String email);
};
