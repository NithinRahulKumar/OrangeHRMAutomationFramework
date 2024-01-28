package com.self.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.self.enums.Headings;
import com.self.enums.LeftMenuItems;
import com.self.enums.TopSubMenuItems;
import com.self.enums.WaitStrategy;
import com.self.pages.pageComponents.CommonComponents;
import com.self.pages.pageComponents.LeftMenuComponents;
import com.self.utils.DynamicXpathUtils;

public final class PIMPage extends BasePage {
	
	private CommonComponents commonComponents;
	private LeftMenuComponents leftMenuComponents;
	
	public PIMPage() {
		commonComponents = new CommonComponents();
		leftMenuComponents = new LeftMenuComponents();
	}
	
	private String employeeName = "//label[text()='Employee Full Name']/parent::div/following-sibling::div/child::div//input[@name='%s']";
	private By loginEnableCheckbox = By.xpath("//p[text()='Create Login Details']/parent::div/child::div/child::label/child::span");
	
	
	public PIMPage clicksOnLeftMenuPIM() 
	{
		leftMenuComponents.clicksOnLeftMenu(LeftMenuItems.getValue("PIM"));
		return this;
	}
	
	public PIMPage toClickOnAddEmployee() {
		commonComponents.clicksOnElement(TopSubMenuItems.getValue("ADDEMPLOYEE"));
		return this;
	}
	
	public PIMPage toEnterTextinFirstNameinAddEmployee(String value) {
		String newXpath = DynamicXpathUtils.getXpath(employeeName, "firstName");
		sendKeys(By.xpath(newXpath),value, WaitStrategy.CLICKABLE, "First Name");
		return this;
	}
	
	public PIMPage toEnterinMiddleNameinAddEmployee(String value) {
		String newXpath = DynamicXpathUtils.getXpath(employeeName, "middleName");
		sendKeys(By.xpath(newXpath),value, WaitStrategy.CLICKABLE, "Middle Name");
		return this;
	}
	
	public PIMPage toEnterTextinLastNameinAddEmployee(String value) {
		String newXpath = DynamicXpathUtils.getXpath(employeeName, "lastName");
		sendKeys(By.xpath(newXpath),value, WaitStrategy.CLICKABLE, "Last Name");
		return this;
	}
	
	public PIMPage toEnableLoginDetailsCheckboxinAddEmployee() {
		click(loginEnableCheckbox,WaitStrategy.VISIBILITY, "Create Login Details");
		return this;
	}
	
	public PIMPage toEnterUserNameinAddEmployee(String value){
		commonComponents.entersTextinTextBox("Username",value);
		return this;
	}
	
	public PIMPage toEnterPasswordinAddEmployee(String value){
		commonComponents.entersTextinTextBox("Password",value);
		return this;
	}
	
	public PIMPage toEnterConfirmPasswordinAddEmployee(String value){
		commonComponents.entersTextinTextBox("Confirm Password",value);
		return this;
	}
	
	public PIMPage toClickOnSaveButtonInAddEmployee() {
		commonComponents.clicksOnSaveCancelButton(TopSubMenuItems.getValue("ADDEMPLOYEE"), "Save");
		return this;
	}
	
	public WebElement toCheckForSuccessfulSaveMessage() {
		return commonComponents.getSuccessMessageText("Successfully Saved");
	}
	
	public PIMPage toEnterNickNameinPersonalDetails(String value){
		commonComponents.entersTextinTextBox("Nickname",value);
		return this;
	}
	
	public PIMPage toEnterOtherIdinPersonalDetails(String value){
		commonComponents.entersTextinTextBox("Other Id",value);
		return this;
	}
	
	public PIMPage toEnterDriverLicenseNumberinPersonalDetails(String value){
		commonComponents.entersTextinTextBox("Driver License Number",value);
		return this;
	}
	
	public PIMPage toEnterLicenseExpiryDateinPersonalDetails(String value){
		commonComponents.entersTextinTextBox("License Expiry Date",value);
		return this;
	}
	
	public PIMPage toEnterSSNNumberinPersonalDetails(String value){
		commonComponents.entersTextinTextBox("SSN Number",value);
		return this;
	}
	
	public PIMPage toEnterSINumberinPersonalDetails(String value){
		commonComponents.entersTextinTextBox("SIN Number",value);
		return this;
	}
	
	public PIMPage selectsNationalityFromDropdownField (String nationality) {
		selectsValueFromDropdown(commonComponents.selectDropdownXpath("Nationality"), commonComponents.selectDropDownValues, nationality);
		return this;
	}
	
	public PIMPage selectsMaritalStatusFromDropdownField (String maritalStatus) {
		selectsValueFromDropdown(commonComponents.selectDropdownXpath("Marital Status"), commonComponents.selectDropDownValues, maritalStatus);
		return this;
	}
	
	public PIMPage toEnterDateOfBirthDateinPersonalDetails(String value){
		commonComponents.entersTextinTextBox("Date of Birth",value);
		return this;
	}
	
	public PIMPage toSelectGenderinPersonalDetails(String value){
		commonComponents.clicksOnradioButton("Gender","Male", value);
		return this;
	}
	
	public PIMPage toEnterMilitaryServiceinPersonalDetails(String value){
		commonComponents.entersTextinTextBox("Military Service",value);
		return this;
	}
	
	public PIMPage toSelectSmokerinPersonalDetails(String value){
		commonComponents.clicksOnradioButton("Smoker","Yes", value);
		return this;
	}
	
	public PIMPage toClickOnSaveButtonInEmployeeList() {
		commonComponents.clicksOnSaveCancelButton(TopSubMenuItems.getValue(Headings.getValue("PERSONALDETAILS")), "Save");
		return this;
	}
	
	public WebElement toCheckForSuccessfulUpadteMessage() {
		return commonComponents.getSuccessMessageText("Successfully Updated");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public PIMPage toClickOnEmployeeList() {
		commonComponents.clicksOnElement(TopSubMenuItems.getValue("EMPLOYEELIST"));
		return this;
	}
	
	public PIMPage toEnterEmployeeNameInEmployeeInformation(String value) {
		commonComponents.toSelectValueFromDynamicSearchTextBox("Employee Name",value);
		return this;
		
	}
	
	public PIMPage toClickOnSearchButton() {
		commonComponents.clicksOnSearchResetButton("Employee Information", "Search");
		return this;
	}
	
	
	public PIMPage deletesEmployeeFromEmployeeList(String employeeName) {
		deletesEmployeeFromEmployeeList(commonComponents.tableCellsXpath,employeeName, commonComponents.rowDeleteButton(employeeName)
				,commonComponents.confirmDeleteButton);
		return this;
	}
	
	
	
	

}
