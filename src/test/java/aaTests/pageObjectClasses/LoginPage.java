package aaTests.pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePageToInheritFrom{

	@FindBy(xpath = "//h1[contains(text(), 'Log in')]")
	WebElement loginPageHeader;
	String loginPageHeaderXPath = "//h1[contains(text(), 'Log in')]";

	@FindBy(xpath = "//input[@id = 'loginId']")
	WebElement usernameBox;
	String usernameBoxXPath = "//input[@id = 'loginId']";

	@FindBy(xpath = "//input[@id = 'lastName']")
	WebElement lastNameBox;
	String lastNameBoxXPath = "//input[@id = 'lastName']";

	@FindBy(xpath = "//input[@id = 'password']")
	WebElement passwordBox;
	String passwordBoxXpath = "//input[@id = 'password']";

	@FindBy(xpath = "//label[@for='rememberMe']/span")
	WebElement keepMeLoggedInCheckbox;
	String keepMeLoggedInCheckboxXPath = "//label[@for='rememberMe']/span";

	@FindBy(xpath = "//button[@id='button_login']")
	WebElement loginButton;
	String loginButtonXPath = "//button[@id='button_login']";

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	//validation methods
	public void validatePageHasAppeared(){
		Assert.assertTrue(loginPageHeader.isDisplayed());
	}

	//workflow methods
	public void loginToAA(String username, String lastName, String password){


		actions
				.moveToElement(usernameBox)
				.click()
				.sendKeys(username)
				.build()
				.perform();

		Assert.assertTrue(lastNameBox.isDisplayed());

		actions
				.moveToElement(lastNameBox)
				.click()
				.sendKeys(lastName)
				.moveToElement(passwordRevealButton)
				.click()
				.moveToElement(passwordBox)
				.click()
				.sendKeys(password)
				.moveToElement(keepMeLoggedInCheckbox)
				.click()
				.moveToElement(loginButton)
				.click()
				.build()
				.perform();
	}
}
