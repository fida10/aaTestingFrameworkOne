package deltaTests.pageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


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

	String typeOfTripOptionDynamicXPath = "//ul[@id = 'selectTripType-desc']/li[contains(text(), '%s')]";

	@FindBy(xpath = "//div[@id = 'input_departureDate_1']")
	WebElement datePickerOpener;
	String datePickerOpenerXPath = "//div[@id = 'input_departureDate_1']";

	public HomePage(WebDriver driver){
		super(driver);
	}

	public WebElement getLoginButtonOnHomePage() {return loginButtonOnHomePage;}

	public String getLoginButtonHomePageXPath() {return loginButtonHomePageXPath;}

	public WebElement getOverlayImageAdvertisement() {return overlayImageAdvertisement;}

	public String getOverlayImageAdvertisementXPath() {return overlayImageAdvertisementXPath;}

    public WebElement getArrivalCity() {return arrivalCity;}

    public String getArrivalCityXPath() {return arrivalCityXPath;}

    public WebElement getFirstDropdownSuggestion() {return firstDropdownSuggestion;}

    public String getFirstDropdownSuggestionXPath() {return firstDropdownSuggestionXPath;}

    public WebElement getCitySearchBox() {return citySearchBox;}

    public String getCitySearchBoxXPath() {return citySearchBoxXPath;}

	//validation methods
	public void validatePageHasAppeared(){
		Assert.assertTrue(loginButtonOnHomePage.isDisplayed());
	}

	public void validatePageHasAppearedHomePageLoggedIn(){
		Assert.assertTrue(homePageLoggedInUsernameDisplayed.isDisplayed());
	}
	public void validateUsernameOfHomePageLoggedIn(String expectedFirstName){
		Assert.assertEquals(expectedFirstName, homePageLoggedInUsernameDisplayed.getText());
	}

	//workflows
	// closes alert that appears on homepage, so we can access search field
	public void closeAlertAdvisory(){
		Assert.assertTrue(alertAdvisoryCloseButton.isDisplayed());
		actions
				.moveToElement(alertAdvisoryCloseButton)
				.click()
				.build()
				.perform();
//		alertAdvisoryCloseButton.click();

	}
    //openLoginPageFromHomePage does not validate that login page has opened
	public void openLoginPageFromHomePageNotValidating(){
		//overlayImageAdvertisement.click();
		closeAlertAdvisory();
		loginButtonOnHomePage.click();
	}
    // selects to and from cities
    public void enterCitiesToTravelTo(String origin, String arrival){
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


	public void selectTypeOfTrip(String tripType){
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

	public void datePicker(int monthAsInt, int dateAsInt, int yearAsInt){

	}



}
