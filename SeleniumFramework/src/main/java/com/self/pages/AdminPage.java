package com.self.pages;
import org.openqa.selenium.WebElement;
import com.self.enums.LeftMenuItems;
import com.self.enums.TopMenuItems;
import com.self.enums.TopSubMenuItems;
import com.self.pages.pageComponents.CommonComponents;
import com.self.pages.pageComponents.LeftMenuComponents;
import com.self.pages.pageComponents.TopMenuComponents;

public class AdminPage extends BasePage 
{
	private CommonComponents commonComponents;
	private TopMenuComponents topMenuComponents;
	private LeftMenuComponents leftMenuComponents;
	public AdminPage() 
	{
		commonComponents = new CommonComponents();
		topMenuComponents = new TopMenuComponents();
		leftMenuComponents = new LeftMenuComponents();
	}

	public AdminPage clicksOnLeftMenuAdmin() 
	{
		leftMenuComponents.clicksOnLeftMenu(LeftMenuItems.getValue("ADMIN"));
		return this;
	}
	
	public AdminPage toSelectJobTitlesFromJobMenu() {
		topMenuComponents.selectsSubMenuFromMenuDropdown(TopMenuItems.getValue("JOB"),  TopSubMenuItems.getValue("JOBTITLES"));
		return this;	
	}
	
	public AdminPage toClickOnAddButtonInJobTitles() {
		commonComponents.clicksOnAddButton(TopSubMenuItems.getValue("JOBTITLES"));
		return this;
	}
	
	public AdminPage toEnterJobTitle(String value) {
		commonComponents.entersTextinTextBox("Job Title", value);
		return this;
	}
	
	public AdminPage toEnterJobDescription(String value) {
		commonComponents.entersTextinFreeTextBox("Job Description", value);
		return this;
	}
	
	public AdminPage toEnterJobNote(String value) {
		commonComponents.entersTextinFreeTextBox("Note", value);
		return this;
	}
	
	public AdminPage toClickOnSaveButtonInJobTitle() {
		commonComponents.clicksOnSaveCancelButton(TopSubMenuItems.getValue("JOBTITLESHEADING"), "Save");
		return this;
	}
	
	public boolean checksForAddedJobTitle(String jobTitleText) {
		return returnsPresenceOfWebElementFromList(commonComponents.tableCellsXpath, jobTitleText);
	}
	
	public AdminPage toDeleteJobTitle(String jobTitleText) {
		deletesRowFromTable(commonComponents.tableCellsXpath,jobTitleText, commonComponents.rowDeleteButton(jobTitleText)
				,commonComponents.confirmDeleteButton);
		return this;
	}
	
	public WebElement toCheckForSuccessfulDeleteMessage() {
		return commonComponents.getSuccessMessageText("Successfully Deleted");
	}
	
	public WebElement toCheckForSuccessfulUpdateMessage() {
		return commonComponents.getSuccessMessageText("Successfully Updated");
	}
	
	public AdminPage toSelectPayGradesFromJobMenu() {
		topMenuComponents.selectsSubMenuFromMenuDropdown(TopMenuItems.getValue("JOB"),  TopSubMenuItems.getValue("PAYGRADES"));
		return this;	
	}
	
	public AdminPage toClickOnAddButtonInPayGrades() {
		commonComponents.clicksOnAddButton(TopSubMenuItems.getValue("PAYGRADES"));
		return this;
	}
	
	public AdminPage toEnterPayGradeName(String value) {
		commonComponents.entersTextinTextBox("Name", value);
		return this;
	}
	
	public AdminPage toClickOnSaveButtonInPayGrade() {
		commonComponents.clicksOnSaveCancelButton(TopSubMenuItems.getValue("ADDPAYGRADES"), "Save");
		return this;
	}
	
	public boolean checksForAddedPayGrade(String payGradeName) {
		return returnsPresenceOfWebElementFromList(commonComponents.tableCellsXpath, payGradeName);
	}
	
	public AdminPage toDeletePayGrade(String payGradeName) {
		deletesRowFromTable(commonComponents.tableCellsXpath,payGradeName, commonComponents.rowDeleteButton(payGradeName)
				,commonComponents.confirmDeleteButton);
		return this;
	}
	
	public AdminPage toClickOnAddButtonInAddCurrency() {
		topMenuComponents.toClickOnAddButtonInCurrencies();
		return this;
	}
	
	public AdminPage selectsCurrencyFromDropdownField (String currencyName) {
		selectsValueFromDropdown(commonComponents.selectDropdownXpath("Currency"), commonComponents.selectDropDownValues, currencyName);
		return this;
	}
	
	public AdminPage toEnterMinimumSalaryInAddCurrency(String value) {
		commonComponents.entersTextinTextBox("Minimum Salary", value);
		return this;
	}
	
	public AdminPage toEnterMaximumSalaryInAddCurrency(String value) {
		commonComponents.entersTextinTextBox("Maximum Salary", value);
		return this;
	}
	
	public AdminPage toClickOnSaveButtonInAddCurrency() {
		commonComponents.clicksOnSaveCancelButton(TopSubMenuItems.getValue("ADDCURRENCY"), "Save");
		return this;
	}
	
	public AdminPage toSelectEmploymentStatusFromJobMenu() {
		topMenuComponents.selectsSubMenuFromMenuDropdown(TopMenuItems.getValue("JOB"),  TopSubMenuItems.getValue("EMPLOYMENTSTATUS"));
		return this;	
	}
	
