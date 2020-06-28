package com.NagpSelenium.framework.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * This Class contains all of the common/generic functions to create a framework
 * like take screenshot, delete or create new folder and all.
 * 
 * @author jitenderkumar01
 *
 */
public class UtilFunctions {

	public static String getScreenShot(WebDriver driver, String methodName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Screenshots/" + methodName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	public static String getDateAndTime() {
		Date date = new Date();
		long timeMilli = date.getTime();
		String strDate = Long.toString(timeMilli);
		return strDate;
	}

	public static boolean checkFolderExistsAtGivenLocation(String filePath) {

		File f = new File(filePath);
		if (f.exists() && f.isDirectory()) {
			return true;
		}
		return false;
	}

	public static void moveFileFromSrcToDest(String source, String destination) {

		try {
			File src = new File(source);
			File dest = new File(destination);

			FileUtils.copyDirectory(src, dest);

		} catch (Exception e) {
			e.getMessage();

		}
	}

	public static void deleteFolderFromLocation(String location) {
		File f = new File(location);
		String[] entries = f.list();
		for (String s : entries) {
			File currentFile = new File(f.getPath(), s);
			currentFile.delete();
		}
		f.delete();
	}
}
