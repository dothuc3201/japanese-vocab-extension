package com.thucdozz.japaneseVocabExtension.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VocabLookupRequest {
    private String keyword;
    private String sourceLang;
}
