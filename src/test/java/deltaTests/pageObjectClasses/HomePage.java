package deltaTests.pageObjectClasses;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.text.DateFormatSymbols;
import java.util.Arrays;


public class HomePage extends BasePageToInheritFrom {

	@FindBy(xpath = "//button[@id='globalMessageClose']")
	WebElement alertAdvisoryCloseButton;
	String alertAdvisoryCloseButtonXPath = "//button[@id='globalMessageClose']";

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

	@FindBy(xpath = "//input[@id='reservationFlightSearchForm.originAirport']")
	WebElement originCity;
	String originCityXPath = "//input[@id='reservationFlightSearchForm.originAirport']";

	@FindBy(xpath = "//input[@id='reservationFlightSearchForm.destinationAirport']")
	WebElement arrivalCity;
	String arrivalCityXPath = "//input[@id='reservationFlightSearchForm.destinationAirport']";

	@FindBy(xpath = "//a[@class='airportLookup-list']")
	WebElement firstDropdownSuggestion;
	String firstDropdownSuggestionXPath = "//a[@class='airportLookup-list']";

	String firstDropdownSuggestionDynamicXPath = "//li[@class='ui-menu-item']/a[contains(text(), '%s')]";

	@FindBy(xpath = "//input[@id='search_input']")
	WebElement citySearchBox;
	String citySearchBoxXPath = "//input[@id='search_input']";

	@FindBy(xpath = "//button[@class='ui-datepicker-trigger']")
	WebElement datePickerOpener;
	String datePickerOpenerXPath = "//button[@class='ui-datepicker-trigger']";

	@FindBy(xpath = "//input[@name='departDate']")
	WebElement datePickerDepTextBox;
	String datePickerDeptTextBox = "//input[@name='departDate']";
	String datePickerDeptTextBoxID = "aa-leavingOn";

	@FindBy(xpath = "//a[@aria-label='Next Month']")
	WebElement selectNextMonth;
	String selectNextMonthXPath = "//a[@aria-label='Next Month']";

	@FindBy(xpath = "//button[@value='done']")
	WebElement doneButtonDate;
	String doneButtonXPath = "//button[@value='done']";

	@FindBy(xpath = "//select[@id='flightSearchForm.adultOrSeniorPassengerCount']")
	WebElement paxPickerDropdownSelector;
	String paxPickerDropdownSelectorXPath = "//select[@id='flightSearchForm.adultOrSeniorPassengerCount']";
	String paxPickerDropdownSelectorID = "flightSearchForm.adultOrSeniorPassengerCount";

	@FindBy(xpath = "//ul[@id = 'selectTripType-desc']")
	WebElement paxPickerDropdownAllOptionsBox;
	String paxPickerDropdownAllOptionsBoxXPath = "//ul[@id = 'selectTripType-desc']";

	@FindBy(xpath = "//input[@id='flightSearchForm.button.reSubmit']")
	WebElement searchForFlightsSubmitButton;
	String searchForFlightSubmitButtonXPath = "//input[@id='flightSearchForm.button.reSubmit']";


	String typeOfTripOptionDynamicXPath = "//div[@id='bookingCheckboxContainer']//span[contains(text(), '%s')]";
	String datePickerMonthDynamicXPath = "//span[contains(@class,'ui-datepicker-month') and contains(text(), '%s')]";
	String datePickerYearDynamicXPath = "//span[contains(@class,'ui-datepicker-year') and contains(text(), '%d')]";
	String noOfPaxOptionToSelectDynamicXPath = "//ul[@id = 'passengers-desc']/li[contains(text(), '%d')]";

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

//		closeAlertAdvisory(); already done in test case
		originCity.clear();
		originCity.click();
		actions
				.sendKeys(origin)
				.build()
				.perform();

