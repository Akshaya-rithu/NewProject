package org.hcl.test1;

import java.io.File;
import java.io.FileInputStream;

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

public class AkshayaOwnExcelCreation extends BaseClassForExcelREadWriteUpdate{

	public static void main(String[] args) throws IOException {
		readinExcel("Datadriven.xlsx", "Question1studdetails", 4, 4);
		writeinExcel("ExcelNewSheet.xlsx","Akshaya", 11, 4);
		updateinExcel("Datadriven.xlsx", "Question1studdetails","Rithu","Selenium", 4, 4);
		System.out.println("done");
		
}
}
