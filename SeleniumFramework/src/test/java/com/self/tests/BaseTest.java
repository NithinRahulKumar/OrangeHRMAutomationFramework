package com.self.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.self.driver.Driver;

public class BaseTest {
	
	@BeforeSuite
	protected void beforeSuite() {
		
	}
	
	@AfterSuite
	protected void afterSuite() {
		
	}
	@BeforeMethod
	protected void setUp() {
		
		Driver.initDriver();
		
	}
	@AfterMethod
	protected void tearDown() {
		
		Driver.quitDriver();
	}
	

}

