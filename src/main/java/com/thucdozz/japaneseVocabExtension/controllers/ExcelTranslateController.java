package com.thucdozz.japaneseVocabExtension.controllers;

import com.thucdozz.japaneseVocabExtension.services.ExcelTranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

@RestController
@RequestMapping("/api/excel")
public class ExcelTranslateController {

    @Autowired
    private ExcelTranslateService excelTranslateService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadExcel(@RequestParam("file") MultipartFile file) {
        try {
            // Lưu file tạm ra ổ đĩa
            File tempFile = File.createTempFile("vocab", ".xlsx");
            try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                fos.write(file.getBytes());
            }
            // Xử lý file
            Object result = excelTranslateService.processExcelAndSearchVocab(tempFile.getAbsolutePath());
            tempFile.delete();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}