package com.NagpSelenium.framework.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.NagpSelenium.framework.base.BaseClass;
import com.NagpSelenium.framework.util.CommonFunctionUtil;

/**
 * This page contains: All web elements of hotel web page. All of functions that
 * can be performed on hotel page.
 * 
 * @author jitenderkumar01
 *
 */
public class HotelPage extends BaseClass {

	By hotelSearchBox = By.id("search_key");
	By hotelSuggestionBox = By.className("suggestions-box");
	By selectItemFromSuggestionBox = By.xpath("//div[@class='suggestions-box']//div[@class='suggestion-row']");
	By searchButton = By.id("search_hotel");
	By hotelSuggestions = By.xpath("//div[@class='suggestion-container clearfix']/div/div/div/span");
	By lowestPrice = By.xpath("//a[@class='gtm-prc-sort']");
	By itemsInList = By.xpath("//ul[@id='hotel_items']//li");
	By firstCheckBoxOfCompare = By.xpath("//li[@class='card-block htl-view'][1]//label[1]");
	By secondCheckBoxOfCompare = By.xpath("//li[@class='card-block htl-view'][2]//label[1]");
	By compareButton = By.xpath("//div[@class='compare-btn compareActive']");
	By compareLink = By.xpath("//a[@href='/hotels/compare']");

	public void checkVisibilityAndDefaultTextInSearchBox() {
		Assert.assertTrue(CommonFunctionUtil.elementIsDisplayed(hotelSearchBox));
		Assert.assertEquals(CommonFunctionUtil.getTextFromAttrubute(hotelSearchBox, "placeholder"),
				prop.getProperty("defaultSerachTextOnHotelPage"));
	}

	public void suggestionBoxAvailability() {
		CommonFunctionUtil.clickonWebElement(hotelSearchBox);
		Assert.assertEquals(CommonFunctionUtil.getTextFromAttrubute(hotelSuggestionBox, "style"),
				prop.getProperty("hotelSuggestionBoxVisibility"));
	}

	public void enterTextInSearchBox(String cityName) {
		CommonFunctionUtil.setTextWebElement(hotelSearchBox, cityName);
		Assert.assertEquals(CommonFunctionUtil.getTextFromAttrubute(hotelSuggestionBox, "style"),
				prop.getProperty("hotelSuggestionBoxVisibility"));
	}

	public void selectValueFromSuggestionAndClickSearchButton() {
		List<WebElement> hotelCity = driver.findElements(hotelSuggestions);
		hotelCity.get(2).click();
		CommonFunctionUtil.elementIsDisplayed(searchButton);
		CommonFunctionUtil.clickonWebElement(searchButton);
	}

	public void visibilityAndClickOnFiler() {
		CommonFunctionUtil.elementIsDisplayed(lowestPrice);
		CommonFunctionUtil.clickonWebElement(lowestPrice);
	}

	public void verifyPriceSorted() {
		List<WebElement> itemList = driver.findElements(itemsInList);
		ArrayList<String> list = new ArrayList<String>();

		for (int i = 1; i <= itemList.size(); i++) {
			String sortAmount = driver
					.findElement(By.xpath("//li[@class='card-block htl-view'][" + i + "]//span[@class='mnp-price']"))
					.getText();
			list.add(sortAmount);
		}
		for (int i = 0; i < list.size(); i++) {
			if (i < list.size() - 1) {
				Assert.assertTrue(Integer.parseInt(list.get(i)) <= Integer.parseInt(list.get(i + 1)));
			}
		}
	}

	public String clickAddToCompareCheckbox() {
		CommonFunctionUtil.elementIsDisplayed(firstCheckBoxOfCompare);
		CommonFunctionUtil.clickonWebElement(firstCheckBoxOfCompare);
		CommonFunctionUtil.clickonWebElement(secondCheckBoxOfCompare);
		return CommonFunctionUtil.getTextOnWebElement(compareButton);
	}

	public void clickCompareButton() {
		CommonFunctionUtil.elementIsDisplayed(compareButton);
		CommonFunctionUtil.elementIsEnabled(compareButton);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctionUtil.clickonWebElement(compareButton);
		CommonFunctionUtil.elementIsDisplayed(compareLink);

	}
}
