package com.NagpSelenium.framework.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.NagpSelenium.framework.base.BaseClass;
import com.NagpSelenium.framework.util.CommonFunctionUtil;

/**
 * This page contains: All web elements of bus hire web page. All of functions
 * that can be performed on bus hire page.
 * 
 * @author jitenderkumar01
 *
 */
public class BusHirePage extends BaseClass {

	By cityOfHire = By.xpath("//input[@placeholder='eg: Mumbai']");
	By startingPointHire = By.xpath("//input[@placeholder='eg: Railway Station']");
	By destinationPointHire = By.xpath("//input[@placeholder='eg: Airport/Pune']");
	By citySuggestion = By.xpath("//div[@id='src_city_block']//ul[@class='autocomplete_ul']");
	By startingPointSuggestion = By.xpath("//div[@id='pick_up_block']//ul[@class='autocomplete_ul']");
	By destinationPointSuggestion = By.xpath("//div[@id='dest_city_block']//ul[@class='autocomplete_ul']");
	By cityList = By.xpath("//div[@id='src_city_block']//ul[@class='autocomplete_ul']//li");
	By startingPointList = By.xpath("//div[@id='pick_up_block']/div/div/ul/li");
	By destinationPointList = By.xpath("//div[@id='dest_city_block']/div/div/ul/li");
	By hireButton = By.id("hire_btn");
	By busHirePage = By.className("Hire-a-vehicle");

	public void testSearchBoxForBusHire(String city, String startingPoint, String destinationPoint) {
		CommonFunctionUtil.elementIsDisplayed(cityOfHire);

		CommonFunctionUtil.setTextWebElement(cityOfHire, city);
		Assert.assertTrue(checkVisibilityOfAutoSuggestion(citySuggestion));
		List<WebElement> citySuggestion = driver.findElements(cityList);
		citySuggestion.get(0).click();
		driver.findElement(cityOfHire).sendKeys(Keys.TAB);

		CommonFunctionUtil.setTextWebElement(startingPointHire, startingPoint);
		Assert.assertTrue(checkVisibilityOfAutoSuggestion(startingPointSuggestion));
		CommonFunctionUtil.setTextWebElement(startingPointHire, startingPoint);
		List<WebElement> startingSuggestion = driver.findElements(startingPointList);
		startingSuggestion.get(1).click();
		driver.findElement(startingPointHire).sendKeys(Keys.TAB);

		CommonFunctionUtil.setTextWebElement(destinationPointHire, destinationPoint);
		CommonFunctionUtil.setTextWebElement(destinationPointHire, city);
		Assert.assertTrue(checkVisibilityOfAutoSuggestion(destinationPointSuggestion));
		CommonFunctionUtil.setTextWebElement(destinationPointHire, destinationPoint);
		List<WebElement> destinationSuggestion = driver.findElements(destinationPointList);
		destinationSuggestion.get(2).click();
		driver.findElement(destinationPointHire).sendKeys(Keys.TAB);

	}

	public void clickOnHireButton() {
		CommonFunctionUtil.clickonWebElement(hireButton);
	}

	public String getHeaderOfBusHirePage() {
		return CommonFunctionUtil.getTextOnWebElement(busHirePage);
	}

	public static Boolean checkVisibilityOfAutoSuggestion(By webElement) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver.findElement(webElement).getAttribute("style").contains("display: block");
	}
}
