package deltaTests.pageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.text.DateFormatSymbols;


public class HomePage extends BasePageToInheritFrom {

	@FindBy(xpath = "//button[contains(@class, 'advisory-close-icon')]")
	WebElement alertAdvisoryCloseButton;
	String alertAdvisoryCloseButtonXPath = "//button[contains(@class, 'advisory-close-icon')]";

	@FindBy(xpath = "//button[contains(@class, 'login')]")
	WebElement loginButtonOnHomePage;
	String loginButtonHomePageXPath = "//button[contains(@class, 'login')]";

	@FindBy(xpath = "//div[contains(@class, 'card-img-overlay')]")
	WebElement overlayImageAdvertisement;
	String overlayImageAdvertisementXPath = "//div[contains(@class, 'card-img-overlay')]";

	@FindBy(xpath = "//span[@class = 'pax-name']")
	WebElement homePageLoggedInUsernameDisplayed;
	String homePageLoggedInUsernameDisplayedXPath = "//span[@class = 'pax-name']";

	@FindBy(xpath = "//span[@id = 'selectTripType-val']")
	WebElement typeOfTripDropDownSelector;
	String typeOfTripDropDownSelectorXPath = "//span[@id = 'selectTripType-val']";

	@FindBy(xpath = "//a[@id='fromAirportName']")
	WebElement originCity;
	String originCityXPath = "//a[@id='fromAirportName']";

	@FindBy(xpath = "//a[@id='toAirportName']")
	WebElement arrivalCity;
	String arrivalCityXPath = "//a[@id='toAirportName']";

	@FindBy(xpath = "//a[@class='airportLookup-list']")
	WebElement firstDropdownSuggestion;
	String firstDropdownSuggestionXPath = "//a[@class='airportLookup-list']";

	@FindBy(xpath = "//input[@id='search_input']")
	WebElement citySearchBox;
	String citySearchBoxXPath = "//input[@id='search_input']";

	@FindBy(xpath = "//div[@id='input_departureDate_1']")
	WebElement datePickerOpener;
	String datePickerOpenerXPath = "//div[@id='input_departureDate_1']";

	@FindBy(xpath = "//span[@class = 'calenderDepartSpan']")
	WebElement datePickerDepAfterSelect;
	String datePickerDeptAfterSelectXpath = "//span[@class = 'calenderDepartSpan']";

	@FindBy(xpath = "//a[@title='To select next month']")
	WebElement selectNextMonth;
	String selectNextMonthXPath = "//a[@title='To select next month']";

	@FindBy(xpath = "//button[@value='done']")
	WebElement doneButtonDate;
	String doneButtonXPath = "//button[@value='done']";

	String typeOfTripOptionDynamicXPath = "//ul[@id = 'selectTripType-desc']/li[contains(text(), '%s')]";
	String datePickerMonthDynamicXPath = "//span[contains(@class,'dl-datepicker-month') and contains(text(), '%s')]";
	String datePickerYearDynamicXPath = "//span[contains(@class,'dl-datepicker-year') and contains(text(), '%d')]";

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public WebElement getLoginButtonOnHomePage() {
		return loginButtonOnHomePage;
	}

	public String getLoginButtonHomePageXPath() {
		return loginButtonHomePageXPath;
	}

	public WebElement getOverlayImageAdvertisement() {
		return overlayImageAdvertisement;
	}

	public String getOverlayImageAdvertisementXPath() {
		return overlayImageAdvertisementXPath;
	}

	public WebElement getArrivalCity() {
		return arrivalCity;
	}

	public String getArrivalCityXPath() {
		return arrivalCityXPath;
	}

	public WebElement getFirstDropdownSuggestion() {
		return firstDropdownSuggestion;
	}

	public String getFirstDropdownSuggestionXPath() {
		return firstDropdownSuggestionXPath;
	}

	public WebElement getCitySearchBox() {
		return citySearchBox;
	}

	public String getCitySearchBoxXPath() {
		return citySearchBoxXPath;
	}

	public WebElement getDatePickerOpener() {
		return datePickerOpener;
	}

	public String getDatePickerOpenerXPath() {
		return datePickerOpenerXPath;
	}

