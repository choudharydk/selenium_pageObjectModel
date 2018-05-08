package com.companyname.projectname.pagelibrary;

import org.testng.annotations.Test;


import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateAnAccount{
	
	WebDriver driver;
	static Logger log = Logger.getLogger(CreateAnAccount.class.getName());
	
    public By createAnAccountErrorMsg = By.xpath("//*[@id='create_account_error']/ol/li");
	public By mrRadionButton =  By.xpath("//*[@id='id_gender1']") ;
	public By mrsRadioButton =  By.xpath("//*[@id='id_gender2']") ;
	public By craeteAnAccoutn =  By.xpath("//*[@id='noSlide']/h1");
	public By yourPersonalInfo =  By.xpath("//*[@id='account-creation_form']/div[1]/h3");
	public By firstName =  By.xpath("//*[@id='customer_firstname']");
	public By lastname =  By.xpath("//*[@id='customer_lastname']");
	public By emailAddress =  By.xpath("//*[@id='email']");
	By password = By.xpath("//*[@id='passwd']");
	By days =  By.xpath("//*[@id='days']");
	By months =  By.xpath("//*[@id='months']");
	By year = By.xpath("//*[@id='years']");
	By signUpForOurNewsletter =  By.xpath("//*[@id='newsletter']");
	By receiveSpecialOffer =  By.xpath("//*[@id='optin']");
	By yourAddress =  By.xpath("//*[@id='account-creation_form']/div[2]/h3");
	
	By yourAddressFirstName =  By.id("firstname");
	By yourAddressLasstName =  By.id("lastname");
	By yourAddressCompany =  By.id("firstname");
	By yourAddressPrimary =  By.id("address1");
	By yourAddressSecondry =  By.id("address2");
	By yourAddressCity =  By.id("city");
	By yourAddressPostalCode =  By.id("postcode");
	By yourAddressStateDropDown = By.xpath("//*[@id='id_state']");
	By yourAddressCountryName = By.xpath("//*[@id='id_country']");
	By yourAddressPhoneNumber = By.xpath("//*[@id='phone_mobile']");
	By yourAddressAlias = By.xpath("//*[@id='alias']");
	
	public CreateAnAccount(WebDriver driver){
		this.driver = driver;
	}
	
	/**
	 * This method will select Mr Radio button in Create an account page
	 */
	public void selectMrRadionButton(){
		log.info("selecting Mr Radion Button");
		driver.findElement(mrRadionButton).click();
	}
	
	public boolean verifyCreateAnAccountErrorMsg(){
		try{
			log.info("checking for creat an accoutn error message");
			driver.findElement(createAnAccountErrorMsg).isDisplayed();
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public void selectMrsRadionButton(){
		log.info("selecting Mrs Radion Button");
		driver.findElement(mrsRadioButton).click();
	}
	
	public boolean verifyCreateAnAccoutnLabel(){
		log.info("verifying Create an account label display on UI");
		try{
			driver.findElement(craeteAnAccoutn).isDisplayed();
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public boolean verifyYourPersonalInfoLabel(){
		log.info("verifying your personal info label displayed on UI");
		try{
			driver.findElement(yourPersonalInfo).isDisplayed();
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public void enterFirstName(String firstName){
		log.info("entering first name");
		driver.findElement(this.firstName).sendKeys(firstName);
	}
	
	public void enterLastName(String lastName){
		log.info("entering last name");
		driver.findElement(this.lastname).sendKeys(lastName);
	}
	
	public void enterPassowrd(String password){
		log.info("entering password");
		driver.findElement(this.password).sendKeys(password);
	}
	
	public void enterEmailAddress(String emailAddress){
		log.info("entering emial address");
		driver.findElement(this.emailAddress).sendKeys(emailAddress);
	}
	
	public void selectDaysInDropDown(String day) throws InterruptedException{
		log.info("clicking on day drop down");
		driver.findElement(days).click();
		Thread.sleep(1000);
		//.//*[@id='days']/option[10]
		String day1 = "//*[@id='days']/option[";
		String day2 = "]";
		log.info("selecting day in day day drop down");
		driver.findElement(By.xpath(day1+day+day2)).click();;
	}
	
	public void selectMonthInDropDown(String month) throws InterruptedException{
		log.info("clicking on month drop down");
		driver.findElement(months).click();
		Thread.sleep(1000);
		List<WebElement> monthsData = driver.findElements(By.xpath("//*[@id='months']/option"));
		for(WebElement mon : monthsData){
			//System.out.println(mon.getText());
			if(mon.getText().trim().toLowerCase().equals(month.toLowerCase())){
				log.info("selecting month in month drop down");
				mon.click();
			}
		}
	}
	
	public void selectYearInDropDown(String Year) throws InterruptedException{
		log.info("clicking on year drop down");	
		driver.findElement(year).click();
		Thread.sleep(1000);
		List<WebElement> years = driver.findElements(By.xpath("//*[@id='years']/option"));
		for(WebElement year : years){
			if(year.getText().trim().equals(Year)){
				log.info("clickin on year option");
				year.click();
			}
		}
	}
	
	public void enterYourAddressFirstName(String FirstName){
		log.info("entering your address first name");
		driver.findElement(yourAddressFirstName).sendKeys(FirstName);
	}
	
	public void enterYourAddressLastName(String LastName){
		log.info("entering your address lastname name");
		driver.findElement(yourAddressLasstName).sendKeys(LastName);
	}
	
	public void enterYourAddressPrimary(String Address){
		log.info("entering your primary Address");
		driver.findElement(yourAddressPrimary).sendKeys(Address);
	}
	
	public void enterYourAddressSecondry(String Address){
		log.info("entering your secondry Address");
		driver.findElement(yourAddressSecondry).sendKeys(Address);
	}
	
	public void enterYourAddressCityName(String cityName){
		log.info("entering your Address city name");
		driver.findElement(yourAddressCity).sendKeys(cityName);
	}
	
	public void selectYourAddressState(String stateName) throws InterruptedException{
		log.info("clicking on your Address State Drop Down");
		new Select(driver.findElement(By.id("id_state"))).selectByVisibleText(stateName);

	}
	
	public void enterYourAddressZipCode(){
		log.info("entering your Address zip code");
		driver.findElement(yourAddressPostalCode).sendKeys("00000");
	}
	
	public void selectYourAddressCountry() throws InterruptedException{
		log.info("clicking on your Address Country Name");
		driver.findElement(yourAddressCountryName).click();
		Thread.sleep(1000);
		log.info("selecting Country Name");
		driver.findElement(By.xpath("//*[@id='id_country']/option[2]")).click();
	}	
	
	public void enterYourAddressMobilePhone(){
		log.info("entering your Address phone nummber");
		driver.findElement(yourAddressPhoneNumber).sendKeys("9999999999");
	}
	
	public void enterYourAddressAlias(){
		log.info("entering your Address alias");
		driver.findElement(yourAddressAlias).sendKeys("Testing");
	}
	
	public void clickOnRegister(){
		log.info("clicking on register");
		driver.findElement(By.xpath("//*[@id='submitAccount']")).click();
	}
	
	public boolean verifyRegistrationMsg(){
		String msg = driver.findElement(By.xpath("//*[@id='center_column']/p")).getText();
		if(msg.contains("Welcome123 to your account. Here you can manage all of your personal information and orders.")){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	@Test
	public void testUserRegistration(String firstName, String lastName, String password, String day, String month, String year) throws InterruptedException{
		selectMrRadionButton();
		enterFirstName(firstName);
		enterLastName(lastName);
		enterPassowrd(password);
		selectDaysInDropDown(day);
		selectMonthInDropDown(month);
		selectYearInDropDown(year);
		enterYourAddressFirstName("FirstName");
		enterYourAddressLastName("LastName");
		enterYourAddressPrimary("Primary Address");
		enterYourAddressSecondry("Secondary Address");
		enterYourAddressCityName("Muzaffarpur");
		selectYourAddressState("Indiana");
		enterYourAddressZipCode();
		selectYourAddressCountry();
		enterYourAddressMobilePhone();
		clickOnRegister();
	}
}


