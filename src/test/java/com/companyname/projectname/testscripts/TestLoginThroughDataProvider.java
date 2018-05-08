package com.companyname.projectname.testscripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.logging.Logger;

import com.companyname.projectname.excelreader.Excel_Reader;
import com.companyname.projectname.pagelibrary.SignIn;
import com.companyname.projectname.testbase.TestBase;

public class TestLoginThroughDataProvider extends TestBase{
	SignIn signIn;
	static Logger log = Logger.getLogger(TestLoginThroughDataProvider.class.getName());
	
	@BeforeClass
	public void setUP() throws IOException{
		init();
	}
	
	public Object[][] getData(String ExcelName, String testcase) {
		Excel_Reader Data = new Excel_Reader(System.getProperty("user.dir") + "//src//test//resources//"+ExcelName);
		int rowNum = Data.getRowCount(testcase);
		System.out.println(rowNum);
		int colNum = Data.getColumnCount(testcase);
		Object sampleData[][] = new Object[rowNum - 1][colNum];
		for (int i = 2; i <=rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				sampleData[i - 2][j] = Data.getCellData(testcase, j, i);
			}
		}
		return sampleData;
	}
	
	@DataProvider
	public Object[][] loginData(){
		Object[][] data = getData("Login.xlsx", "Login");
		return data;
	}
	
	@Test(dataProvider = "loginData")
	public void TestLoginWithDataProvider(String TestCaseName, String Email, String Password,String runMode) throws InterruptedException{
        log.info("I am from data provider gest");
		if(runMode.equals("N")){
			throw new SkipException("Skipping the test");
		}
		signIn = new SignIn(driver);
		signIn.loginToApplication(Email, Password);
		Thread.sleep(3000);
		signIn.logout();
		
	}
	
	@AfterClass
	public void quitBrowser(){
		closeBrowser();
	}

}
