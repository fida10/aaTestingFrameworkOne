package deltaTests.pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


    @FindBy(xpath = "//button[contains(@class, 'login')]")
    WebElement loginButtonOnHomePage;
    String loginButtonHomePageXPath = "//button[contains(@class, 'login')]";

    @FindBy(xpath = "//div[contains(@class, 'card-img-overlay')]")
    WebElement overlayImageAdvertisement;
    String overlayImageAdvertisementXPath = "//div[contains(@class, 'card-img-overlay')]";

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);

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
}
