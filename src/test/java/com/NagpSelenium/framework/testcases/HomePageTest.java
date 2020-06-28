package com.NagpSelenium.framework.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.NagpSelenium.framework.base.BaseClass;
import com.NagpSelenium.framework.util.CommonFunctionUtil;

/**
 * Contains test related to home page test
 * 
 * @author jitenderkumar01
 *
 */
public class HomePageTest extends BaseClass {

	@Test(priority = 0)
	public void verifyHomePageTitle() {
		Assert.assertEquals(CommonFunctionUtil.getPageTitle(), prop.getProperty("homePageTitle"));
		Assert.assertEquals(CommonFunctionUtil.getPageURL(), prop.getProperty("homePageUrl"));
	}



}
