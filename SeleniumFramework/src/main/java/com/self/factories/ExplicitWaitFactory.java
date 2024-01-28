package com.self.factories;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.self.constants.FrameworkConstants;
import com.self.driver.DriverManager;
import com.self.enums.WaitStrategy;

public final class ExplicitWaitFactory {
	private ExplicitWaitFactory() {
	};

	public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by) {
		WebElement element = null;
		if (waitStrategy == WaitStrategy.VISIBILITY) {
			element = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofSeconds(FrameworkConstants.getExplicitWaitTime()))
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		} else if (waitStrategy == WaitStrategy.PRESENCE) {
			element = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofSeconds(FrameworkConstants.getExplicitWaitTime()))
					.until(ExpectedConditions.presenceOfElementLocated(by));
		} else if (waitStrategy == WaitStrategy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofSeconds(FrameworkConstants.getExplicitWaitTime()))
					.until(ExpectedConditions.elementToBeClickable(by));
		} else if (waitStrategy == WaitStrategy.NONE) {
			element = DriverManager.getDriver().findElement(by);
		}
		return element;
	}

	public static List<WebElement> performExplicitWaitOnListOfElements(WaitStrategy waitStrategy, By by) {
		List<WebElement> elements = null;
		if (waitStrategy == WaitStrategy.VISIBILITY) {
			elements = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofSeconds(FrameworkConstants.getExplicitWaitTime()))
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
		} else if (waitStrategy == WaitStrategy.PRESENCE) {
			elements = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofSeconds(FrameworkConstants.getExplicitWaitTime()))
					.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		} else if (waitStrategy == WaitStrategy.NONE) {
			elements = DriverManager.getDriver().findElements(by);
		}
		return elements;
	}

}
