package org.hcl.test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BaseClassForExcelREadWriteUpdate {
	public static String readinExcel(String filename, String sheetname, int rowno, int columnno) throws IOException {
		File f = new File(
				"C:\\Users\\USER\\eclipse-workspace\\Scanner1\\AKSHAYA\\Selenium-Day1-BrowserLaunch\\Day1Excel\\Excel Folder\\"
						+ filename);
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet(sheetname);
		Row r = s.getRow(rowno);
		Cell c = r.getCell(columnno);
		CellType cellType = c.getCellType();
		String value = "";
		if (cellType == cellType.STRING) {
			value = c.getStringCellValue();
		} else if (cellType == cellType.NUMERIC) {
			if (DateUtil.isCellDateFormatted(c)) {
				Date d = c.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				value = sdf.format(d);
			} else {
				double d = c.getNumericCellValue();
				long l = (long) d;

				value = String.valueOf(l);
			}
		}
		return value;
	}

	public static void writeinExcel(String filename,String text, int rowno, int columnno) throws IOException {
		File f = new File(
				"C:\\Users\\USER\\eclipse-workspace\\Scanner1\\AKSHAYA\\Selenium-Day1-BrowserLaunch\\Day1Excel\\Excel Folder\\"+filename);
		Workbook w = new XSSFWorkbook();
		Sheet sheet = w.createSheet();
		Row r = sheet.createRow(rowno);
		Cell c = r.createCell(columnno);
		c.setCellValue(text);
		FileOutputStream fout = new FileOutputStream(f);
		w.write(fout);
	}
	public static void updateinExcel(String filename, String text1,String text, String newvalue,int rownum,int colmnnum) throws IOException {
		File f=new File("C:\\Users\\USER\\eclipse-workspace\\Scanner1\\AKSHAYA\\Selenium-Day1-BrowserLaunch\\Day1Excel\\Excel Folder\\"+filename);
		FileInputStream fin=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fin);
		Sheet sheet = w.getSheet(text1);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(colmnnum);
		String value = cell.getStringCellValue();
		if(value.equals(text))
		{
			cell.setCellValue(newvalue);
			FileOutputStream fout=new FileOutputStream(f);
			w.write(fout);
			
		}
	}
	
}
