package com.self.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.self.driver.DriverManager;
import com.self.enums.WaitStrategy;

public final class LoginPage extends BasePage {
	
	private final By textboxUserName= By.xpath("//input[@name='username']");
	private final By textboxPassword = By.xpath("//input[@name='password']");
	private final By buttonLogin= By.xpath("//button[@type='submit']");
	private final By logoOrangehrm=By.xpath("//img[@alt='company-branding']");
	
	public LoginPage enterUserName(String userName) {
		sendKeys(textboxUserName,userName,WaitStrategy.NONE, "user name");
		return this;
	}
	public LoginPage enterPassword(String password) {
		sendKeys(textboxPassword,password,WaitStrategy.NONE, "password");
		return this;
	}
	public WebElement orangeHRMLogo() {
		return DriverManager.getDriver().findElement(logoOrangehrm);
		
	}
	public DashboardPage clickOnLogin()  {
		click(buttonLogin,WaitStrategy.CLICKABLE, "login");
		return new DashboardPage();
	}
	
	

}
