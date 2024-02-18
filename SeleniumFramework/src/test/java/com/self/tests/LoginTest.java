package com.self.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.self.enums.ConfigProperties;
import com.self.pages.DashboardPage;
import com.self.pages.LoginPage;
import com.self.utils.PropertyUtils;

public class LoginTest extends BaseTest {

	@Test
	public void login(Map<String, String> data) {
		LoginPage loginpage = new LoginPage();
		String dashboardText = loginpage.enterUserName(PropertyUtils.getProperty(ConfigProperties.USERNAME))
				.enterPassword(PropertyUtils.getProperty(ConfigProperties.PASSWORD)).clickOnLogin()
				.getsDashBoardMenuText();
		Assert.assertEquals(dashboardText, "Dashboard");
		boolean logOut = new DashboardPage().clickLoginUserDropDown().clicksOnLogOut().orangeHRMLogo().isDisplayed();
		Assert.assertTrue(logOut);
	}

}
