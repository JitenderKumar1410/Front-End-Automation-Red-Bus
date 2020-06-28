package com.NagpSelenium.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.NagpSelenium.framework.base.BaseClass;
import com.NagpSelenium.framework.util.CommonFunctionUtil;

/**
 * This page contains: All web elements of bus tickets web page. All of
 * functions that can be performed on bus tickets page.
 * 
 * @author jitenderkumar01
 *
 */
public class BusTicketsPage extends BaseClass {
	By returnTicket = By.xpath("//div[@class='addreturn-btn fr']");
	By calender = By.xpath("//div[@id='rb-calmiddle']//ul[2]//li");
	By returnJourney = By.xpath("//span[contains(text(),'RETURN JOURNEY')]");
	By modifyButton = By.xpath("//div[@class='onward-modify-btn g-button clearfix fl']");
	By searchButton = By.xpath("//button[contains(text(),'SEARCH')]");

	public void verifySearchBusPage() {
		CommonFunctionUtil.elementIsDisplayed(returnTicket);
	}

	public Boolean checkReturnTicketButton() {
		return CommonFunctionUtil.elementIsDisplayed(returnTicket);
	}

	public void checkReturnTicketFunctionality() {
		CommonFunctionUtil.clickonWebElement(returnTicket);
		List<WebElement> returnDate = driver.findElements(calender);
		returnDate.get(20).click();
		Assert.assertEquals(CommonFunctionUtil.getTextOnWebElement(returnJourney), prop.getProperty("returnJourney"));
		CommonFunctionUtil.clickonWebElement(modifyButton);
		CommonFunctionUtil.elementIsDisplayed(searchButton);
		CommonFunctionUtil.clickonWebElement(searchButton);
	}

}
