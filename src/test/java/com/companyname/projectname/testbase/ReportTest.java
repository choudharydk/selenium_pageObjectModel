package com.companyname.projectname.testbase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class ReportTest {
	
	public static void main (String args[]) {
		
		WebDriver driver = new FirefoxDriver();
		Reporter.initialize();
		//driver.get("http://automationpractice.com/");
		
		for (int i = 1; i <=5; i++) {
			//WebElement el = driver.findElement(By.id("textfield" + Integer.toString(i)));
			Result obj = new Result();
			//obj.test();
			Reporter.report("TestLogin", "Text field " + "pass");
		}
		
		Reporter.writeResults("test");
		driver.close();	
	}
	
}