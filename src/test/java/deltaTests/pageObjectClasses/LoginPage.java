package deltaTests.pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePageToInheritFrom{

	@FindBy(xpath = "//h1[contains(text(), 'To Delta')]")
	WebElement loginPageHeader;
	String loginPageHeaderXPath = "//h1[contains(text(), 'To Delta')]";

	@FindBy(xpath = "//input[@id = 'userId']")
	WebElement usernameBox;
	String usernameBoxXPath = "//input[@id = 'userId']";

	@FindBy(xpath = "//input[@id = 'lastName']")
	WebElement lastNameBox;
	String lastNameBoxXPath = "//input[@id = 'lastName']";

	@FindBy(xpath = "//input[@id = 'password']")
	WebElement passwordBox;
	String passwordBoxXpath = "//input[@id = 'password']";

	@FindBy(xpath = "//button[@class = 'passwordIcon']")
	WebElement passwordRevealButton;
	String passwordRevealButtonXPath = "//button[@class = 'passwordIcon']";

	@FindBy(xpath = "//input[@id = 'persistentLogin_CheckBox']")
	WebElement keepMeLoggedInCheckbox;
	String keepMeLoggedInCheckboxXPath = "//input[@id = 'persistentLogin_CheckBox']";

	@FindBy(xpath = "//div[@class = 'loginButtonDiv']/button[@type = 'submit']")
	WebElement loginButton;
	String loginButtonXPath = "//button[@type = 'submit']";

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	//validation methods
	public void validatePageHasAppeared(){
		Assert.assertTrue(loginPageHeader.isDisplayed());
	}

	//workflow methods
	public void loginToDelta(String username, String lastName, String password){


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
