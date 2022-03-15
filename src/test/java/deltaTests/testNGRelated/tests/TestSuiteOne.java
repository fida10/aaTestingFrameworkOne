package deltaTests.testNGRelated.tests;

import deltaTests.Initializer;
import deltaTests.pageObjectClasses.HomePage;
import deltaTests.pageObjectClasses.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSuiteOne {
	private WebDriver driver;
	private HomePage homepage;
	private LoginPage loginPage;

	@BeforeMethod
	public void initializeWebdriver() {
		Initializer initializer = new Initializer(); //someUpdate
		initializer.createChromeDriverInstance();
		driver = initializer.getDriver();
		homepage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		driver.get("http://delta.com");
	}

	@Test
	public void openLoginPage() {
		homepage.validatePageHasAppeared();
		homepage.openLoginPageFromHomePageNotValidating();
		loginPage.validatePageHasAppeared();
		loginPage.loginToDelta("shihabSylhetTestOne", "Sylhettest", "$shihabSylhetTest1");
		homepage.validateUsernameOfHomePageLoggedIn("Shihabtest");
		System.out.println("TEST PASSED");

		driver.quit();
	}

	@Test
	public void searchForFlight() {
		driver.get("http://delta.com");
		homepage.enterCitiesToTravelTo("DFW", "CMB");
		homepage.selectTypeOfTrip("One Way");
		driver.quit();
	}
}