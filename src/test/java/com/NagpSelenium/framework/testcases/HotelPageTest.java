package com.NagpSelenium.framework.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.NagpSelenium.framework.base.BaseClass;
import com.NagpSelenium.framework.util.CommonFunctionUtil;

/**
 * Contains test related to hotel page
 * 
 * @author jitenderkumar01
 *
 */
public class HotelPageTest extends BaseClass {

	@Test(priority = 0)
	public void verifyHotelPageTitle() {
		homePage.clickOnHotels();
		Assert.assertEquals(CommonFunctionUtil.getPageTitle(), prop.getProperty("hotelPageTitle"));
		Assert.assertEquals(CommonFunctionUtil.getPageURL(), prop.getProperty("hotelPageUrl"));
	}

	@Test(priority = 1)
	public void testSearchFunctionalityForHotels() {
		hotelPage.checkVisibilityAndDefaultTextInSearchBox();
		hotelPage.suggestionBoxAvailability();
		hotelPage.enterTextInSearchBox(prop.getProperty("putTextInSeacrchBox"));
		hotelPage.selectValueFromSuggestionAndClickSearchButton();
		Assert.assertEquals(CommonFunctionUtil.getPageTitle(), prop.getProperty("searchedHotelPageTitle"));
		Assert.assertTrue(CommonFunctionUtil.getPageURL().contains(prop.getProperty("hotelPageUrl")));
	}

	@Test(priority = 2)
	public void checkFunctionalityOfLowestPriceFilter() {
		hotelPage.visibilityAndClickOnFiler();
		hotelPage.verifyPriceSorted();
	}

	@Test(priority = 3)
	public void checkCompareFunctionality() {
		Assert.assertEquals(hotelPage.clickAddToCompareCheckbox(), prop.getProperty("valueInCompare"));
		hotelPage.clickCompareButton();
		Assert.assertEquals(CommonFunctionUtil.getPageTitle(), prop.getProperty("compareHotelPageTitle"));
		Assert.assertTrue(CommonFunctionUtil.getPageURL().contains(prop.getProperty("compareHotelPageUrl")));
	}
}
