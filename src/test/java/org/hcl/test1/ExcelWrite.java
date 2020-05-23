package org.hcl.test1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	public static void main(String[] args) throws IOException {
		File f = new File(
				"C:\\Users\\USER\\eclipse-workspace\\Scanner1\\AKSHAYA\\Selenium-Day1-BrowserLaunch\\Day1Excel\\Excel Folder\\Datadriven.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet s = w.createSheet("Sheet0");
		Row r = s.createRow(1);
		Cell c = r.createCell(0);
		c.setCellValue("Rithanya");
		//double numericCellValue = c.getNumericCellValue();
		FileOutputStream fout = new FileOutputStream(f);
		w.write(fout);
		System.out.println("Done");

	}



}
