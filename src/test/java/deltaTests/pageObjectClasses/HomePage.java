package deltaTests.pageObjectClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BasePageToInheritFrom {


    @FindBy(xpath = "//button[contains(@class, 'login')]")
    WebElement loginButtonOnHomePage;
    String loginButtonHomePageXPath = "//button[contains(@class, 'login')]";

    @FindBy(xpath = "//div[contains(@class, 'card-img-overlay')]")
    WebElement overlayImageAdvertisement;
    String overlayImageAdvertisementXPath = "//div[contains(@class, 'card-img-overlay')]";

    @FindBy(xpath = "//span[@class='pax-name']")
    WebElement homePageLoggedInUsernameDisplayed;
    String homePageLoggedInUsernameDisplayedXPath = "//span[@class='pax-name']";

    @FindBy(xpath = "//a[@id='fromAirportName']")
    WebElement originCity;
    String originCityXPath = "//a[@id='fromAirportName']";

    @FindBy(xpath = "//a[@id='toAirportName']")
    WebElement arrivalCity;
    String arrivalCityXPath = "//a[@id='toAirportName']";

    @FindBy(xpath = "//button[@role='button']")
    WebElement closeHelpBox;
    String closeHelpBoxXPath = "//button[@role='button']";

    @FindBy(xpath = "//a[@class='airportLookup-list']")
    WebElement firstDropdownSuggestion;
    String firstDropdownSuggestionXPath = "//a[@class='airportLookup-list']";

    @FindBy(xpath = "//input[@id='search_input']")
    WebElement citySearchBox;
    String citySearchBoxXPath = "//input[@id='search_input']";



    public HomePage(WebDriver driver){
        super(driver);

    }

    public WebElement getLoginButtonOnHomePage() {return loginButtonOnHomePage;}

    public String getLoginButtonHomePageXPath() {
        return loginButtonHomePageXPath;
    }

    public WebElement getOverlayImageAdvertisement() {return overlayImageAdvertisement;}

    public String getOverlayImageAdvertisementXPath() {
        return overlayImageAdvertisementXPath;
    }

    public WebElement getOriginCity() {return originCity;}

    public String getOriginCityXPath() {return originCityXPath;}

    public WebElement getArrivalCity() {return arrivalCity;}

    public String getArrivalCityXPath() {return arrivalCityXPath;}

    public WebElement getCloseHelpBox() {return closeHelpBox;}

    public String getCloseHelpBoxXPath() {return closeHelpBoxXPath;}

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
    public void validateUserNameOfHomePagedLoggedIn(String expectedFirstName){
        Assert.assertEquals(expectedFirstName, homePageLoggedInUsernameDisplayed.getText());
    }

    public void enterCitiesToTravelTo(String origin, String arrival){
        Actions a = new Actions(driver);
        Assert.assertTrue(closeHelpBox.isDisplayed());
        closeHelpBox.click();
        originCity.click();
        a
                .sendKeys(origin)
                .build()
                .perform();
        firstDropdownSuggestion.click();
//        Assert.assertEquals(originCity.getText(), origin);
        arrivalCity.click();
        a
                .sendKeys(arrival)
                .build()
                .perform();
        firstDropdownSuggestion.click();
    }


    //openLoginPage from homepage, does not validate that
    public void openLoginPageFromHomePageNotValidating(){
        overlayImageAdvertisement.click();
        loginButtonOnHomePage.click();
    }

}
