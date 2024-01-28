package com.self.pages.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.self.driver.DriverManager;
import com.self.enums.WaitStrategy;
import com.self.factories.ExplicitWaitFactory;
import com.self.pages.BasePage;
import com.self.utils.DynamicXpathUtils;

public class CommonComponents extends BasePage {
	
	private static final String addButton = "//h6[text()='%s']/parent::div/child::div/button[normalize-space(text()='Add')]";
	private static final String textBox = "//label[text()='%s']/parent::div/following-sibling::div//child::input";
	private static final String freeTextBox = "//label[text()='%s']/parent::div/following-sibling::div/child::textarea";
	private static final String clicksonElement = "//a[text()='%s']";
	private static final String savecancelButton = "//h6[text()='%s']/parent::div//button[@type='submit' and normalize-space(text()='%s')]";
	private static final String saveButtonInForm ="//h6[text()='General Information']/parent::div/following-sibling::form//button[@type='submit' and normalize-space(text()='Save')]";
	private static final String searchResetButton = "//h5[text()='Employee Information']/ancestor::div[@class='oxd-table-filter']//button[@type='submit' and normalize-space(text()='%s')]";
	private static final String tableCells = "//div[contains(@class,'oxd-table-cell')]/div";
	public final By tableCellsXpath =By.xpath(tableCells);
	private static final String rowDeleteButton = tableCells+"[text()='%s']/parent::div/parent::div//button/child::i[@class='oxd-icon bi-trash']/parent::button";
	public final By confirmDeleteButton = By.xpath("//div[contains(@class,'oxd-dialog-sheet')]//button[contains(@class,'oxd-button--label-danger')]");
	private static final String actionSuccessfullMessage = "//p[text()='Success']/following-sibling::p[text()='%s']"; //Successfully Saved/Updated/Deleted
	private static final String checkbox = "//label[text()='%s']/child::input[@type='checkbox']/parent::label/child::span";
	private static final String radioButton = "//label[text()='%s']/parent::div/following-sibling::div//div/child::label[(text()='%s')]";
	private static final String selectDropDown = "//label[text()='%s']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
	public  final By selectDropDownValues = By.xpath("//div[@role='listbox']/child::div/following-sibling::div[@role='option']/span");
	private static final String dynamicSearchInTextBox = "//label[text()='%s']/parent::div/following-sibling::div/child::div/child::div/child::input";
	public final  By dynamicSearchResults = By.xpath("//div[@role='listbox']/child::div/child::span");
	private static final By pageHeading = By.xpath("//h6[contains(@class,'oxd-text oxd-text--h6')]") ;
	
	public CommonComponents clicksOnAddButton(String subMenuName) {
		String newXpath = DynamicXpathUtils.getXpath(addButton, subMenuName);
		click(By.xpath(newXpath),WaitStrategy.VISIBILITY, "Add");
		return this;
	}
	
	public CommonComponents entersTextinTextBox(String textBoxName, String value) {
		String newXpath = DynamicXpathUtils.getXpath(textBox,textBoxName );
		sendKeys(By.xpath(newXpath),value, WaitStrategy.CLICKABLE, textBoxName);
		return this;
	}
	
	public CommonComponents entersTextinFreeTextBox(String textBoxName, String value) {
		String newXpath = DynamicXpathUtils.getXpath(freeTextBox,textBoxName );
		sendKeys(By.xpath(newXpath),value, WaitStrategy.CLICKABLE, textBoxName);
		return this;
	}
	
	public CommonComponents clicksOnElement(String elementName) {
		String newXpath = DynamicXpathUtils.getXpath(clicksonElement, elementName);
		click(By.xpath(newXpath),WaitStrategy.VISIBILITY, elementName);
		return this;
	}
	
	public CommonComponents clicksOnSaveCancelButton(String subMenuName, String value) {
		String newXpath = DynamicXpathUtils.getXpath(savecancelButton, subMenuName, value);
		WebElement element = DriverManager.getDriver().findElement(By.xpath(newXpath));
		scrollsDownToElementInSeleniumusingWebElement(DriverManager.getDriver(),element);
		click(By.xpath(newXpath),WaitStrategy.VISIBILITY, value);
		return this;
	}
	
	
	public By rowDeleteButton(String itemName) {
		String newXpath = DynamicXpathUtils.getXpath(rowDeleteButton, itemName);
		return By.xpath(newXpath);
	}
	
	
	
	public WebElement getSuccessMessageText(String message) {
		String newXpath = DynamicXpathUtils.getXpath(actionSuccessfullMessage, message);
		return ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBILITY, By.xpath(newXpath));

	}
	
	public CommonComponents clicksOnCheckbox(String checkboxLabel ) {
		String newXpath = DynamicXpathUtils.getXpath(checkbox, checkboxLabel);
		click(By.xpath(newXpath),WaitStrategy.VISIBILITY, "checkbox");
		return this;
	}
	
	public CommonComponents clicksOnSaveButtonInForm(String subMenuName) {
		String newXpath = DynamicXpathUtils.getXpath(saveButtonInForm, subMenuName);
		click(By.xpath(newXpath),WaitStrategy.VISIBILITY, "Save");
		return this;
	}
	
	public By selectDropdownXpath(String labelName) {
		String newXpath = DynamicXpathUtils.getXpath(selectDropDown, labelName);
		return By.xpath(newXpath);
	}
	
	public By dynamicSearchTextBoxXpath(String labelName) {
		String newXpath = DynamicXpathUtils.getXpath(dynamicSearchInTextBox, labelName);
		return By.xpath(newXpath);
	}
	
	public CommonComponents toSelectValueFromDynamicSearchTextBox(String fieldName, String value) {
		selectsValueFromDynamicSearchInTextBox( dynamicSearchTextBoxXpath(fieldName), dynamicSearchResults, value,  fieldName);
		return this;
	}
	
	public CommonComponents clicksOnSearchResetButton(String sectionHeading, String value) {
		String newXpath = DynamicXpathUtils.getXpath(searchResetButton, sectionHeading, value);
		click(By.xpath(newXpath),WaitStrategy.CLICKABLE, value);
		return this;
	}
	
	public CommonComponents clicksOnradioButton(String labelName, String checkBoxName, String value) {
		String newXpath = DynamicXpathUtils.getXpath(radioButton, labelName, checkBoxName);
		click(By.xpath(newXpath),WaitStrategy.CLICKABLE, value);
		return this;
	}
	
	public CommonComponents getCaptureTextFromHeading() {
		//WebElement element=DriverManager.getDriver().findElement(By.xpath("))
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
