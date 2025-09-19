package com.thucdozz.japaneseVocabExtension.services;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TranslateService {
    private final RestTemplate restTemplate = new RestTemplate();

    // URL của các dịch thuật bên ngoài
    private final String LIBRE_URL = "https://libretranslate.com/translate";
    private final String JISHO_SEARCH_URL = "https://jisho.org/api/v1/search/words?keyword=%s";
    private final String JISHO_WORD_PAGE = "https://jisho.org/word/%s";

    public String translateText(String text, String sourceLang, String targetLang) {
        // Tạo payload cho yêu cầu dịch
        var payload = new java.util.HashMap<String, String>();
        payload.put("q", text);
        payload.put("source", sourceLang);
        payload.put("target", targetLang);
        payload.put("format", "text");

        // Gửi yêu cầu POST đến LibreTranslate
        var response = restTemplate.postForObject(LIBRE_URL, payload, String.class);
        return response;
    }
}
