package aaTests.testNGRelated.tests;

import aaTests.Initializer;
import aaTests.pageObjectClasses.ChooseFlightsPage;
import aaTests.pageObjectClasses.HomePage;
import aaTests.pageObjectClasses.LoginPage;
import aaTests.pageObjectClasses.SearchResultsPage;
import aaTests.utils.ScreenshotCaptureHandling;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class TestSuiteOne {
	private WebDriver driver;
	private HomePage homepage;
	private LoginPage loginPage;
	private SearchResultsPage searchResultsPage;
	private ScreenshotCaptureHandling screenshotCaptureHandling;
	private ChooseFlightsPage chooseFlightsPage;

	private ScreenshotCaptureHandling screenshotCaptureHandling;

	@BeforeMethod
	public void initializeWebdriver() {
		Initializer initializer = new Initializer(); //someUpdate
		initializer.createChromeDriverInstance();
		driver = initializer.getDriver();
		homepage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		searchResultsPage = new SearchResultsPage(driver);
		screenshotCaptureHandling= new ScreenshotCaptureHandling(driver);
		chooseFlightsPage = new ChooseFlightsPage(driver);

		screenshotCaptureHandling = new ScreenshotCaptureHandling(driver);

		driver.get("https://aa.com");
	}

//	@Test
//	public void openLoginPage() {
//		homepage.validatePageHasAppeared();
//		homepage.openLoginPageFromHomePageNotValidating();
//		loginPage.validatePageHasAppeared();
//		loginPage.loginToAA("shihabSylhetTestOne", "Sylhettest", "$shihabSylhetTest1");
//		homepage.validateUsernameOfHomePageLoggedIn("Shihabtest");
//		System.out.println("TEST PASSED");
//		driver.quit();
//	} Automation does not work with registration flow, will skip these flows5
	// Tests are here for reference

	@Test
	public void searchForFlight() {
		homepage.closeAlertAdvisory();
		homepage.enterCitiesToTravelTo("DFW", "CMB");
		homepage.selectTypeOfTrip("One Way");
		homepage.datePicker(5, 25, 2022);
		homepage.paxCountPicker(5);
		homepage.hoverOverAndClickSearchForFlightsButton();
		searchResultsPage.validatePageHasAppeared();
		searchResultsPage.checkOriginArrivalTripType("DFW", "CMB", "One Way");
		searchResultsPage.validateCorrectDepartDate(5, 25, 2022);
		searchResultsPage.selectClassandFare("Business");
		chooseFlightsPage.validatePageHasAppeared();
		chooseFlightsPage.scrollDownToAndClickContinueAsGuest();


		String dateFormat = "yyyy" + "_" + "MM" + "_" + "dd" + "__" + "a_hh_mm_ss";
		DateTimeFormatter dtForm = DateTimeFormatter.ofPattern(dateFormat); //formats date with the pattern specified above
		LocalDateTime current = LocalDateTime.now();
//		boolean wasPathCreated = new File(System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + dtForm.format(current)).mkdir();
//		System.out.println("Was the path created" +wasPathCreated);
		screenshotCaptureHandling.returnScreenshotAndSave(System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + dtForm.format(current));
		driver.quit();
	}
}
