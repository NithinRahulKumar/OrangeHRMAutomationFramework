package com.self.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
	
	private DriverManager() {
		
	}

	private static ThreadLocal<WebDriver> localDriver= new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		return localDriver.get();
	}
	public static void setDriver(WebDriver driverRef) {
		if(Objects.nonNull(driverRef)) {
			localDriver.set(driverRef);
		}
	}
	public static void unload() {
		localDriver.remove();
	}
}
