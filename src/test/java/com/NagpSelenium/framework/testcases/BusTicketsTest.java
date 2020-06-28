package com.NagpSelenium.framework.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NagpSelenium.framework.base.BaseClass;
import com.NagpSelenium.framework.util.CommonFunctionUtil;

/**
 * Contains test related to bus tickets booking functionality
 * 
 * @author jitenderkumar01
 *
 */
public class BusTicketsTest extends BaseClass {

	@Test(priority = 1)
	public void testSearchFunctionalityForBus() {
		homePage.testSearchBoxForBusBooking(prop.getProperty("fromLocation"), prop.getProperty("toLocation"));
		busTicketsPage.verifySearchBusPage();
		Assert.assertEquals(CommonFunctionUtil.getPageTitle(), prop.getProperty("busTicketsPageTitle"));
	}

	@Test(priority = 2)
	public void testFunctionalityOfReturnTicket() {
		Assert.assertTrue(busTicketsPage.checkReturnTicketButton());
		busTicketsPage.checkReturnTicketFunctionality();
	}
}