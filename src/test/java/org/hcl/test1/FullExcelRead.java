package org.hcl.test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class FullExcelRead {

	public static void main(String[] args) throws IOException {
		File f = new File(
				"C:\\Users\\USER\\eclipse-workspace\\Scanner1\\AKSHAYA\\Selenium-Day1-BrowserLaunch\\Day1Excel\\Excel Folder\\Datadriven.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet("Question1studdetails");
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row row1 = s.getRow(i);
			for (int j = 0; j < row1.getPhysicalNumberOfCells(); j++) {
				Cell c = row1.getCell(j);
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
			}
		}
	}
}