		driver.findElement(By.xpath(String.format(firstDropdownSuggestionDynamicXPath, origin.toUpperCase()))).click();
		arrivalCity.clear();
		arrivalCity.click();
		actions
				.sendKeys(arrival)
				.build()
				.perform();
		driver.findElement(By.xpath(String.format(firstDropdownSuggestionDynamicXPath, arrival.toUpperCase()))).click();

	}

	public void selectTypeOfTrip(String tripType) {
		//hover over dropdown
		//click on it
		//assert that tripType appears (use dynamic string)
		//move to and click on that trip type
		//assert that that trip type now appears in the type of trip box
//		Assert.assertTrue(typeOfTripDropDownSelector.isDisplayed());
//
//
//		actions
//				.moveToElement(typeOfTripDropDownSelector)
//				.click()
//				.build()
//				.perform();


		StringBuilder sb = new StringBuilder(tripType.toLowerCase());

		char firstCharUpperCase =  (char) (sb.charAt(0) - 32);
		sb.deleteCharAt(0).reverse();
		sb.append(firstCharUpperCase).reverse();

		WebElement typeOfTrip = driver.findElement(By.xpath(String.format(typeOfTripOptionDynamicXPath, sb)));
		Assert.assertTrue(typeOfTrip.isDisplayed());

		actions
				.moveToElement(typeOfTrip)
				.click()
				.build()
				.perform();

//		Assert.assertEquals(typeOfTripDropDownSelector.getText(), tripType);


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
				concat("/parent::div/parent::div/following-sibling::table//a[text()= '%d']"), dateAsInt)));

		actions
				.moveToElement(datePickerIndivDate)
				.click()
				.build()
				.perform();

		Assert.assertTrue(((String)(((JavascriptExecutor) driver).executeScript(String.format("return document.getElementById('%s').value",datePickerDeptTextBoxID)))).contains(monthAsInt + "/" + dateAsInt + "/" + yearAsInt));

	}

	public void paxCountPicker(int noOfPaxOneToNine) {

		Assert.assertTrue(paxPickerDropdownSelector.isDisplayed());

		new Select(paxPickerDropdownSelector).selectByVisibleText(String.valueOf(noOfPaxOneToNine));
		Assert.assertEquals(((String)(((JavascriptExecutor) driver).executeScript(String.format("return document.getElementById('%s').value", paxPickerDropdownSelectorID)))), String.valueOf(noOfPaxOneToNine));
//		actions
//				.moveToElement(paxPickerDropdownSelector)
//				.click()
//				.build()
//				.perform();
//
//		WebElement noOfPaxOptionToSelect = driver.findElement(By.xpath(String.format(noOfPaxOptionToSelectDynamicXPath, noOfPaxOneToNine)));
//
////		actions
////				.moveToElement(noOfPaxOptionToSelect)
////				.build()
////				.perform();
//
////		Assert.assertTrue(noOfPaxOptionToSelect.getAttribute("class").contains("select-ui-optionList-hover"));
////		noOfPaxOptionToSelect.click();
//
//		while(!noOfPaxOptionToSelect.getAttribute("class").contains("select-ui-optionList-hover")){
//			actions
//					.sendKeys(Keys.DOWN)
//					.build()
//					.perform();
//		}
//
//		/*
//		* Reason for using a while loop
//		* When we hover over the passenger count selection we want, there is a delay in the website.
//		* There is a delay between clicking the dropdown and the dropdown options appearing
//		* We use keys.DOWNS to scroll to the options we want. This also has the benefit of checking all the other options
//		* initially using the direct method of clicking, the wrong number of pax would be clicked since it took a while
//		* for all the pax numbers to be displayed
//		* */
//		noOfPaxOptionToSelect.click();
//		Assert.assertTrue(paxPickerDropdownSelector.getText().contains(String.format("%d Passenger", noOfPaxOneToNine)));
//		Assert.assertEquals(paxPickerDropdownSelector.getText(), String.valueOf(noOfPaxOneToNine));
	}

	public void hoverOverAndClickSearchForFlightsButton(){
		actions
				.moveToElement(searchForFlightsSubmitButton)
				.click()
				.build()
				.perform();

	}
}