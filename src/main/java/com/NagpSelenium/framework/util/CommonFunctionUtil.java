package com.NagpSelenium.framework.util;

import org.openqa.selenium.By;

import com.NagpSelenium.framework.base.BaseClass;

/**
 * This Class contains all of the common/generic functions related to selenium
 * to interact with web page.
 * 
 * @author jitenderkumar01
 *
 */
public class CommonFunctionUtil {

	public static void switchToFrame(By frame) {
		BaseClass.driver.switchTo().frame(BaseClass.driver.findElement(frame));
	}

	public static void clickonWebElement(By webElement) {
		BaseClass.driver.findElement(webElement).click();
	}

	public static Boolean elementIsDisplayed(By webElement) {
		return BaseClass.driver.findElement(webElement).isDisplayed();
	}

	public static Boolean elementIsEnabled(By webElement) {
		return BaseClass.driver.findElement(webElement).isEnabled();
	}

	public static void setTextWebElement(By webElement, String text) {
		BaseClass.driver.findElement(webElement).sendKeys(text);
	}

	public static String getTextFromAttrubute(By webElement, String text) {
		return BaseClass.driver.findElement(webElement).getAttribute(text);
	}

	public static String getTextOnWebElement(By webElement) {
		String textOnWebElement = BaseClass.driver.findElement(webElement).getText();
		return textOnWebElement;
	}

	public static String getPageTitle() {
		String pageTitle = BaseClass.driver.getTitle();
		return pageTitle;
	}

	public static String getPageURL() {
		String pageURL = BaseClass.driver.getCurrentUrl();
		return pageURL;
	}

}
