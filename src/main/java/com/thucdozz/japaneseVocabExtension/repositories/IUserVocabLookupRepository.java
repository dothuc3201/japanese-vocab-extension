package com.thucdozz.japaneseVocabExtension.repositories;

import com.thucdozz.japaneseVocabExtension.entities.UserVocabLookup;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserVocabLookupRepository extends JpaRepository<UserVocabLookup, UUID> {
    // Custom query methods can be defined here if needed
}
