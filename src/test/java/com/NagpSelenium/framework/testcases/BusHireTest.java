package com.NagpSelenium.framework.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NagpSelenium.framework.base.BaseClass;
import com.NagpSelenium.framework.util.CommonFunctionUtil;

/**
 * Contains test related to bus hire functionality
 * 
 * @author jitenderkumar01
 *
 */
public class BusHireTest extends BaseClass {

	@Test(priority = 0)
	public void verifyBusHirePageTitle() {
		homePage.clickOnBusHire();
		Assert.assertEquals(CommonFunctionUtil.getPageTitle(), prop.getProperty("busHirePageTitle"));
	}

	@Test(priority = 1)
	public void testSearchFunctionalityForBusHire() {
		busHirePage.testSearchBoxForBusHire(prop.getProperty("cityOfHire"), prop.getProperty("startingPoint"),
				prop.getProperty("destinationPoint"));
		busHirePage.clickOnHireButton();
		Assert.assertEquals(busHirePage.getHeaderOfBusHirePage(), prop.getProperty("busHirePageHeader"));
	}

}
