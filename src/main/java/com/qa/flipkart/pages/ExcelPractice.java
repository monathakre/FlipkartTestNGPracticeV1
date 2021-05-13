package com.qa.flipkart.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelPractice {

	public static void main(String[] args) throws FileNotFoundException {
		
		/*
		 * File f = new File("c://");
		 * 
		 * FileInputStream fs = new FileInputStream(f);
		 * 
		 * XSSFWorkbook wb = new XSSFWorkbook(fs);
		 * 
		 * XSSFSheet sheet1 = wb.getsheet(sheetname)/wb.getSheetAt(index);
		 * 
		 * String data0 = sheet1.getRow(0).getCell(0).getStringCellValue();
		 */
		
		String str = "Welcome into my world";
		
		String[] arr = str.split("\\s", 6);
		
		for(String s:arr) {
			System.out.println(".."+s);
		}

	}

}
