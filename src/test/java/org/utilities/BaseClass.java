package org.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Select s;
	public static WebDriverWait wait;
	

	
	
	
	public static void launchChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

//	public static void launchBrowser(String browserType) {
//
//		if (browserType.equals("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}
//
//	}

	public static void documentready() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ready = (String) js.executeScript("return document.readyState");
		System.out.println(ready);
	}

	public static void mask() {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fullscreen-load")));
		// Log.info("Mask is found");
	}

	public static void loading() {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading")));
	}

	public static void loadUrl(String url) {

		driver.get(url);

	}

	public static String retriveText(WebElement ele) {
		String text =ele.getText();
		return text;
	}

	public static void elementClick(WebElement element) {
		element.click();
	}

	public static void windowMaximze() {
		driver.manage().window().maximize();
	}

	public static void applyWaits() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}

	public static boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public static void closeBroswer() {
		driver.quit();
	}

	public static void waitforElementToPresentInPage(By locator, int seconds) {

		wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public static void verifyElementPresenceInPage(WebElement element) {

		Assert.assertTrue(element.isDisplayed());

	}
	
	public static void verifyActualExpected(WebElement element,String expect) {
		String actual = element.getAttribute("value");
		Assert.assertEquals(actual, expect);

	}
	
	
	public static void selectValue(WebElement element,String value) {
		s=new Select(element);
		s.selectByValue(value);
		
	}
	
	

}
