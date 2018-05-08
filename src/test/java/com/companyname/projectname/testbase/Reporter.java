package com.companyname.projectname.testbase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reporter {
	
	private static List<Result> details;
	private static final String resultPlaceholder = "<!-- INSERT_RESULTS -->";
	private static final String templatePath = System.getProperty("user.dir")+"//src//test//resources//report_template.html";
			
	public Reporter() {
	}
	
	public static void initialize() {
		details = new ArrayList<Result>();
	}
	
	public static void report(String actualValue,String expectedValue) {
		if(actualValue.equals(expectedValue)) {
			Result r = new Result("Pass","Actual value '" + actualValue + "' matches expected value");
			details.add(r);
		} else {
			Result r = new Result("Fail","Actual value '" + actualValue + "' does not match expected value '" + expectedValue + "'");
			details.add(r);
		}
	}
	
	public static void showResults() {
		for (int i = 0;i < details.size();i++) {
			System.out.println("Result " + Integer.toString(i) + ": " + details.get(i).getResult());
		}
	}
	
	public static void writeResults(String testName) {
		try {
			String reportIn = new String(Files.readAllBytes(Paths.get(templatePath)));
			for (int i = 0; i < details.size();i++) {
				if(details.get(i).getResult().equals("Fail")){
					reportIn = reportIn.replaceFirst(resultPlaceholder,"<tr><td>" + Integer.toString(i+1) + "</td><td color='red'>" + details.get(i).getResult() + "</td><td>" + details.get(i).getResultText() + "</td></tr>" + resultPlaceholder);	
				}
				else{
					reportIn = reportIn.replaceFirst(resultPlaceholder,"<tr><td>" + Integer.toString(i+1) + "</td><td>" + details.get(i).getResult() + "</td><td>" + details.get(i).getResultText() + "</td></tr>" + resultPlaceholder);
				}
				
			}
			
			String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			String reportPath = System.getProperty("user.dir")+"//src//test//java//com//companyname//projectname//logs//" + currentDate + testName+".html";
			Files.write(Paths.get(reportPath),reportIn.getBytes(),StandardOpenOption.CREATE);
			
		} catch (Exception e) {
			System.out.println("Error when writing report file:\n" + e.toString());
		}
	}
}