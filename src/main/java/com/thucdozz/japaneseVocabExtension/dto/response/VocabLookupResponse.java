package com.thucdozz.japaneseVocabExtension.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // Tự động sinh getter, setter, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
public class VocabLookupResponse {
    private String word;
    private String reading;
    private String meaning;
    private String jlpt_level;
}
