package com.companyname.projectname.testscripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import org.testng.Assert;
import org.testng.Reporter;

import java.io.IOException;

import com.companyname.projectname.customelistener.Listner;
import com.companyname.projectname.pagelibrary.CreateAnAccount;
import com.companyname.projectname.pagelibrary.SignIn;
import com.companyname.projectname.testbase.TestBase;

public class TC002_testRegistraion extends TestBase{
	SignIn signIn;
	CreateAnAccount createAnAccount;

	
	String firstName ="FirstName";
	String lastName = "LastName";
	String password = "Password";
	String emailAddress = "email"+System.currentTimeMillis()+"@gmail.com";
	String day = "10";
	String month = "july";
	String year = "2007";
	@BeforeClass
	public void setUP() throws IOException{
		init();

		signIn = new SignIn(driver);
		createAnAccount = new CreateAnAccount(driver);
	}
	
	@Test(priority = 0, enabled = true, description = "Test Registration with valid data")
	public void testRegistraionWithValidData() throws InterruptedException{
		signIn.enterDataToCreateAnAccount(emailAddress);
		expliciteWait(driver.findElement(createAnAccount.mrRadionButton), 30);
		createAnAccount.testUserRegistration(firstName, lastName, password, day, month, year);
		waitFor(2);
		boolean isSuccess = createAnAccount.verifyRegistrationMsg();
		if(isSuccess){
			Assert.assertTrue( true,"Registration test is pass");
		}
		else{
			Assert.assertTrue(false, "Registration test is fail");	
		}
	}
	
	@Test(priority = 1, enabled = true, description = "Test Registration with invalid data")
	public void testRegistraionWithInvalidData() throws InterruptedException{
		signIn.logout();
		signIn.enterDataToCreateAnAccount(emailAddress);
		waitFor(2);
		boolean isSuccess = createAnAccount.verifyCreateAnAccountErrorMsg();
		if(isSuccess){
			Assert.assertTrue(true, "Registration test for invalid data is pass");
		}
		else{
			Assert.assertTrue(false, "Registration test for invalid data is fail");	
		}
	}
	
	@AfterClass
	public void quitBrowser(){
		closeBrowser();
	}

}