	public WebElement getSelectNextMonth() {
		return selectNextMonth;
	}

	public String getSelectNextMonthXPath() {
		return selectNextMonthXPath;
	}

	//validation methods
	public void validatePageHasAppeared() {
		Assert.assertTrue(loginButtonOnHomePage.isDisplayed());
	}

	public void validatePageHasAppearedHomePageLoggedIn() {
		Assert.assertTrue(homePageLoggedInUsernameDisplayed.isDisplayed());
	}

	public void validateUsernameOfHomePageLoggedIn(String expectedFirstName) {
		Assert.assertEquals(expectedFirstName, homePageLoggedInUsernameDisplayed.getText());
	}

	//workflows
	// closes alert that appears on homepage, so we can access search field
	public void closeAlertAdvisory() {
		Assert.assertTrue(alertAdvisoryCloseButton.isDisplayed());
		actions
				.moveToElement(alertAdvisoryCloseButton)
				.click()
				.build()
				.perform();
//		alertAdvisoryCloseButton.click();

	}

	//openLoginPageFromHomePage does not validate that login page has opened
	public void openLoginPageFromHomePageNotValidating() {
		//overlayImageAdvertisement.click();
		closeAlertAdvisory();
		loginButtonOnHomePage.click();
	}

	// selects to and from cities
	public void enterCitiesToTravelTo(String origin, String arrival) {

		closeAlertAdvisory();
		originCity.click();
		actions
				.sendKeys(origin)
				.build()
				.perform();
		firstDropdownSuggestion.click();
		arrivalCity.click();
		actions
				.sendKeys(arrival)
				.build()
				.perform();
		firstDropdownSuggestion.click();
	}


	public void selectTypeOfTrip(String tripType) {
		//hover over dropdown
		//click on it
		//assert that tripType appears (use dynamic string)
		//move to and click on that trip type
		//assert that that trip type now appears in the type of trip box
		Assert.assertTrue(typeOfTripDropDownSelector.isDisplayed());


		actions
				.moveToElement(typeOfTripDropDownSelector)
				.click()
				.build()
				.perform();

		WebElement typeOfTrip = driver.findElement(By.xpath(String.format(typeOfTripOptionDynamicXPath, tripType)));
		Assert.assertTrue(typeOfTrip.isDisplayed());

		actions
				.moveToElement(typeOfTrip)
				.click()
				.build()
				.perform();

		Assert.assertEquals(typeOfTripDropDownSelector.getText(), tripType);


	}

	public void datePicker(int monthAsInt, int dateAsInt, int yearAsInt) {
		actions
				.moveToElement(datePickerOpener)
				.click()
				.build()
				.perform();

		String monthAsString = new DateFormatSymbols().getMonths()[monthAsInt - 1];

		String datePickerMonthHeaderXPath = String.format(datePickerMonthDynamicXPath, monthAsString);
		String datePickerYearHeaderXPath = String.format(datePickerYearDynamicXPath, yearAsInt);

//		WebElement datePickerMonthHeader = driver.findElement(By.xpath(String.format(datePickerMonthDynamicXPath, monthAsString)));
//		WebElement datePickerYearHeader = driver.findElement(By.xpath(String.format(datePickerYearDynamicXPath, yearAsInt)));

		while (!(exceptionHandling.isDisplayedEnhanced(datePickerMonthHeaderXPath, 1, driver) &&
		exceptionHandling.isDisplayedEnhanced(datePickerYearHeaderXPath, 1, driver))) {

			actions
					.moveToElement(selectNextMonth)
					.click()
					.build()
					.perform();


		}

		WebElement datePickerIndivDate = driver.findElement(By.xpath(String.format(datePickerMonthHeaderXPath.
				concat("/ancestor::div[@class= 'dl-datepicker-header']/following-sibling::div[@class='dl-datepicker-calendar-cont']//a[text()= '%d']"), dateAsInt)));


		actions
				.moveToElement(datePickerIndivDate)
				.click()
				.moveToElement(doneButtonDate)
				.click()
				.build()
				.perform();

		Assert.assertEquals(monthAsString.substring(0,3) + " " + dateAsInt, datePickerDepAfterSelect.getText());

	}
}