	public AdminPage toClickOnAddButtonInEmploymentStatus() {
		commonComponents.clicksOnAddButton(TopSubMenuItems.getValue("EMPLOYMENTSTATUS"));
		return this;
	}
	
	public AdminPage toEnterNameInEmploymentStatus(String value) {
		commonComponents.entersTextinTextBox("Name", value);
		return this;
	}
	
	public AdminPage toClickOnSaveButtonInEmploymentStatus() {
		commonComponents.clicksOnSaveCancelButton(TopSubMenuItems.getValue("ADDEMPLOYMENTSTATUS"), "Save");
		return this;
	}
	
	public boolean checksForAddedEmploymentStatus(String employmentStatusName) {
		return returnsPresenceOfWebElementFromList(commonComponents.tableCellsXpath, employmentStatusName);
	}
	
	public AdminPage toDeleteEmploymentStatus(String employmentStatusName) {
		deletesRowFromTable(commonComponents.tableCellsXpath,employmentStatusName, commonComponents.rowDeleteButton(employmentStatusName)
				,commonComponents.confirmDeleteButton);
		return this;
	}
	
	public AdminPage toSelectJobCategoriesFromJobMenu() {
		topMenuComponents.selectsSubMenuFromMenuDropdown(TopMenuItems.getValue("JOB"),  TopSubMenuItems.getValue("JOBCATEGORIES"));
		return this;	
	}
	
	public AdminPage toClickOnAddButtonInJobCategories() {
		commonComponents.clicksOnAddButton(TopSubMenuItems.getValue("JOBCATEGORIES"));
		return this;
	}
	
	public AdminPage toEnterNameInJobCategories(String value) {
		commonComponents.entersTextinTextBox("Name", value);
		return this;
	}
	
	public AdminPage toClickOnSaveButtonInJobCategories() {
		commonComponents.clicksOnSaveCancelButton(TopSubMenuItems.getValue("ADDJOBCATEGORY"), "Save");
		return this;
	}
	
	public boolean checksForAddedJobCategories(String jobCategoriesName) {
		return returnsPresenceOfWebElementFromList(commonComponents.tableCellsXpath, jobCategoriesName);
	}
	
	public AdminPage toDeleteJobCategories(String jobCategoriesName) {
		deletesRowFromTable(commonComponents.tableCellsXpath,jobCategoriesName, commonComponents.rowDeleteButton(jobCategoriesName)
				,commonComponents.confirmDeleteButton);
		return this;
	}
	
	public AdminPage toSelectGeneralInformationFromOrganization() {
		topMenuComponents.selectsSubMenuFromMenuDropdown(TopMenuItems.getValue("ORGANIZATION"),  TopSubMenuItems.getValue("GENERALINFORMATION"));
		return this;	
	}
	
	public AdminPage toClickOnEditCheckBoxInGeneralInformation() {
		commonComponents.clicksOnCheckbox("Edit");
		return this;
	}
	
	public AdminPage toUpdateRegistrationNumberInGeneralInformation(String value){
		commonComponents.entersTextinTextBox("Registration Number", value);
		return this;
	}
	
	public AdminPage toUpdateTaxIDInGeneralInformation(String value){
		commonComponents.entersTextinTextBox("Tax ID", value);
		return this;
	}
	
	public AdminPage toUpdatePhoneInGeneralInformation(String value){
		commonComponents.entersTextinTextBox("Phone", value);
		return this;
	}
	
	public AdminPage toUpdateFaxNumberInGeneralInformation(String value){
		commonComponents.entersTextinTextBox("Fax", value);
		return this;
	}
	
	public AdminPage toUpdateEmailInGeneralInformation(String value){
		commonComponents.entersTextinTextBox("Email", value);
		return this;
	}
	
	public AdminPage toUpdateAddressStreet1InGeneralInformation(String value){
		commonComponents.entersTextinTextBox("Address Street 1", value);
		return this;
	}
	
	public AdminPage toUpdateAddressStreet2InGeneralInformation(String value){
		commonComponents.entersTextinTextBox("Address Street 2", value);
		return this;
	}
	
	public AdminPage toUpdateCityInGeneralInformation(String value){
		commonComponents.entersTextinTextBox("City", value);
		return this;
	}
	
	public AdminPage toUpdateStateInGeneralInformation(String value){
		commonComponents.entersTextinTextBox("State/Province", value);
		return this;
	}
	
	public AdminPage toUpdateZipInGeneralInformation(String value){
		commonComponents.entersTextinTextBox("Zip/Postal Code", value);
		return this;
	}
	
	public AdminPage toUpdateCountryInGeneralInformation(String CountryName){
		selectsValueFromDropdown(commonComponents.selectDropdownXpath("Country"), commonComponents.selectDropDownValues, CountryName);
		return this;
	}
	
	public AdminPage toUpdateNotesInGeneralInformation(String value){
		commonComponents.entersTextinFreeTextBox("Notes",value );
		return this;
	}
	
	public AdminPage toClickOnSaveButtonInGeneralInformation() {
		commonComponents.clicksOnSaveButtonInForm(TopSubMenuItems.getValue("GENERALINFORMATION"));
		return this;
	}
	
	
	
	
	
	
	
	
	
	
}
