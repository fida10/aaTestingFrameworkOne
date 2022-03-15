package deltaTests.pageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.security.Key;

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

	String typeOfTripOptionDynamicXPath = "//ul[@id = 'selectTripType-desc']/li[contains(text(), '%s')]";

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
	public void validateUsernameOfHomePageLoggedIn(String expectedFirstName){
		Assert.assertEquals(expectedFirstName, homePageLoggedInUsernameDisplayed.getText());
	}

	//workflows
	//openLoginPageFromHomePage does not validate that login page has opened
	public void closeAlertAdvisory(){
		Assert.assertTrue(alertAdvisoryCloseButton.isDisplayed());
		alertAdvisoryCloseButton.click();
	}

	public void openLoginPageFromHomePageNotValidating(){
		//overlayImageAdvertisement.click();
		closeAlertAdvisory();
		loginButtonOnHomePage.click();
	}


	public void selectTypeOfTrip(String tripType){
		//hover over dropdown
		//click on it
		//assert that tripType appears (use dynamic string)
		//move to and click on that trip type
		//assert that that trip type now appears in the type of trip box
		Assert.assertTrue(typeOfTripDropDownSelector.isDisplayed());
		Actions a = new Actions(driver);

		a.moveToElement(driver.findElement(By.xpath("//button[contains(@class, 'advisory-close-icon')]"))).click().build().perform();

		a
				.moveToElement(typeOfTripDropDownSelector)
				.click()
				.build()
				.perform();

		WebElement typeOfTrip = driver.findElement(By.xpath(String.format(typeOfTripOptionDynamicXPath, tripType)));
		Assert.assertTrue(typeOfTrip.isDisplayed());

		a
				.moveToElement(typeOfTrip)
				.click()
				.build()
				.perform();

		Assert.assertEquals(typeOfTripDropDownSelector.getText(), tripType);




	}


}
