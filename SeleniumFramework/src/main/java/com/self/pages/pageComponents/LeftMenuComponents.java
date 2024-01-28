package com.self.pages.pageComponents;

import org.openqa.selenium.By;

import com.self.enums.WaitStrategy;
import com.self.pages.BasePage;
import com.self.utils.DynamicXpathUtils;

public final class LeftMenuComponents extends BasePage {
	
	String leftMenu = "//span[text()='%s']/parent::a";
	
	public LeftMenuComponents clicksOnLeftMenu(String leftMenuName) {
		String newXpath = DynamicXpathUtils.getXpath(leftMenu, leftMenuName);
		click(By.xpath(newXpath), WaitStrategy.VISIBILITY,leftMenuName );
		return this;
	}
}
