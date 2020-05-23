package org.hcl.test;

import org.hcl.test1.BaseClassForFbPageLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QNo7Excel extends BaseClassForFbPageLogin {

	public static void main(String[] args) throws Exception {
		
		//static WebDriver driver;
		/*\\Datadriven.xlsx*/
		browserLaunch();
		getUrl("https://www.facebook.com/");
		//managingWindow();
		getTitle();
		getcurrentUrl();
		//WebElement login = driver.findElement(By.id("email"));
		//sendText(login ,getData("Datadriven.xlsx","Question5Day1", 0,1) );
		//WebElement password = driver.findElement(By.id("pass"));
		//sendText(password, getData( "Datadriven.xlsx","Question5Day1", 1,1));
		//WebElement btn = driver.findElement(By.id("loginbutton"));
		//clickBtn(btn);
	}
}
