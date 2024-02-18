package com.self.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.self.driver.DriverManager;
import com.self.enums.WaitStrategy;
import com.self.factories.ExplicitWaitFactory;
import com.self.reports.ExtentLogger;

public class BasePage {

	protected void click(By by, WaitStrategy waitStrategy, String fieldName) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		element.click();
		ExtentLogger.pass("Clicked on " + fieldName + " successfully", true);

	}

	protected void sendKeys(By by, String inputText, WaitStrategy waitStrategy, String fieldName) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		scrollsDownToElementInSeleniumusingWebElement(DriverManager.getDriver(),element);
		element.sendKeys(Keys.CONTROL+"A");
		element.sendKeys(Keys.DELETE);
		element.sendKeys(inputText);
		ExtentLogger.pass("Entered text in " + fieldName + " text box successfully", true);
	}

	protected String pageTitle() {
		String title = DriverManager.getDriver().getTitle();
		ExtentLogger.pass("Captured page title successfully", true);
		return title;

	}

	protected List<WebElement> waitsForMultipleWebElementsDisplay(By by, WaitStrategy waitStrategy, String fieldName) {
		return ExplicitWaitFactory.performExplicitWaitOnListOfElements(waitStrategy, by);
	}

	protected List<WebElement> getListOfWebElements(By by) {
		return DriverManager.getDriver().findElements(by);
	}

	protected void selectsValueFromDropdown(By dropdown, By dropdownValues, String value) {
		click(dropdown, WaitStrategy.VISIBILITY, "select dropdown");
		List<WebElement> elements = waitsForMultipleWebElementsDisplay(dropdownValues, WaitStrategy.VISIBILITY, "select dropdown values");
		for (WebElement element : elements) {
			if (element.getText().equalsIgnoreCase(value)) {
				element.click();
				ExtentLogger.pass("Selected value from dropdown "
						+ "Successfully", true);
				break;
			}
		}
	}

	protected boolean returnsPresenceOfWebElementFromList(By by, String elementText) {
		List<WebElement> elements = getListOfWebElements(by);
		for (WebElement element : elements) {
			if (element.getText().equalsIgnoreCase(elementText)) {
				ExtentLogger.pass("Element " + elementText + " present in list", true);
				return true;
			}
		}
		return false;
	}

	protected void scrollsDownToWebElementusingCordinates(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(x,y)", "");
	}

	protected void scrollsDownToElementInSeleniumusingWebElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	protected void scrollsDownToBottomOfPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	protected void selectsValueFromDynamicSearchInTextBox( By dynamicSearchInTextBox, By searchResults, String value, String fieldName) {
		sendKeys(dynamicSearchInTextBox, value, WaitStrategy.CLICKABLE, fieldName );
		List<WebElement> dynamicSearchResults = waitsForMultipleWebElementsDisplay(searchResults, WaitStrategy.VISIBILITY, "selects value");
		for(WebElement dynamicSearchResult: dynamicSearchResults) {
			if(dynamicSearchResult.getText().equalsIgnoreCase(value)) {
				dynamicSearchResult.click();
				ExtentLogger.pass("Selected "+dynamicSearchResult.getText()+ " Sucessfully", true);
				break;
			}
		}
	}
	protected void  deletesRowFromTable(By tableColumns,String textInColumn, By deleteButton, By confirmDeleteButton ) {
		List<WebElement> allCells = getListOfWebElements(tableColumns);

		for (int i = 0; i < allCells.size(); i++) {
			if (allCells.get(i).getText().equalsIgnoreCase(textInColumn)) {
				ExtentLogger.pass("Expected element text " + allCells.get(i).getText() + " Matched with "
						+ " actual element text " + textInColumn, true);
				scrollsDownToElementInSeleniumusingWebElement(DriverManager.getDriver(),allCells.get(i));
				allCells.get(i-1).click();
				allCells.get(i).findElement(deleteButton).click();
				ExtentLogger.pass("Clicked on JobTitle Delete button", true);
				click(confirmDeleteButton, WaitStrategy.VISIBILITY, "confirm delete");
				break;
			}
		}

	}
	
	protected void  deletesEmployeeFromEmployeeList(By employeeTableColumns,String employeefirstmiddleName, By deleteButton, By confirmDeleteButton ) {
		List<WebElement> allCells = getListOfWebElements(employeeTableColumns);

		for (int i = 0; i < allCells.size(); i++) {
			if (allCells.get(i).getText().equalsIgnoreCase(employeefirstmiddleName)) {
				ExtentLogger.pass("Expected element text " + allCells.get(i).getText() + " Matched with "
						+ " actual element text " + employeefirstmiddleName, true);
				scrollsDownToElementInSeleniumusingWebElement(DriverManager.getDriver(),allCells.get(i));
				allCells.get(i-2).click();
				allCells.get(i).findElement(deleteButton).click();
				ExtentLogger.pass("Clicked on JobTitle Delete button", true);
				click(confirmDeleteButton, WaitStrategy.VISIBILITY, "confirm delete");
				break;
			}
		}

	}
	
	
}
