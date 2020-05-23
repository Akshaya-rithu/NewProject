package org.hcl.test1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FacebookEntry extends BaseClassForFbPageLogin {

	public static void main(String[] args) throws Exception {
		/*\\Datadriven.xlsx*/
		browserLaunch();
		getUrl("https://www.facebook.com/");
		//managingWindow();
		getTitle();
		getcurrentUrl();
		WebElement login = driver.findElement(By.id("email"));
		sendText(login ,getData("Datadriven.xlsx","Question5Day1", 0,1) );
		WebElement password = driver.findElement(By.id("pass"));
		sendText(password, getData( "Datadriven.xlsx","Question5Day1", 1,1));
		WebElement btn = driver.findElement(By.id("loginbutton"));
		clickBtn(btn);
	}

}
