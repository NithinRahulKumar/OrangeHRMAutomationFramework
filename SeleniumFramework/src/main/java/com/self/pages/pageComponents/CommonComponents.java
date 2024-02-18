package com.self.pages.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.self.driver.DriverManager;
import com.self.enums.WaitStrategy;
import com.self.factories.ExplicitWaitFactory;
import com.self.pages.BasePage;
import com.self.utils.DynamicXpathUtils;

public class CommonComponents extends BasePage {
	
	private static final String ADD_BUTTON = "//h6[text()='%s']/parent::div/child::div/button[normalize-space(text()='Add')]";
	private static final String TEXT_BOX = "//label[text()='%s']/parent::div/following-sibling::div//child::input";
	private static final String FREE_TEXT_BOX = "//label[text()='%s']/parent::div/following-sibling::div/child::textarea";
	private static final String CLICKS_ON_ELEMENT = "//a[text()='%s']";
	private static final String SAVE_CANCEL_BUTTON = "//h6[text()='%s']/parent::div//button[@type='submit' and normalize-space(text()='%s')]";
	private static final String SAVE_BUTTON_IN_FORM ="//h6[text()='General Information']/parent::div/following-sibling::form//button[@type='submit' and normalize-space(text()='Save')]";
	private static final String SEARCH_RESET_BUTTON = "//h5[text()='Employee Information']/ancestor::div[@class='oxd-table-filter']//button[@type='submit' and normalize-space(text()='%s')]";
	private static final String TABLE_CELLS = "//div[contains(@class,'oxd-table-cell')]/div";
	public final By tableCellsXpath =By.xpath(TABLE_CELLS);
	private static final String ROW_DELETE_BUTTON = TABLE_CELLS+"[text()='%s']/parent::div/parent::div//button/child::i[@class='oxd-icon bi-trash']/parent::button";
	public final By confirmDeleteButton = By.xpath("//div[contains(@class,'oxd-dialog-sheet')]//button[contains(@class,'oxd-button--label-danger')]");
	private static final String ACTION_SUCCESSFUL_MESSAGE = "//p[text()='Success']/following-sibling::p[text()='%s']"; //Successfully Saved/Updated/Deleted
	private static final String CHECKBOX = "//label[text()='%s']/child::input[@type='checkbox']/parent::label/child::span";
	private static final String RADIO_BUTTON = "//label[text()='%s']/parent::div/following-sibling::div//div/child::label[(text()='%s')]";
	private static final String SELECT_DROPDOWN = "//label[text()='%s']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
	public final By selectDropDownValues = By.xpath("//div[@role='listbox']/child::div/following-sibling::div[@role='option']/span");
	private static final String DYNAMIC_SEARCH_IN_TEXTBOX = "//label[text()='%s']/parent::div/following-sibling::div/child::div/child::div/child::input";
	public final  By dynamicSearchResults = By.xpath("//div[@role='listbox']/child::div/child::span");
	private static final By MAIN_TITLE = By.xpath("//div[contains(@class,'orangehrm-horizontal-padding')]/child::h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']");
	
	public void clicksOnAddButton(String subMenuName) {
		String newXpath = DynamicXpathUtils.getXpath(ADD_BUTTON, subMenuName);
		click(By.xpath(newXpath),WaitStrategy.VISIBILITY, "Add");
	}
	
	public void entersTextinTextBox(String textBoxName, String value) {
		String newXpath = DynamicXpathUtils.getXpath(TEXT_BOX,textBoxName );
		sendKeys(By.xpath(newXpath),value, WaitStrategy.CLICKABLE, textBoxName);
	}
	
	public void entersTextinFreeTextBox(String textBoxName, String value) {
		String newXpath = DynamicXpathUtils.getXpath(FREE_TEXT_BOX,textBoxName );
		sendKeys(By.xpath(newXpath),value, WaitStrategy.CLICKABLE, textBoxName);
	}
	
	public void clicksOnElement(String elementName) {
		String newXpath = DynamicXpathUtils.getXpath(CLICKS_ON_ELEMENT, elementName);
		click(By.xpath(newXpath),WaitStrategy.VISIBILITY, elementName);
	}
	
	public void clicksOnSaveCancelButton(String subMenuName, String value) {
		String newXpath = DynamicXpathUtils.getXpath(SAVE_CANCEL_BUTTON, subMenuName, value);
		WebElement element = DriverManager.getDriver().findElement(By.xpath(newXpath));
		scrollsDownToElementInSeleniumusingWebElement(DriverManager.getDriver(),element);
		click(By.xpath(newXpath),WaitStrategy.VISIBILITY, value);
	}
	
	
	public By rowDeleteButton(String itemName) {
		String newXpath = DynamicXpathUtils.getXpath(ROW_DELETE_BUTTON, itemName);
		return By.xpath(newXpath);
	}
	
	
	
	public WebElement getSuccessMessageText(String message) {
		String newXpath = DynamicXpathUtils.getXpath(ACTION_SUCCESSFUL_MESSAGE, message);
		return ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBILITY, By.xpath(newXpath));

	}
	
	public void clicksOnCheckbox(String checkboxLabel ) {
		String newXpath = DynamicXpathUtils.getXpath(CHECKBOX, checkboxLabel);
		click(By.xpath(newXpath),WaitStrategy.VISIBILITY, "checkbox");
	}
	
	public void clicksOnSaveButtonInForm(String subMenuName) {
		String newXpath = DynamicXpathUtils.getXpath(SAVE_BUTTON_IN_FORM, subMenuName);
		click(By.xpath(newXpath),WaitStrategy.VISIBILITY, "Save");
	}
	
	public By selectDropdownXpath(String labelName) {
		String newXpath = DynamicXpathUtils.getXpath(SELECT_DROPDOWN, labelName);
		return By.xpath(newXpath);
	}
	
	public By dynamicSearchTextBoxXpath(String labelName) {
		String newXpath = DynamicXpathUtils.getXpath(DYNAMIC_SEARCH_IN_TEXTBOX, labelName);
		return By.xpath(newXpath);
	}
	
	public void toSelectValueFromDynamicSearchTextBox(String fieldName, String value) {
		selectsValueFromDynamicSearchInTextBox( dynamicSearchTextBoxXpath(fieldName), dynamicSearchResults, value,  fieldName);
	}
	
	public void clicksOnSearchResetButton(String sectionHeading, String value) {
		String newXpath = DynamicXpathUtils.getXpath(SEARCH_RESET_BUTTON, sectionHeading, value);
		click(By.xpath(newXpath),WaitStrategy.CLICKABLE, value);
	}
	
	public void clicksOnradioButton(String labelName, String checkBoxName, String value) {
		String newXpath = DynamicXpathUtils.getXpath(RADIO_BUTTON, labelName, checkBoxName);
		click(By.xpath(newXpath),WaitStrategy.CLICKABLE, value);
	}
	
	public String getTextOfMainTitle() {
		WebElement element=DriverManager.getDriver().findElement(MAIN_TITLE);
		return element.getText();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
