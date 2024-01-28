package com.self.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.self.constants.FrameworkConstants;

public final class ExcelUtils {
	private ExcelUtils() {}
	public static List<Map<String,String>> getTestDetails(String sheetname){
	List<Map<String,String>> list = null;
	Workbook workbook = null;
	try(FileInputStream fs = new FileInputStream(FrameworkConstants.getExcelPath())) {
		
		 workbook = new XSSFWorkbook(fs);
		Sheet sheet = workbook.getSheet(sheetname);
		
		int lastRowNum = sheet.getLastRowNum();
		int lastColumnNum = sheet.getRow(0).getLastCellNum();
		
		Map<String, String> map = null;
		list = new ArrayList<>();
		
		for(int i=0; i<=lastRowNum;i=i+2 ) {
			map = new HashMap<>();
			for(int j=0;j<lastColumnNum;j++) {
				String key = sheet.getRow(i).getCell(j).getStringCellValue();
				String value = sheet.getRow(i+1).getCell(j).getStringCellValue();
				map.put(key, value);
			}
			list.add(map);
		} 
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException i) {
			i.printStackTrace();
		}
			return list;
	}
}	
