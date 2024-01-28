package com.self.listeners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.self.reports.ExtentLogger;
import com.self.reports.ExtentReport;

public class ListenerClass implements ITestListener,ISuiteListener {
	
	@Override
	public void onStart(ISuite suite){
				
		ExtentReport.initReports();
 }
	@Override
	public void onFinish(ISuite suite){
	
		ExtentReport.flushReports();
	}
	@Override
	public void onTestStart(ITestResult result){
		ExtentReport.createTest(result.getMethod().getDescription());
	}
	@Override
	public void onTestSuccess(ITestResult result){
	
		ExtentLogger.pass(result.getMethod().getMethodName() + " is passed",true);
	}

	@Override
	public void onTestFailure(ITestResult result){
		try {
			ExtentLogger.fail(result.getMethod().getMethodName() + " is failed",true);
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result){
		try {
			ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped",true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result){

	}
	@Override
	public void onStart(ITestContext context){

	}
	@Override
	public void onFinish(ITestContext context){

	}

}
