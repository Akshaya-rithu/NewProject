package org.hcl.test;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Adactichotelbooking extends BaseClassForTask {

	public static void main(String[] args) throws IOException, InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		browserLaunch();
		getUrl("https://www.adactin.com/HotelApp/");
		managingWindow();
		getTitle();
		getcurrentUrl();
		// login
		WebElement login = driver.findElement(By.id("username"));
		sendText(login, readExcel("TaskExcelSheet2.xlsx", "Adactinhotel", 0, 1));
		WebElement pass = driver.findElement(By.id("password"));
		sendText(pass, readExcel("TaskExcelSheet2.xlsx", "Adactinhotel", 1, 1));
		WebElement btn = driver.findElement(By.id("login"));
		clickBtn(btn);

		// booking room
		WebElement loc = driver.findElement(By.xpath("//select[@name='location']"));
		sendText(loc, readExcel("TaskExcelSheet2.xlsx", "Adactinhotel", 2, 1));
		selectall(loc);
		selectByValue(loc,"London");

		WebElement hotels = driver.findElement(By.id("hotels"));
		sendText(hotels, readExcel("TaskExcelSheet2.xlsx", "Adactinhotel", 3, 1));
		WebElement roomtype = driver.findElement(By.name("room_type"));
		sendText(roomtype, readExcel("TaskExcelSheet2.xlsx", "Adactinhotel", 4, 1));
		WebElement roomnos = driver.findElement(By.name("room_nos"));
		sendText(roomnos, readExcel("TaskExcelSheet2.xlsx", "Adactinhotel", 5, 1));
		WebElement datein = driver.findElement(By.name("datepick_in"));
		sendText(datein, readExcel("TaskExcelSheet2.xlsx", "Adactinhotel", 6, 1));
		WebElement dateout = driver.findElement(By.name("datepick_out"));
		sendText(dateout, readExcel("TaskExcelSheet2.xlsx", "Adactinhotel", 7, 1));
		WebElement adultroom = driver.findElement(By.id("adult_room"));
		sendText(adultroom, readExcel("TaskExcelSheet2.xlsx", "Adactinhotel", 8, 1));
		WebElement childroom = driver.findElement(By.id("child_room"));
		sendText(childroom, readExcel("TaskExcelSheet2.xlsx", "Adactinhotel", 9, 1));
		WebElement submit = driver.findElement(By.id("Submit"));
		clickBtn(submit);

		WebElement btn2 = driver.findElement(By.xpath("//input[@name='radiobutton_0']"));
		clickBtn(btn2);
		WebElement cont = driver.findElement(By.xpath("//input[@name='continue']"));
		clickBtn(cont);
		// Payment details
		WebElement fname = driver.findElement(By.xpath("//input[@name='first_name']"));
		sendText(fname, readExcel("TaskExcelSheet2.xlsx", "Adactinhotel", 10, 1));
		WebElement lname = driver.findElement(By.xpath("//input[@name='last_name']"));
		sendText(lname, readExcel("TaskExcelSheet2.xlsx", "Adactinhotel", 11, 1));
		WebElement address = driver.findElement(By.xpath("//textarea[@name='address']"));
		sendText(address, readExcel("TaskExcelSheet2.xlsx", "Adactinhotel", 12, 1));
		WebElement credit = driver.findElement(By.xpath("(//input[@class='reg_input'])[3]"));
		sendText(credit, readExcel("TaskExcelSheet2.xlsx", "Adactinhotel", 13, 1));

		// using single drop down
		WebElement e = driver.findElement(By.xpath("//select[@name='cc_type']"));
		selectByValue(e, "MAST");
		WebElement month = driver.findElement(By.name("cc_exp_month"));
		selectByVisibleText(month, "August");
		WebElement year = driver.findElement(By.name("cc_exp_year"));
		selectByVisibleText(year, "2022");
		WebElement cvv = driver.findElement(By.xpath("//input[@name='cc_cvv']"));
		sendText(cvv, readExcel("TaskExcelSheet2.xlsx", "Adactinhotel", 16, 1));
		WebElement book = driver.findElement(By.id("book_now"));
		clickBtn(book);
		Thread.sleep(7000);
		WebElement att = driver.findElement(By.xpath("//input[@name='order_no']"));
		String attribute = att.getAttribute("value");
		//String order_no = readExcel("TaskExcelSheet2.xlsx", "Adactinhotel", 18, 0);
		//if((order_no.isEmpty()||order_no==null))
		writeinReadExcel("TaskExcelSheet2.xlsx", "Adactinhotel","order no",18, 0);
		writeinReadExcel("TaskExcelSheet2.xlsx", "Adactinhotel",attribute,19, 1);
		
		
			
		
	}

}
