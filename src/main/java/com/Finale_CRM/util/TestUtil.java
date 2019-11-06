package com.Finale_CRM.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.Finale_CRM.Base.BaseTest;

public class TestUtil extends BaseTest
{
public static long IMPLICITLY_WAIT = 10;
public static long PAGE_LOAD_TIMEOUT = 20;

public static String TESTDATA_SHEET_PATH ="C:\\Users\\20073007\\Documents\\Selenium\\Individual_Projects\\Finale_CRM\\src\\main\\java\\com\\Finale_CRM\\data\\TestData.xlsx";

static Workbook book;
static Sheet sheet;
public static void switchToFrame()
{
	driver.switchTo().frame("mainpanel");
}


public static Object[][] getTestData(String sheetName) {
	FileInputStream file = null;
	try {
		file = new FileInputStream(TESTDATA_SHEET_PATH);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		book = WorkbookFactory.create(file);
	} catch (InvalidFormatException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	sheet = book.getSheet(sheetName);
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	// System.out.println(sheet.getLastRowNum() + "--------" +
	// sheet.getRow(0).getLastCellNum());
	for (int i = 0; i < sheet.getLastRowNum(); i++) {
		for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
			data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			// System.out.println(data[i][k]);
		} 
	}
	return data;
}

}
