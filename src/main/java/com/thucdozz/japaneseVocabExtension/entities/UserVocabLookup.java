package com.thucdozz.japaneseVocabExtension.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.UUID;


@Entity
public class UserVocabLookup {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID lookup_id;
    private UUID user_id;
    private String searched_word;
    private String reading;
    private String meaning;
    private String jlpt_level;
    private LocalDate lookup_time;

    public UUID getLookup_id() {
        return lookup_id;
    }
    public void setLookup_id(UUID lookup_id) {
        this.lookup_id = lookup_id;
    }
    public UUID getUser_id() {
        return user_id;
    }
    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }
    public String getSearched_word() {
        return searched_word;
    }
    public void setSearched_word(String searched_word) {
        this.searched_word = searched_word;
    }
    public String getReading() {
        return reading;
    }
    public void setReading(String reading) {
        this.reading = reading;
    }
    public String getMeaning() {
        return meaning;
    }
    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
    public String getJlpt_level() {
        return jlpt_level;
    }
    public void setJlpt_level(String jlpt_level) {
        this.jlpt_level = jlpt_level;
    }
    public LocalDate getLookup_time() {
        return lookup_time;
    }
    public void setLookup_time(LocalDate lookup_time) {
        this.lookup_time = lookup_time;
    }
}
