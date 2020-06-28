package com.NagpSelenium.framework.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.NagpSelenium.framework.base.BaseClass;
import com.NagpSelenium.framework.util.CommonFunctionUtil;

/**
 * This page contains: All web elements of home web page. All of functions that
 * can be performed on home page.
 * 
 * @author jitenderkumar01
 *
 */
public class HomePage extends BaseClass {

	 By signInmenu = By.id("sign-in-icon-down");
	 By signInLink = By.id("signInLink");
	 By frame = By.xpath("//iframe[@class='modalIframe']");
	 By signInEmailLink = By
			.xpath("//div[@id='signInView']//div[@class='social FC DIB active ']/div[@class='signin-screen']");
	 By usernameTextBox = By.id("email-mobile");
	 By passwordTextBox = By.id("password");
	 By doSignIn = By.id("doSignin");
	 By hotelLink = By.xpath("//a[@title='redBus Hotels']");
	 By busHireLink = By.xpath("//a[@title='redBus Bus Hire']");
	 By busTicketsLink = By.xpath("//a[@title='redBus']");
	 By pilgrimagesLink = By.xpath("//a[@class='site-links']");
	 By error = By.xpath("//div/div[contains(text(), 'Either the Email id')]");
	 By headerLinks = By.xpath("//nav[@class='product-nav fl']//ul//li");
	 By fromPlace = By.id("src");
	 By fromPlaceList = By.xpath("//div[@class='fl search-box clearfix']/div/ul/li");
	 By toPlace = By.id("dest");
	 By toPlaceList = By.xpath("//div[@class='fl search-box']/div/ul/li");
	 By calenderList = By.xpath("//div[@id='rb-calendar_onward_cal']/table/tbody/tr/td");
	 By calender = By.xpath("//div//label[@for='onward_cal']");
	 By searchButton = By.id("search_btn");
	 By aboutUsLink = By.linkText("About Us");
	 By contactUsLink = By.linkText("Contact Us");

	ArrayList<String> list;

	public void navigateLoginPage() {
		CommonFunctionUtil.clickonWebElement(signInmenu);
		CommonFunctionUtil.clickonWebElement(signInLink);
		CommonFunctionUtil.elementIsDisplayed(frame);
	}

	public void signInCheck(String emailID, String password) {
		CommonFunctionUtil.switchToFrame(frame);
		CommonFunctionUtil.elementIsDisplayed(signInEmailLink);
		CommonFunctionUtil.clickonWebElement(signInEmailLink);
		CommonFunctionUtil.elementIsDisplayed(usernameTextBox);
		CommonFunctionUtil.clickonWebElement(usernameTextBox);
		CommonFunctionUtil.setTextWebElement(usernameTextBox, emailID);
		CommonFunctionUtil.clickonWebElement(passwordTextBox);
		CommonFunctionUtil.setTextWebElement(passwordTextBox, password);
		CommonFunctionUtil.clickonWebElement(doSignIn);
	}

	public String assertErrorMessage() {
		CommonFunctionUtil.elementIsDisplayed(error);
		return CommonFunctionUtil.getTextOnWebElement(error);

	}

	public List<String> returnActualListOfMainHeader() {
		CommonFunctionUtil.elementIsDisplayed(headerLinks);
		List<WebElement> itemList = driver.findElements(headerLinks);
		list = new ArrayList<String>();
		for (int i = 1; i <= itemList.size(); i++) {
			String text = driver.findElement(By.xpath("//nav[@class='product-nav fl']//ul//li[" + i + "]//a"))
					.getText();
			list.add(text);
		}
		return list;
	}

	public Boolean verifyMainHeader() {
		String arr[] = { "BUS TICKETS", "rPool New", "HOTELS", "BUS HIRE", "PILGRIMAGES" };
		String[] arr1 = new String[list.size()];
		arr1 = list.toArray(arr1);
		for (int i = 0; i < arr.length; i++) {
			Assert.assertTrue(arr[i].equals(arr1[i]));
		}
		return true;
	}

	public BusTicketsPage testSearchBoxForBusBooking(String from, String to) {
		CommonFunctionUtil.elementIsDisplayed(fromPlace);
		CommonFunctionUtil.setTextWebElement(fromPlace, from);
		List<WebElement> fromSuggestion = driver.findElements(fromPlaceList);
		fromSuggestion.get(3).click();
		CommonFunctionUtil.setTextWebElement(toPlace, to);
		List<WebElement> toSuggestion = driver.findElements(toPlaceList);
		toSuggestion.get(2).click();
		CommonFunctionUtil.setTextWebElement(toPlace, "Keys.TAB");
		CommonFunctionUtil.clickonWebElement(calender);
		List<WebElement> FrmDate = driver.findElements(calenderList);
		FrmDate.get(15).click();
		CommonFunctionUtil.elementIsEnabled(searchButton);
		CommonFunctionUtil.clickonWebElement(searchButton);
		busTicketsPage = new BusTicketsPage();
		return busTicketsPage;
	}

	public HotelPage clickOnHotels() {
		CommonFunctionUtil.elementIsDisplayed(hotelLink);
		CommonFunctionUtil.clickonWebElement(hotelLink);
		hotelPage = new HotelPage();
		return hotelPage;
	}

	public BusHirePage clickOnBusHire() {
		CommonFunctionUtil.elementIsDisplayed(busHireLink);
		CommonFunctionUtil.clickonWebElement(busHireLink);
		busHirePage = new BusHirePage();
		return busHirePage;
	}

	public AboutWebsiteTestPage clickOnAboutUs() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000)");
		CommonFunctionUtil.elementIsEnabled(aboutUsLink);
		CommonFunctionUtil.clickonWebElement(aboutUsLink);
		aboutWebsitePage = new AboutWebsiteTestPage();
		return aboutWebsitePage;
	}

	public AboutWebsiteTestPage clickOnContactUs() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000)");
		CommonFunctionUtil.elementIsEnabled(contactUsLink);
		CommonFunctionUtil.clickonWebElement(contactUsLink);
		aboutWebsitePage = new AboutWebsiteTestPage();
		return aboutWebsitePage;
	}

}
