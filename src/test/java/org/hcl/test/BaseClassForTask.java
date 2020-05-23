package org.hcl.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClassForTask {

	Select s;
	static Alert a1;
	static WebDriver driver;

	public static WebDriver browserLaunch() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\USER\\eclipse-workspace\\Scanner1\\AKSHAYA\\Selenium-Day1-BrowserLaunch\\Base Class Creation\\driver\\chromedriver.exe");

		driver = new ChromeDriver();
		return driver;

	}

	public static String getUrl(String url) {

		driver.get(url);
		return url;

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

	public static void navigation(String url) {

		driver.navigate().to(url);
	}

	public static void navigateForward() {
		driver.navigate().forward();
		driver.navigate().refresh();
	}

	public static void navigateback() {
		driver.navigate().back();
		driver.navigate().refresh();
	}

	public static void closeAllBrowser() {

		driver.quit();

	}

	public static void closeCurrentBrowser() {
		driver.close();
	}

	public static void managingWindow() {

		driver.manage().window().maximize();
	}

	public static void sendText(WebElement e, String text) {
		e.sendKeys(text);

	}

	public static void clickBtn(WebElement e) {
		e.click();

	}

	public void clear(WebElement e) {

		e.clear();
	}

	public static void gettingText(WebElement e) {
		String text = e.getText();
		System.out.println(text);
	}

	public static void gettingAttribute(WebElement e, String attribute) {
		String attribute2 = e.getAttribute(attribute);
		System.out.println(attribute2);
	}

	public static void tagName(WebElement e) {
		e.getTagName();

	}

	// waits

	public static void explicitElementtoClick(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public static void explicitIfAlert(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.alertIsPresent());

		a1 = driver.switchTo().alert();
	}

	// windowHandling
	public static void windowHandle() {
		String parentwindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String string : allWindows) {
			System.out.println(string);
			if (!(parentwindow.equalsIgnoreCase(string))) {
				driver.switchTo().window(string);
			}
		}

	}

	// TakesScreenShot
	public static void screenShot() throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\USER\\Desktop\\screenshot\\akshaya.jpeg");
		FileUtils.copyFile(source, dest);
	}

	// JavaScript
	public static void executeScript(WebElement e, String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','text')", e);
		String string = js.executeScript("return arguments[0].getAttribute(value)", e).toString();
		System.out.println(string);
	}

	public static void scrollUp(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", e);

	}

	public static void scrollDown(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
	}

	public static void parentWindow() {
		driver.switchTo().defaultContent();
	}

	// Robot Class

	public static void Select(WebElement e) throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);

	}

	public static void copy(WebElement e) throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_C);
	}

	public void Paste(WebElement e) throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}

	// Actions Class
	public static void doubleClick(WebElement e) {
		Actions a1 = new Actions(driver);
		a1.doubleClick(e).perform();

	}

	public static void rightClick(WebElement e) {
		Actions a1 = new Actions(driver);
		a1.contextClick(e).perform();

	}

	public static void moveexpectedPositon(WebElement e) {
		Actions a1 = new Actions(driver);
		a1.moveToElement(e).perform();
	}

	public static void dragAndDrop(WebElement a, WebElement b) {
		Actions a1 = new Actions(driver);
		a1.dragAndDrop(a, b).perform();

	}

	public static void clickHold(WebElement e) {
		Actions a1 = new Actions(driver);
		a1.clickAndHold(e);
	}

	public static void release(WebElement e) {
		Actions a1 = new Actions(driver);
		a1.release(e);
	}

	public static void keyUpclk(CharSequence c) {
		Actions a = new Actions(driver);
		a.keyUp(c);
	}

	public static void keyUDownclk(CharSequence c) {
		Actions a = new Actions(driver);
		a.keyDown(c);
	}

	public static void sendKeyUsingAction(WebElement e, String text) {
		Actions a1 = new Actions(driver);
		a1.keyDown(e, Keys.SHIFT).perform();
		a1.keyUp(e, Keys.SHIFT).perform();
		a1.sendKeys(text).perform();
		a1.sendKeys(text).perform();
		a1.keyDown(e, Keys.SHIFT).perform();
		a1.keyUp(e, Keys.SHIFT).perform();
	}

	// Alert
	public static void alertOk() {
		driver.switchTo().alert().accept();
	}

	public static void alertCancel() {
		driver.switchTo().alert().dismiss();
	}

	public static void alertText() {
		driver.switchTo().alert().getText();
	}

	public static void promptAlert(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	// Frames
	public static void frameName(WebElement e, String name) {
		driver.switchTo().frame(name);
	}

	public static void frameId(WebElement e, int id) {
		driver.switchTo().frame(id);
	}

	public static void defaultFrame() {
		driver.switchTo().defaultContent();
	}

	public static void parentFrame() {
		driver.switchTo().parentFrame();
	}

	// Select
	public static void selectall(WebElement e) {
		List<WebElement> alloptions = new Select(e).getOptions();
		for (int i = 0; i < alloptions.size(); i++) {
			String text = alloptions.get(i).getText();
			System.out.println(text);
		}
	}

	public static void selectByIndex(WebElement e, int i) {
		new Select(e).selectByIndex(i);

	}

	public static void selectByValue(WebElement e, String value) {
		new Select(e).selectByValue(value);
	}

	public static void selectByVisibleText(WebElement e, String value) {
		new Select(e).selectByVisibleText(value);
	}

	public static void deselectByIndex(WebElement e, int i) {
		new Select(e).deselectByIndex(i);

	}

	public static void deselectByValue(WebElement e, String value) {
		new Select(e).deselectByValue(value);
	}

	public static void deselectByVisibleText(WebElement e, String value) {
		new Select(e).deselectByVisibleText(value);
	}

	public static void getAllSelect(WebElement e) {
		List<WebElement> options = new Select(e).getAllSelectedOptions();
		for (int i = 0; i < options.size(); i++) {
			String text = options.get(i).getText();
			System.out.println(text);
		}
	}

	public static void deselecting(WebElement e) {
		new Select(e).deselectAll();
	}

	public static String readExcel(String filename, String sheetname, int rowno, int columnno) throws IOException {
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

	public static void writeinExcel(String filename, String text1,String text, int rowno, int columnno) throws IOException {
		File f = new File(
				"C:\\Users\\USER\\eclipse-workspace\\Scanner1\\AKSHAYA\\Selenium-Day1-BrowserLaunch\\Day1Excel\\Excel Folder\\"
						+ filename);
		Workbook w = new XSSFWorkbook();
		Sheet sheet = w.createSheet(text1);
		Row r = sheet.createRow(rowno);
		Cell c = r.createCell(columnno);
		c.setCellValue(text);
		FileOutputStream fout = new FileOutputStream(f);
		w.write(fout);
	}

	public static void updateinExcel(String filename, String text1, String text, String newvalue, int rownum,
			int colmnnum) throws IOException {
		File f = new File("C:\\Users\\USER\\eclipse-workspace\\Scanner1\\AKSHAYA\\Selenium-Day1-BrowserLaunch\\Day1Excel\\Excel Folder\\"+ filename);
		FileInputStream finput = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(finput);
		Sheet sheet = w.getSheet(text1);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(colmnnum);
		String value = cell.getStringCellValue();
		if (value.equals(text)) {
			cell.setCellValue(newvalue);
			FileOutputStream fout = new FileOutputStream(f);
			w.write(fout);

		}
		
	}
	
	public  static void writeinReadExcel(String filename,String sheetname, String text, int rowno, int columnno) throws IOException {
		File f = new File("C:\\Users\\USER\\eclipse-workspace\\Scanner1\\AKSHAYA\\Selenium-Day1-BrowserLaunch\\Day1Excel\\Excel Folder\\"+ filename);
		FileInputStream finput = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(finput);
		Sheet sheet = w.getSheet(sheetname);
		Row r = sheet.createRow(rowno);
		Cell c = r.createCell(columnno);
		c.setCellValue(text);
		FileOutputStream fout = new FileOutputStream(f);
		w.write(fout);
		
	}
}
