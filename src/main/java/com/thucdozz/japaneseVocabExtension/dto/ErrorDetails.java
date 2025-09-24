package com.thucdozz.japaneseVocabExtension.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
    private String code;
    private String message;
    private Object details;
    
}
