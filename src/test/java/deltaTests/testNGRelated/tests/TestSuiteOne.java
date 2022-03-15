package deltaTests.testNGRelated.tests;

import deltaTests.Initializer;
import deltaTests.pageObjectClasses.HomePage;
import deltaTests.pageObjectClasses.LoginPage;
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
	private LoginPage loginPage;

	@BeforeMethod
	public void initializeWebdriver(){
		Initializer initializer = new Initializer(); //someUpdate
		initializer.createChromeDriverInstance();
		driver = initializer.getDriver();
		homepage = new HomePage(driver);
		loginPage = new LoginPage(driver);
	}

	@Test
	public void logIn(){
		driver.get("http://delta.com");
//		WebElement loginButton = driver.findElement(By.xpath("//button[contains(@class, 'login')]"));
//		Actions actions = new Actions(driver);
//		Assert.assertTrue(loginButton.isDisplayed());
//		driver.findElement(By.xpath("//div[contains(@class, 'card-img-overlay')]")).click();
//		actions.moveToElement(loginButton).click().build().perform();
		homepage.validatePageHasAppeared();
		homepage.openLoginPageFromHomePageNotValidating();
		loginPage.validatePageHasAppeared();
		loginPage.loginToDelta("shihabSylhetTestOne", "Sylhettest", "$shihabSylhetTest1");
		homepage.validateUserNameOfHomePagedLoggedIn("Shihabtest");
		System.out.println("TEST PASSED");


		try {
			Thread.sleep(10000);
		} catch(InterruptedException e){

		}

		try {
			Thread.sleep(2000);
		} catch(InterruptedException e){
			System.out.println("Interrupted exception was thrown");
		}

		driver.quit();
	}
	@Test
	public void toAndFromCities(){
		driver.get("http://delta.com");
		homepage.enterCitiesToTravelTo("DFW", "CMB");


	}

}