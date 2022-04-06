package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ExceptionHandling {

    public boolean isDisplayedEnhanced(String elementToCheckXPath, int timeToWaitForElementInSeconds, WebDriver driver){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeToWaitForElementInSeconds));
        boolean isElementDisplayed = true;

        try {
            isElementDisplayed = driver.findElement(By.xpath(elementToCheckXPath)).isDisplayed();
        } catch(NoSuchElementException e){
            System.out.println("Element:" + elementToCheckXPath + "was not displayed, returning false");
            isElementDisplayed = false;
        }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            return isElementDisplayed;




    }



}
