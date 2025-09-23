package com.thucdozz.japaneseVocabExtension.dto.request;

public class VocabLookupRequest {
    private String keyword;
    private String sourceLang;

    public VocabLookupRequest(String keyword, String sourceLang) {
        this.keyword = keyword;
        this.sourceLang = sourceLang;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSourceLang() {
        return sourceLang;
    }

    public void setSourceLang(String sourceLang) {
        this.sourceLang = sourceLang;
    }

}
