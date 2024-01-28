package com.self.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.self.enums.ConfigProperties;
import com.self.pages.AdminPage;
import com.self.pages.LoginPage;
import com.self.utils.PropertyUtils;



public class AdminTest extends BaseTest {

	@Test()
	public void createsJobTitle(Map<String, String> data) {
		LoginPage loginpage = new LoginPage();
		AdminPage adminPage = new AdminPage();
		
		loginpage.enterUserName(PropertyUtils.getProperty(ConfigProperties.USERNAME))
		.enterPassword(PropertyUtils.getProperty(ConfigProperties.PASSWORD)).clickOnLogin();
		
		boolean jobTitleIsCreated=adminPage.clicksOnLeftMenuAdmin()
				.toSelectJobTitlesFromJobMenu()
				.toClickOnAddButtonInJobTitles()
				.toEnterJobTitle(data.get("jobTitle"))
				.toEnterJobDescription(data.get("jobDescription"))
				.toEnterJobNote(data.get("jobNote"))
				.toClickOnSaveButtonInJobTitle()
				.checksForAddedJobTitle(data.get("jobTitle"));
				
		Assert.assertTrue(jobTitleIsCreated);
		
		Boolean deleteJobRoleSuccessfulMessage = adminPage.toDeleteJobTitle(data.get("jobTitle"))
				.toCheckForSuccessfulDeleteMessage().isDisplayed();
		
		Assert.assertTrue(deleteJobRoleSuccessfulMessage);

	}
	
	@Test()
	public void createsPayGrade(Map<String, String> data) {
		
		LoginPage loginpage = new LoginPage();
		AdminPage adminPage = new AdminPage();
		
		loginpage.enterUserName(PropertyUtils.getProperty(ConfigProperties.USERNAME))
		
		.enterPassword(PropertyUtils.getProperty(ConfigProperties.PASSWORD)).clickOnLogin();
		
		boolean payGradeIsCreated = adminPage.clicksOnLeftMenuAdmin()
				.toSelectPayGradesFromJobMenu()
				.toClickOnAddButtonInPayGrades()
				.toEnterPayGradeName(data.get("payGradeName"))
				.toClickOnSaveButtonInPayGrade()
				.toClickOnAddButtonInAddCurrency()
				.selectsCurrencyFromDropdownField(data.get("currencyName"))
				.toEnterMinimumSalaryInAddCurrency(data.get("currencyMinimumSalary"))
				.toEnterMaximumSalaryInAddCurrency(data.get("currencyMaximumSalary"))
				.toClickOnSaveButtonInAddCurrency()
				.toSelectPayGradesFromJobMenu()
				.checksForAddedPayGrade(data.get("payGradeName"));
		
		Assert.assertTrue(payGradeIsCreated);
		
		Boolean deletePayGradeSuccessfulMessage = adminPage.toDeletePayGrade(data.get("payGradeName"))
				.toCheckForSuccessfulDeleteMessage().isDisplayed();
		
		Assert.assertTrue(deletePayGradeSuccessfulMessage);
		
		
	}
	
	@Test()
	public void createsEmploymentStatus(Map<String, String> data) {
		LoginPage loginpage = new LoginPage();
		AdminPage adminPage = new AdminPage();
		
		loginpage.enterUserName(PropertyUtils.getProperty(ConfigProperties.USERNAME))
		
		.enterPassword(PropertyUtils.getProperty(ConfigProperties.PASSWORD)).clickOnLogin();
		
		boolean employmentStatusIsCreated = adminPage.clicksOnLeftMenuAdmin()
				.toSelectEmploymentStatusFromJobMenu()
				.toClickOnAddButtonInEmploymentStatus()
				.toEnterNameInEmploymentStatus(data.get("employmentStatusName"))
				.toClickOnSaveButtonInEmploymentStatus()
				.checksForAddedEmploymentStatus(data.get("employmentStatusName"));
		
		Assert.assertTrue(employmentStatusIsCreated);
		
		Boolean deleteEmploymentStatusSuccessfulMessage = adminPage.toDeleteEmploymentStatus(data.get("employmentStatusName"))
				.toCheckForSuccessfulDeleteMessage().isDisplayed();
		
		Assert.assertTrue(deleteEmploymentStatusSuccessfulMessage);
		
	}
	
	@Test()
	public void createsJobCategories(Map<String, String> data) {
		LoginPage loginpage = new LoginPage();
		AdminPage adminPage = new AdminPage();
		
		loginpage.enterUserName(PropertyUtils.getProperty(ConfigProperties.USERNAME))
		.enterPassword(PropertyUtils.getProperty(ConfigProperties.PASSWORD)).clickOnLogin();
		
		boolean isJobCategoriesCreated = adminPage.clicksOnLeftMenuAdmin()
				.toSelectJobCategoriesFromJobMenu()
				.toClickOnAddButtonInJobCategories()
				.toEnterNameInJobCategories(data.get("jobCategoriesName"))
				.toClickOnSaveButtonInJobCategories()
				.checksForAddedJobCategories(data.get("jobCategoriesName"));
		
		Assert.assertTrue(isJobCategoriesCreated);
				
		Boolean deleteJobCategoriesSuccessfulMessage = adminPage.toDeleteJobCategories(data.get("jobCategoriesName"))
				.toCheckForSuccessfulDeleteMessage().isDisplayed();
		
		Assert.assertTrue(deleteJobCategoriesSuccessfulMessage);
		
	}
	
	@Test()
	public void updatesGeneralInformationData(Map<String, String> data) {
		LoginPage loginpage = new LoginPage();
		AdminPage adminPage = new AdminPage();
		
		loginpage.enterUserName(PropertyUtils.getProperty(ConfigProperties.USERNAME))
		.enterPassword(PropertyUtils.getProperty(ConfigProperties.PASSWORD)).clickOnLogin();
		
		boolean generalInformationUpdateSuccessfulMessage = adminPage.clicksOnLeftMenuAdmin()
				.toSelectGeneralInformationFromOrganization()
				.toClickOnEditCheckBoxInGeneralInformation()
				.toUpdateRegistrationNumberInGeneralInformation(data.get("registrationNumber"))
				.toUpdateTaxIDInGeneralInformation(data.get("taxId"))
				.toUpdatePhoneInGeneralInformation(data.get("phone"))
				.toUpdateFaxNumberInGeneralInformation(data.get("fax"))
				.toUpdateEmailInGeneralInformation(data.get("email"))
				.toUpdateAddressStreet1InGeneralInformation(data.get("addressStreet1"))
				.toUpdateAddressStreet2InGeneralInformation(data.get("addressStreet2"))
				.toUpdateCityInGeneralInformation(data.get("city"))
				.toUpdateStateInGeneralInformation(data.get("state"))
				.toUpdateZipInGeneralInformation(data.get("zip"))
				.toUpdateCountryInGeneralInformation(data.get("country"))
				.toUpdateNotesInGeneralInformation(data.get("notes"))
				.toClickOnSaveButtonInGeneralInformation()
				.toCheckForSuccessfulUpdateMessage().isDisplayed();
		
		Assert.assertTrue(generalInformationUpdateSuccessfulMessage);
		
	}
}
