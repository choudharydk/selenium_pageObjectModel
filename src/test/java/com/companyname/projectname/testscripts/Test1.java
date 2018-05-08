package com.companyname.projectname.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.companyname.projectname.testbase.TestBase;

public class Test1 extends TestBase{
	int indexSI = 1;
	
	@Test
	public void testReport1() throws IOException{
		int a = 5;
		
		if(a == 5){
			updateResult(indexSI++, "testReport1", "Pass", "Test1");
		}
		else{
			updateResult(indexSI++, "testReport1", "Fail", "Test1");
		}
	}
	
	@Test
	public void testReport2() throws IOException{
        int a = 7;
		
		if(a == 7){
			updateResult(indexSI++, "testReport2", "Pass", "Test1");
		}
		else{
			updateResult(indexSI++, "testReport2", "Fail", "Test1");
		}
	}
	
	
	@Test
	public void testReport3() throws IOException{
		   int a = 7;
			
			if(a == 8){
				updateResult(indexSI++, "testReport3", "Pass", "Test1");
			}
			else{
				updateResult(indexSI++, "testReport3", "Fail", "Test1");
			}

	}
	
	@Test
	public void testReport4() throws IOException{
		
		try{
		int a = 2/0;
		updateResult(indexSI++, "testReport4", "Pass", "Test1");
		}
		catch(Exception e){
			
			updateResult(indexSI++, "testReport4", "Fail", "Test1");
		}
		
	}

}
