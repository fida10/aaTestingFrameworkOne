package deltaTests.pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePageToInheritFrom {
	protected WebDriver driver;

	public BasePageToInheritFrom(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	//validation method
	public abstract void validatePageHasAppeared();
}
