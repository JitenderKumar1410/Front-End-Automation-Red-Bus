package com.NagpSelenium.framework.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NagpSelenium.framework.base.BaseClass;
import com.NagpSelenium.framework.util.CommonFunctionUtil;

/**
 * Contains test related to contact us and about us
 * 
 * @author jitenderkumar01
 *
 */
public class AboutWebsiteTest extends BaseClass {

	@Test(priority = 0)
	public void verifyAboutUsLink() {
		homePage.clickOnAboutUs();
		aboutWebsitePage.switchwindow();
		Assert.assertTrue(aboutWebsitePage.CheckNewWindowOfAboutUs());
		Assert.assertEquals(CommonFunctionUtil.getPageTitle(), prop.getProperty("aboutUsTitle"));
		Assert.assertEquals(CommonFunctionUtil.getPageURL(), prop.getProperty("aboutUsUrl"));
		driver.close();
		aboutWebsitePage.controlBackToMainWindow();
	}

	@Test(priority = 1)
	public void verifyContactUsLink() {
		homePage.clickOnContactUs();
		aboutWebsitePage.switchwindow();
		Assert.assertTrue(aboutWebsitePage.CheckNewWindowOfContactUs());
		Assert.assertEquals(CommonFunctionUtil.getPageTitle(), prop.getProperty("contactUsTitle"));
		Assert.assertEquals(CommonFunctionUtil.getPageURL(), prop.getProperty("contactUsUrl"));
		driver.close();
		aboutWebsitePage.controlBackToMainWindow();
	}
}
