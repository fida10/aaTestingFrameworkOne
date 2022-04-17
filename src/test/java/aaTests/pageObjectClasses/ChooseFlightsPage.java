package aaTests.pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ChooseFlightsPage extends BasePageToInheritFrom{

	@FindBy(xpath = "//h2[@class = 'ui-dialog-title' and contains(text(), 'Upgrade to')]")
	WebElement upgradePopUpHeader;
	String upgradePopUpHeaderXPath = "//h2[@class = 'ui-dialog-title' and contains(text(), 'Upgrade to')]";

	@FindBy(xpath = "//button[@data-event_action = 'close x']")
	WebElement closeUpgradeMainPlusHeader;
	String closeUpgradeMainPlusHeaderXPath = "//button[@data-event_action = 'close x']";

	@FindBy(xpath = "//h1[contains(text(), 'Choose flights')]")
	WebElement chooseFlightsPageHeader;
	String chooseFlightsPageHeaderXPath = "//h1[contains(text(), 'Choose flights')]";

	@FindBy(xpath = "//button[@type = 'submit' and contains(text(), 'Continue as guest')]")
	WebElement continueAsGuestButton;
	String continueAsGuestButtonXPath = "//button[@type = 'submit' and contains(text(), 'Continue as guest')]";

	public ChooseFlightsPage(WebDriver driver) {
		super(driver);
	}

	public void validatePageHasAppeared() {
		//will close upgrade to main plus and then validate header of page
		if(exceptionHandling.isDisplayedEnhanced(upgradePopUpHeaderXPath, 5, driver)) {
			closeUpgradeMainPlusHeader.click();
		}
		Assert.assertTrue(chooseFlightsPageHeader.isDisplayed());
	}

	public void scrollDownToAndClickContinueAsGuest(){
		actions
				.moveToElement(continueAsGuestButton)
				.click()
				.build()
				.perform();
	}

}
