package com.NagpSelenium.framework.pages;

import org.openqa.selenium.By;
import com.NagpSelenium.framework.base.BaseClass;
import com.NagpSelenium.framework.util.CommonFunctionUtil;

/**
 * This page contains: All of the web elements of About web page. All of the
 * actions/methods to run on about web page.
 * 
 * @author jitenderkumar01
 *
 */
public class AboutWebsiteTestPage extends BaseClass {
	String winHandleBefore;

	 By headingOfAboutPage = By.xpath("//div[@id='mBWrapper']//h3[1]");
	 By headingOfContactPage = By.xpath("//div[@class='imageContactText']//h1");

	public void switchwindow() {
		winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	public Boolean CheckNewWindowOfAboutUs() {
		return CommonFunctionUtil.elementIsDisplayed(headingOfAboutPage);
	}

	public Boolean CheckNewWindowOfContactUs() {
		return CommonFunctionUtil.elementIsDisplayed(headingOfContactPage);
	}

	public void controlBackToMainWindow() {
		driver.switchTo().window(winHandleBefore);
	}
}
