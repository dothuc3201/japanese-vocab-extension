package com.thucdozz.japaneseVocabExtension.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thucdozz.japaneseVocabExtension.dto.ApiResponse;
import com.thucdozz.japaneseVocabExtension.dto.VocabLookupResponse;
import com.thucdozz.japaneseVocabExtension.services.TranslateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/translate")
public class TranslateController {
    @Autowired
    private TranslateService translateService;

    // Các endpoint dịch thuật sẽ được thêm vào đây
    @PostMapping
    public ApiResponse<VocabLookupResponse> translateText(@RequestBody String keyword, @RequestBody String sourceLang) {
        var translatedWord = translateService.translateWord(keyword, sourceLang);
        var vocabResponse = new VocabLookupResponse(keyword, translatedWord.getReading(), translatedWord.getMeaning(), translatedWord.getJlpt_level());
        return new ApiResponse<>(vocabResponse);
    }
}
