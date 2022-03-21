package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ExceptionHandling {

	public boolean isDisplayedEnhanced(String elementToCheckXPath, int timeToWaitForElementInSeconds, WebDriver driver){

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeToWaitForElementInSeconds));
		boolean isElementDisplayed;

		try {
			isElementDisplayed = driver.findElement(By.xpath(elementToCheckXPath)).isDisplayed();
		} catch (NoSuchElementException e){
			System.out.println("Element: " + elementToCheckXPath + " was not displayed! Returning false.");
			isElementDisplayed = false;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //need to change this to read from config.properties
		return isElementDisplayed;

	}
}
