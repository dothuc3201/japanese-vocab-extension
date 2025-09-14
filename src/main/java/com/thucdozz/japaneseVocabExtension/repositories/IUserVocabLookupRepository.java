package com.thucdozz.japaneseVocabExtension.repositories;

import com.thucdozz.japaneseVocabExtension.entities.UserVocabLookup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserVocabLookupRepository extends JpaRepository<UserVocabLookup, String> {
    // Custom query methods can be defined here if needed
}
