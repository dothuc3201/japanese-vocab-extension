package com.thucdozz.japaneseVocabExtension.dto;

public class VocabLookupResponse {
    private String word;
    private String reading;
    private String meaning;
    private String jlpt_level;

    public VocabLookupResponse(String word, String reading, String meaning, String jlpt_level) {
        this.word = word;
        this.reading = reading;
        this.meaning = meaning;
        this.jlpt_level = jlpt_level;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
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
}
