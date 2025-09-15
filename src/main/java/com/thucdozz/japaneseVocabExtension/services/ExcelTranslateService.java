package com.thucdozz.japaneseVocabExtension.services;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelTranslateService {
	@Autowired
	private UserVocabLookupService userVocabLookupService;

	public List<String> readVocabFromExcel(String filePath) {
		List<String> vocabs = new ArrayList<>();
		try (FileInputStream fis = new FileInputStream(new File(filePath));
			 Workbook workbook = new XSSFWorkbook(fis)) {
			Sheet sheet = workbook.getSheetAt(0);
			for (Row row : sheet) {
				Cell cell = row.getCell(0); // Giả sử từ vựng ở cột đầu tiên
				if (cell != null) {
					String vocab = cell.getStringCellValue();
					if (vocab != null && !vocab.isBlank()) {
						vocabs.add(vocab);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vocabs;
	}

	public List<Object> processExcelAndSearchVocab(String filePath) {
		List<String> vocabs = readVocabFromExcel(filePath);
		List<Object> results = new ArrayList<>();
		for (String vocab : vocabs) {
			results.add(userVocabLookupService.searchVocab(vocab));
		}
		return results;
	}
}
