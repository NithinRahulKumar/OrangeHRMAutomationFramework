package com.self.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.self.enums.ConfigProperties;
import com.self.pages.LoginPage;
import com.self.pages.PIMPage;
import com.self.utils.PropertyUtils;

public class PIMTest extends BaseTest {
	
	@Test
	public void creationOfEmployee(Map<String, String> data) {
		LoginPage loginpage = new LoginPage();
		PIMPage pimPage = new PIMPage();
		
		loginpage.enterUserName(PropertyUtils.getProperty(ConfigProperties.USERNAME))
		.enterPassword(PropertyUtils.getProperty(ConfigProperties.PASSWORD)).clickOnLogin();
		
		 boolean employeeCreationSuccessMessage = pimPage.clicksOnLeftMenuPIM().toClickOnAddEmployee().toEnterTextinFirstNameinAddEmployee(data.get("firstName"))
		.toEnterinMiddleNameinAddEmployee(data.get("middleName"))
		.toEnterTextinLastNameinAddEmployee(data.get("lastName"))
		.toEnableLoginDetailsCheckboxinAddEmployee()
		.toEnterUserNameinAddEmployee(data.get("userName"))
		.toEnterPasswordinAddEmployee(data.get("password"))
		.toEnterConfirmPasswordinAddEmployee(data.get("password"))
		.toClickOnSaveButtonInAddEmployee()
		.toCheckForSuccessfulSaveMessage().isDisplayed();
		 Assert.assertTrue(employeeCreationSuccessMessage); 
	}
	
	
	@Test
	public void deletionOfEmployeeFromEmployeeList(Map<String, String> data) {
		LoginPage loginpage = new LoginPage();
		PIMPage pimPage = new PIMPage();
		
		loginpage.enterUserName(PropertyUtils.getProperty(ConfigProperties.USERNAME))
		.enterPassword(PropertyUtils.getProperty(ConfigProperties.PASSWORD)).clickOnLogin();
		
		pimPage.clicksOnLeftMenuPIM().toClickOnEmployeeList()
		.toEnterEmployeeNameInEmployeeInformation(data.get("lastName"))
		.toClickOnSearchButton()
		.deletesEmployeeFromEmployeeList(data.get("first&middleName"));
	}
	
	

}
