package com.thucdozz.japaneseVocabExtension.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.thucdozz.japaneseVocabExtension.dto.ErrorDetails;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ApiResponse<T> {
    private boolean success;
    private T data;
    private ErrorDetails error;

    // Constructors
    public ApiResponse(T data) {
        this.success = true;
        this.data = data;
        this.error = null;
    }

    public ApiResponse(ErrorDetails error) {
        this.success = false;
        this.data = null;
        this.error = error;
    }
}
