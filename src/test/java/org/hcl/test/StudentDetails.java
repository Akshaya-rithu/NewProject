package org.hcl.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StudentDetails {

	public static void main(String[] args) throws IOException {
		File f = new File(
				"C:\\Users\\USER\\eclipse-workspace\\Scanner1\\AKSHAYA\\Selenium-Day1-BrowserLaunch\\Day1Excel\\Excel Folder\\Datadriven.xlsx");

		FileInputStream fileinput = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fileinput);

		org.apache.poi.ss.usermodel.Sheet sheet = w.getSheet("Question1studdetails");

		// Number of rows
		System.out.println("................Task Question no 1:............");
		int TotalNumbOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println("Total number of Rows:  " + TotalNumbOfRows);

		Row row = sheet.getRow(0);
		// Number of cells
		int NumberOfCells = row.getPhysicalNumberOfCells();
		System.out.println(" Total number of cells: " + NumberOfCells);

		System.out.println("....................Task Question no 2...............");
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row1 = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row1.getCell(j);
				System.out.println(cell);

			}
		}
		System.out.println();
		// first cell
		Cell cell = row.getCell(0);
		System.out.println("Cell no Zero: " + cell);

	}

}
