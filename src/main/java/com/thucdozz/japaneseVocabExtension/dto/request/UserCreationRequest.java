package com.thucdozz.japaneseVocabExtension.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // Tự động sinh getter
@NoArgsConstructor // Tự động sinh constructor không tham số
@AllArgsConstructor // Tự động sinh constructor đầy đủ tham số
public class UserCreationRequest {
    @NotBlank(message = "Username is required")
    private String username;
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password_hash; // Changed to password_hash for clarity
    @Email(message = "Email should be valid")
    private String email;
    private LocalDate created_at;
}