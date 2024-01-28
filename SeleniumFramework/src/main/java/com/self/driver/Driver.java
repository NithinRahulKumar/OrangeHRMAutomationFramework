package com.self.driver;
import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.self.constants.FrameworkConstants;
import com.self.enums.ConfigProperties;
import com.self.utils.PropertyUtils;

public final class Driver {
	private Driver() {}
	
	
	
	public static void initDriver() {
		if(Objects.isNull( DriverManager.getDriver())) {
		 WebDriver driver=new ChromeDriver();
		 DriverManager.setDriver(driver);
		 DriverManager.getDriver().get(PropertyUtils.getProperty(ConfigProperties.URL));
		 DriverManager.getDriver().manage().window().maximize();
		 DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.getImplicitWaitTime()));
		}
	}
	public static void quitDriver() {
		if(Objects.nonNull( DriverManager.getDriver())) {
		DriverManager.getDriver().quit();
		 DriverManager.unload();
		}
	}
	

}
