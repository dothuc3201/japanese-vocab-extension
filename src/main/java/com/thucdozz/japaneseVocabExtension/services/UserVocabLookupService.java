package com.thucdozz.japaneseVocabExtension.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thucdozz.japaneseVocabExtension.entities.UserVocabLookup;
import com.thucdozz.japaneseVocabExtension.repositories.IUserVocabLookupRepository;

@Service
public class UserVocabLookupService {
    @Autowired
    private IUserVocabLookupRepository userVocabLookupRepository;

    public UserVocabLookup searchVocab(String vocab){
        // Implement search logic here
        var result = new UserVocabLookup();
        result.setWord(vocab);
        userVocabLookupRepository.save(result);
        return result;
    }

    // lưu từ vựng đã tra cứu vào database
    public UserVocabLookup save(UserVocabLookup vocabLookup) {
        return userVocabLookupRepository.save(vocabLookup);
    }
}
