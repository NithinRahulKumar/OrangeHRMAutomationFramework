package com.self.pages.pageComponents;

import org.openqa.selenium.By;

import com.self.enums.WaitStrategy;
import com.self.pages.BasePage;
import com.self.utils.DynamicXpathUtils;

public class TopMenuComponents extends BasePage {
	
	String menuDropdown = "//span[contains(text(),'%s')]/parent::li";
	By subMenuDropdown = By.xpath("//ul[@class='oxd-dropdown-menu']/child::li/child::a");
	
	public final By addButtonInCurrencies = By.xpath("//h6[text()='Currencies']/parent::div/child::button[normalize-space(text()='Add')]");
	
	
	public By menuDropdownXpath(String menuName) {
		String newXpath = DynamicXpathUtils.getXpath(menuDropdown, menuName);
		return By.xpath(newXpath);
	}
	
	
	public TopMenuComponents selectsSubMenuFromMenuDropdown(String menuName, String subMenuName) {
		selectsValueFromDropdown(menuDropdownXpath(menuName), subMenuDropdown, subMenuName);
		return this;
	}
	
	public TopMenuComponents toClickOnAddButtonInCurrencies()
	{
		click(addButtonInCurrencies,WaitStrategy.VISIBILITY, "Add");
		return this;
	}
	
	
	

}
