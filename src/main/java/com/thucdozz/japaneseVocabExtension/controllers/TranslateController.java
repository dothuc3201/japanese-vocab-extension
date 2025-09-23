package com.thucdozz.japaneseVocabExtension.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thucdozz.japaneseVocabExtension.dto.request.VocabLookupRequest;
import com.thucdozz.japaneseVocabExtension.dto.response.ApiResponse;
import com.thucdozz.japaneseVocabExtension.dto.response.VocabLookupResponse;
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
    public ApiResponse<VocabLookupResponse> translateText(@RequestBody VocabLookupRequest request) {
        var translatedWord = translateService.translateWord(request.getKeyword(), request.getSourceLang());
        var vocabResponse = new VocabLookupResponse(request.getKeyword(), translatedWord.getReading(), translatedWord.getMeaning(), translatedWord.getJlpt_level());
        return new ApiResponse<>(vocabResponse);
    }
}
