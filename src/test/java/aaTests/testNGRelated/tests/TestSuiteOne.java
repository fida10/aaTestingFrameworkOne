package aaTests.testNGRelated.tests;

import aaTests.Initializer;
import aaTests.pageObjectClasses.HomePage;
import aaTests.pageObjectClasses.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
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
		driver.get("https://aa.com");
	}

//	@Test
//	public void openLoginPage() {
//		homepage.validatePageHasAppeared();
//		homepage.openLoginPageFromHomePageNotValidating();
//		loginPage.validatePageHasAppeared();
//		loginPage.loginToDelta("shihabSylhetTestOne", "Sylhettest", "$shihabSylhetTest1");
//		homepage.validateUsernameOfHomePageLoggedIn("Shihabtest");
//		System.out.println("TEST PASSED");
//		driver.quit();
//	}
//
	@Test
	public void searchForFlight() {
		homepage.closeAlertAdvisory();
		homepage.enterCitiesToTravelTo("DFW", "CMB");
		homepage.selectTypeOfTrip("One Way");
		homepage.datePicker(5, 25, 2022);
		homepage.paxCountPicker(5);
		homepage.hoverOverAndClickSearchForFlightsButton();
//		driver.quit();
	}
}