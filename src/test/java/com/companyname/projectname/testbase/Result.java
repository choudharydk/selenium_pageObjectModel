package com.companyname.projectname.testbase;

import org.testng.annotations.Test;

public class Result {
	
	private String result;
	private String resultText;
	
	public Result(String result,String resultText) {
		this.result = result;
		this.resultText = resultText;
	}
	public Result() {

	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getResult() {
		return this.result;
	}
	
	public void setResultText(String resultText) {
		this.resultText = resultText;
	}
	
	public String getResultText() {
		return this.resultText;
	}	
	
	@Test
	public void test(){
		Reporter.report("test", "test");
		Reporter.report("test", "test1");
		Reporter.report("test", "test2");
	}
}