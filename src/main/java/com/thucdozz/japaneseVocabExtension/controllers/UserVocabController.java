package com.thucdozz.japaneseVocabExtension.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.thucdozz.japaneseVocabExtension.entities.UserVocabLookup;
import com.thucdozz.japaneseVocabExtension.services.UserVocabLookupService;

@RestController
@RequestMapping("/api/user-vocab")
public class UserVocabController {
    @Autowired
    private UserVocabLookupService userVocabLookupService;

    // Add endpoints to handle user vocabulary lookups as needed
    public UserVocabLookup searchVocab(String vocab){
        return userVocabLookupService.searchVocab(vocab);
    }    
}
