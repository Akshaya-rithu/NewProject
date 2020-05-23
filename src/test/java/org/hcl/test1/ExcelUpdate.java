package org.hcl.test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUpdate {

	public static void main(String[] args) throws IOException {
		File f=new File("C:\\Users\\USER\\eclipse-workspace\\Scanner1\\AKSHAYA\\Selenium-Day1-BrowserLaunch\\Day1Excel\\Excel Folder\\ExcelWrite.xlsx");
		FileInputStream fin=new FileInputStream(f);
		Workbook w= new XSSFWorkbook(fin);
		Sheet s = w.getSheet("Sheet0");
		Row r = s.getRow(0);
		Cell c = r.getCell(0);
		String value = c.getStringCellValue();
		if(value.equals("Rithanya"))
		{
			c.setCellValue("AkshRithu");
			FileOutputStream fout=  new FileOutputStream(f);
			w.write(fout);
		}
		System.out.println("Done");
	}

}
