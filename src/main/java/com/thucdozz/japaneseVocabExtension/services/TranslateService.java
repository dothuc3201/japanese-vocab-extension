package com.thucdozz.japaneseVocabExtension.services;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.thucdozz.japaneseVocabExtension.entities.UserVocabLookup;

@Service
public class TranslateService {
    private UserVocabLookupService userVocabLookupService;
    private final RestTemplate restTemplate = new RestTemplate();

    // URL của các dịch thuật bên ngoài
    private final String LIBRE_URL = "https://libretranslate.com/translate";
    private final String JISHO_SEARCH_URL = "https://jisho.org/api/v1/search/words?keyword=%s";

    public UserVocabLookup translateWord(String keyword, String sourceLang) {
        var vocabLookup = new UserVocabLookup();
        var translatedResult = searchJisho(keyword);
        vocabLookup.setWord(keyword);
        vocabLookup.setMeaning(callLibreTranslate(keyword, sourceLang));
        vocabLookup.setReading(translatedResult.get("reading"));
        vocabLookup.setJlpt_level(translatedResult.get("jlpt_level"));
        return userVocabLookupService.save(vocabLookup);
    }

    // Gọi API LibreTranslate để dịch văn bản sang tiếng việt
    public String callLibreTranslate(String keyword, String sourceLang) {
        // Tạo payload cho yêu cầu dịch
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, Object> body = new HashMap<>();
        body.put("q", keyword);
        body.put("source", sourceLang);
        body.put("target", "vi");
        body.put("format", "text");

        // Gửi yêu cầu POST đến LibreTranslate
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);
        var response = restTemplate.postForObject(LIBRE_URL, entity, Map.class);
        if(response == null || !response.containsKey("translatedText")) {
            throw new RuntimeException("Dịch thất bại, không nhận được phản hồi hợp lệ từ dịch vụ.");
        }
        return response.get("translatedText").toString();
    }   


    // Gọi API Jisho để tìm kiếm từ vựng và lấy thông tin
    public Map<String, String> searchJisho(String keyword) {
        var res = new HashMap<String, String>();
        String url = String.format(JISHO_SEARCH_URL, keyword);
        @SuppressWarnings("unchecked")
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        if(response == null) {
            throw new RuntimeException("Tìm kiếm thất bại, không nhận được phản hồi hợp lệ từ dịch vụ.");
        }
        Object dataObj = response.get("data");
        if (dataObj instanceof List) {
            List<?> dataList = (List<?>) dataObj;
            if (!dataList.isEmpty()) {
                var result = dataList.get(0);
                if (result instanceof Map) {
                    @SuppressWarnings("unchecked")
                    Map<String, Object> item = (Map<String, Object>) result;
                    var japaneseList = (List<?>) item.get("japanese");
                    var jlptList = (List<?>) item.get("jlpt");
                    if (!japaneseList.isEmpty() && japaneseList.get(0) instanceof Map) {
                        @SuppressWarnings("unchecked")
                        Map<String, String> japaneseEntry = (Map<String, String>) japaneseList.get(0);
                        res.put("word", japaneseEntry.get("word").toString());
                        res.put("reading", japaneseEntry.get("reading").toString());
                    }
                    if (jlptList != null && !jlptList.isEmpty()) {
                        res.put("jlpt_level", normalizeJlptLevel(jlptList.get(0).toString().toLowerCase()));
                    } else {
                        res.put("jlpt_level", "Unknown");
                    }
                }
            }
            return res;
        }
        throw new RuntimeException("Không tìm thấy kết quả nào.");
    }

    // Chuẩn hóa cấp độ JLPT
    public String normalizeJlptLevel(String jlpt) {
        if(jlpt.contains("n5")) {
            return "N5";
        }
        if(jlpt.contains("n4")) {
            return "N4";
        }
        if(jlpt.contains("n3")) {
            return "N3";
        }
        if(jlpt.contains("n2")) {
            return "N2";
        }
        if(jlpt.contains("n1")) {
            return "N1";
        }
        return jlpt;
    }
}
