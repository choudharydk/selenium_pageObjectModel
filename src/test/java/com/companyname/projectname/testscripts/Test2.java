package com.companyname.projectname.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.companyname.projectname.testbase.TestBase;

public class Test2 extends TestBase{
	
int indexSI = 1;
	
	@Test
	public void testLoginWithValidData() throws IOException{
		int a = 5;
		
		if(a == 5){
			updateResult(indexSI++, "testLoginWithValidData", "Pass", "Test2");
		}
		else{
			updateResult(indexSI++, "testLoginWithValidData", "Fail", "Test2");
		}
	}
	
	@Test
	public void testLoginWithInvalidData() throws IOException{
        int a = 7;
		
		if(a == 7){
			updateResult(indexSI++, "testLoginWithInvalidData", "Pass", "Test2");
		}
		else{
			updateResult(indexSI++, "testLoginWithInvalidData", "Fail", "Test2");
		}
	}
	
	
	@Test
	public void verifyLogoutISDisplayed() throws IOException{
		   int a = 7;
			
			if(a == 8){
				updateResult(indexSI++, "verifyLogoutISDisplayed", "Pass", "Test2");
			}
			else{
				updateResult(indexSI++, "verifyLogoutISDisplayed", "Fail", "Test2");
			}

	}
	
	@Test
	public void testReport4() throws IOException{
		
		try{
		int a = 2/0;
		updateResult(indexSI++, "testReport4", "Pass", "Test2");
		}
		catch(Exception e){
			
			updateResult(indexSI++, "testReport4", "Fail", "Test2");
		}
		
	}
}
