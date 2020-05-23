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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClassForFbPageLogin {
	static WebDriver driver;

	public static WebDriver browserLaunch() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\USER\\eclipse-workspace\\Scanner1\\AKSHAYA\\Selenium-Day1-BrowserLaunch\\Base Class Creation\\driver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;

	}

	public static String getTitle() {

		String title = driver.getTitle();
		System.out.println(title);
		return title;
	}

	public static String getcurrentUrl() {

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		return currentUrl;
	}

	public static void sendText(WebElement e, String text) {
		e.sendKeys(text);

	}

	public static String getUrl(String url) {

		driver.get(url);
		return url;
	}
	public static void clickBtn(WebElement e) {
		e.click();
	}

	public static String getData(String filename, String sheetname, int rowno, int columnno) throws IOException {
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
}
