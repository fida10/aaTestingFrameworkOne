package deltaTests.testNGRelated.tests;

import deltaTests.Initializer;
import deltaTests.pageObjectClasses.HomePage;
import deltaTests.pageObjectClasses.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSuiteOne {
	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;

	@BeforeMethod
	public void initializeWebdriver(){
		Initializer initializer = new Initializer(); //someUpdate
		initializer.createChromeDriverInstance();
		driver = initializer.getDriver();
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		driver.get("http://delta.com");
	}

	@Test
	public void logIn(){
		homePage.validatePageHasAppeared();
		homePage.openLoginPageFromHomePageNotValidating();

		loginPage.validatePageHasAppeared();
		loginPage.loginToDelta("shihabSylhetTestOne", "Sylhettest", "$shihabSylhetTest1");

		homePage.validateUsernameOfHomePageLoggedIn("Shihabtest");

		driver.quit();
	}

	@Test
	public void searchForAFlight(){

		homePage.selectTypeOfTrip("One Way");
	}
}
