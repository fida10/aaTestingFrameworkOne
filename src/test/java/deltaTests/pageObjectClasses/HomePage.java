package deltaTests.pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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


    public HomePage(WebDriver driver){
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


    //openLoginPage from homepage, does not validate that
    public void openLoginPageFromHomePageNotValidating(){
        overlayImageAdvertisement.click();
        loginButtonOnHomePage.click();
    }

}
