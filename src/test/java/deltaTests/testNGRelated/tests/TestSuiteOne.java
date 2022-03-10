package deltaTests.testNGRelated.tests;

import deltaTests.Initializer;
import deltaTests.pageObjectClasses.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSuiteOne {
	private WebDriver driver;
	private HomePage homepage;

	@BeforeMethod
	public void initializeWebdriver(){
		Initializer initializer = new Initializer(); //someUpdate
		initializer.createChromeDriverInstance();
		driver = initializer.getDriver();
		homepage = new HomePage(driver);
	}

	@Test
	public void openLoginPage(){
		driver.get("http://delta.com");
//		WebElement loginButton = driver.findElement(By.xpath("//button[contains(@class, 'login')]"));
//		Actions actions = new Actions(driver);
//		Assert.assertTrue(loginButton.isDisplayed());
//		driver.findElement(By.xpath("//div[contains(@class, 'card-img-overlay')]")).click();
//		actions.moveToElement(loginButton).click().build().perform();
		Assert.assertTrue(homepage.getLoginButtonOnHomePage().isDisplayed());
		homepage.getOverlayImageAdvertisement().click();
		homepage.getLoginButtonOnHomePage().click();

		Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(), 'To Delta')]")).isDisplayed());

		try {
			Thread.sleep(2000);
		} catch(InterruptedException e){
			System.out.println("Interrupted exception was thrown");
		}

		driver.quit();
	}
}
