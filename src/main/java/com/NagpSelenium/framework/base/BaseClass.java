package com.NagpSelenium.framework.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.NagpSelenium.framework.pages.AboutWebsiteTestPage;
import com.NagpSelenium.framework.pages.BusHirePage;
import com.NagpSelenium.framework.pages.BusTicketsPage;
import com.NagpSelenium.framework.pages.HomePage;
import com.NagpSelenium.framework.pages.HotelPage;
import com.NagpSelenium.framework.util.UtilFunctions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * BaseClass contains: Initialization part like web driver and properties file
 * initialization. Contains all functions need to perform before and after
 * execution. Contains logic of extent report
 * 
 * @author jitenderkumar01
 *
 */
public class BaseClass {
	public static WebDriver driver;
	protected static Properties prop;
	protected static HomePage homePage;
	protected static HotelPage hotelPage;
	protected static BusHirePage busHirePage;
	protected static BusTicketsPage busTicketsPage;
	protected static AboutWebsiteTestPage aboutWebsitePage;
	protected static ExtentReports extent;
	protected static ExtentTest logger;

	public BaseClass() {
		try {
			prop = new Properties();

			FileInputStream fis = new FileInputStream(
					".\\src\\main\\java\\com\\NagpSelenium\\framework\\config\\config.properties");
			FileInputStream testDataFis = new FileInputStream(
					".\\src\\main\\java\\com\\NagpSelenium\\framework\\config\\testData.properties");
			prop.load(fis);
			prop.load(testDataFis);
		} catch (IOException e) {
			e.getMessage();
		}
	}

	protected static void initialization() {
		String browserName = prop.getProperty("browserName");

		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions chromeoptions = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			chromeoptions.setExperimentalOption("prefs", prefs);
			chromeoptions.addArguments("disable-popup-blocking");
			chromeoptions.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", ".//ImportantFiles//chromedriver.exe");
			driver = new ChromeDriver(chromeoptions);
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".//ImportantFiles//geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", ".//ImportantFiles//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("IMPLICIT_WAIT")),
				TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

	@BeforeClass
	protected void setUp() {
		initialization();
		homePage = new HomePage();
	}

	@AfterClass
	public void tearDown() {

		driver.quit();
	}

	@BeforeSuite
	protected void startReport() {

		if (UtilFunctions.checkFolderExistsAtGivenLocation(System.getProperty("user.dir") + "/test-output/Extent")) {
			UtilFunctions.moveFileFromSrcToDest(System.getProperty("user.dir") + "/test-output/Extent",
					System.getProperty("user.dir") + "/test-output/ArchieveExtent");
			UtilFunctions.deleteFolderFromLocation(System.getProperty("user.dir") + "/test-output/Extent");
		}
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/Extent/ExtentReport"
				+ UtilFunctions.getDateAndTime() + ".html", true);
		extent.addSystemInfo("Host Name", "Nagarro").addSystemInfo("Environment", "Automation Testing")
				.addSystemInfo("User Name", "Jitender Kumar");
		extent.loadConfig(new File(prop.getProperty("reportConfigPath")));
	}

	@BeforeMethod
	protected void beforeMethod(Method method) {

		logger = extent.startTest((this.getClass().getSimpleName() + " :: " + method.getName()),
				method.toGenericString());
		logger.log(LogStatus.INFO, "Test execution has been started");

	}

	@AfterMethod
	protected void getResult(ITestResult result) throws IOException {
		logger.log(LogStatus.PASS, "Test execution has been completed");
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, result.getName() + ": Test case has been failed");
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
			String screenshotPath = UtilFunctions.getScreenShot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
			logger.log(LogStatus.FAIL, result.getInstanceName());

		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, result.getName() + ": Test case has been skiped");
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, result.getName() + ": Test case has been passed");
		}
		extent.endTest(logger);

	}

	@AfterSuite
	protected void afterSuite() {
		extent.flush();
		extent.close();
	}
}
