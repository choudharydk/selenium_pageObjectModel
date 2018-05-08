package com.companyname.projectname.customelistener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.companyname.projectname.testbase.TestBase;

public class Listner extends TestBase implements ITestListener{
	
	

	public void onTestStart(ITestResult result) {
		 Reporter.log("Test started running:"  + result.getMethod().getMethodName() + " at:" + result.STARTED );
	 }

	 public void onTestSuccess(ITestResult result) {
	  
	 }

	public void onTestFailure(ITestResult result) {
	  if (!result.isSuccess()) {
	   String userDirector = System.getProperty("user.dir");
	   String customeLocation = "//src//test//java//com//companyname//projectname//screenshots//";
	   String failureImageFileName = userDirector+customeLocation+new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime())+"-"+result.getMethod().getMethodName()+ ".png";
	   File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	   try {
	    FileUtils.copyFile(scrFile, new File(failureImageFileName));
	   } catch (IOException e) {
	    e.printStackTrace();
	   }
	   //String userDirector = System.getProperty("user.dir") + "/";
	   Reporter.log("<a href=\"" + failureImageFileName + "\"><img src=\"file:///" + failureImageFileName +"\" alt=\"\"" + "height='100' width='100'/> " + "<br />");
	   //Reporter.log("<a href=\""+ failureImageFileName + "\">");
	   Reporter.setCurrentTestResult(null);
	   Reporter.log(result.getName()+ "--Test method failed\n");

	  }
	  
	 }

	 public void onTestSkipped(ITestResult result) {
	  
	 }

	 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	 }

	public void onFinish(ITestContext arg0) {
     

	}

	public void onStart(ITestContext arg0) {

	}

}
