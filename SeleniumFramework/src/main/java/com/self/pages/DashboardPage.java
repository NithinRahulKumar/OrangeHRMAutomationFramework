package com.self.pages;

import org.openqa.selenium.By;

import com.self.driver.DriverManager;
import com.self.enums.WaitStrategy;
import com.self.reports.ExtentLogger;

public final class DashboardPage extends BasePage {
	
	private final By dropdownLoginUser=By.xpath("//li[@class='oxd-userdropdown']");
	private final By labelDashboard = By.xpath("//h6[text()='Dashboard']");
	private final By linkLogout=By.xpath("//a[text()='Logout']");
	
	public DashboardPage clickLoginUserDropDown() {
		click(dropdownLoginUser,WaitStrategy.VISIBILITY, "user dropdown");
		ExtentLogger.pass("Clicked on UserDropDown");
		return this;
	}
	public String getsDashBoardMenuText() {
			 String text= DriverManager.getDriver().findElement(labelDashboard).getText();
			 ExtentLogger.pass("Captured DashBoard menu text successfully",true);
			 return text;
	}		
	public LoginPage clicksOnLogOut() {
		click(linkLogout,WaitStrategy.CLICKABLE, "logout");
		return new LoginPage();
	}
	
	
}