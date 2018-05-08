package com.companyname.projectname.pagelibrary;



import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.companyname.projectname.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class SignIn extends TestBase{
	
	WebDriver driver;
	static Logger log = Logger.getLogger(SignIn.class.getName());
	
	By signIn = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a");
	By createAccEmailAddr = By.xpath("//*[@id='email_create']");
	By allreadyRegEmailAddr = By.xpath("//*[@id='email']");
	By allReadyRegPass = By.xpath("//*[@id='passwd']");
	By submitbutton = By.xpath("//*[@id='SubmitLogin']");
	By createAnAccount = By.xpath("//*[@id='SubmitCreate']");
	By signOut = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[2]/a");
	

	
	public SignIn(WebDriver driver){
		this.driver = driver;
	}
	/**
	 * This method will click on sign in link in login page
	 */
	public void clickonSignIn(){
		log.info("clicking on sign in link");
		
		try {
			driver.findElement(signIn).click();
			test.log(LogStatus.PASS, "Clicking on sing in Link");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(LogStatus.FAIL,"Clicking on sing in Link");
		}
	}
	
	/**
	 * This method will enter email address to create an account text box.
	 * In Login Page
	 * @param emailAddress
	 */
	public void enterEmailAddressToCraeteAccount(String emailAddress){
		log.info("entering email address to create an account");
		driver.findElement(createAccEmailAddr).sendKeys(emailAddress);
	}
	
	public void enterAllreadyRegisterUserEmail(String emailAddress){
		log.info("entering email addredd to all ready registered user text box");
		driver.findElement(allreadyRegEmailAddr).sendKeys(emailAddress);
	}
	
	public void clickonSignInToAccount(){
		log.info("clicking on sign in button");
		driver.findElement(submitbutton).click();
	}
	
	public void enterAllReadyRegisteredPassword(String password){
		log.info("enterign password to password text box");
		driver.findElement(allReadyRegPass).sendKeys(password);
	}
	
	public void clickOnCreateAnAccoun(){
		log.info("Clicking on create an account");
		driver.findElement(createAnAccount).click();
	}
	
	/**
	 * This Method is used for login to application
	 */

	public void loginToApplication(){
		clickonSignIn();
		enterAllreadyRegisterUserEmail("test902@gmail.com");
		enterAllReadyRegisteredPassword("password");
		clickonSignInToAccount();
	}
	
	public void loginToApplication(String Email, String Password){
		clickonSignIn();
		enterAllreadyRegisterUserEmail(Email);
		enterAllReadyRegisteredPassword(Password);
		clickonSignInToAccount();
	}
	
	public void enterDataToCreateAnAccount(String emailAddress){
		clickonSignIn();
		enterEmailAddressToCraeteAccount(emailAddress);
		clickOnCreateAnAccoun();
	}
	
	public void logout(){
		try{
		boolean isdisplayed = driver.findElement(signOut).isDisplayed();
		if(isdisplayed){
			driver.findElement(signOut).click();
		}
		}
		catch(Exception e){
			Assert.assertTrue(false, "sign out buttom is not displayed");
		}
	}
}
