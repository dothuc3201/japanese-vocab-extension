package com.thucdozz.japaneseVocabExtension.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "users")

@Data // Tự động sinh getter, setter, toString, equals, hashCode
@NoArgsConstructor // Tự động sinh constructor không tham số
@AllArgsConstructor // Tự động sinh constructor đầy đủ tham số
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID user_id;
    private String username;
    private String password_hash; // Changed to password_hash for clarity
    private String email;
    private LocalDate created_at;
}
