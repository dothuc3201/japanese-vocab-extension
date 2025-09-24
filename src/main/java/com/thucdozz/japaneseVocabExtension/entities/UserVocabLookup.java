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
@Table(name = "user_vocab_lookup")
@Data // Tự động sinh getter, setter, toString, equals, hashCode
@NoArgsConstructor // Tự động sinh constructor không tham số
@AllArgsConstructor // Tự động sinh constructor đầy đủ tham số
public class UserVocabLookup {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID lookup_id;
    private UUID user_id;
    private String word;
    private String reading;
    private String meaning;
    private String jlpt_level;
    private LocalDate lookup_time;

}
