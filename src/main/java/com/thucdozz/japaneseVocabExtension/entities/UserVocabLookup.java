package com.thucdozz.japaneseVocabExtension.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class UserVocabLookup {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String lookup_id;
    private String user_id;
    private String searched_word;
    private String reading;
    private String meaning;
    private String jlpt_level;
    private LocalDate lookup_time;
}
