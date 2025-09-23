package com.thucdozz.japaneseVocabExtension.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserCreationRequest {
    @NotBlank(message = "Username is required")
    private String username;
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password_hash; // Changed to password_hash for clarity
    @Email(message = "Email should be valid")
    private String email;
    private LocalDate created_at;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }
}