package deltaTests.pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePageToInheritFrom {
    // public anywhere, private, only in this class, protected, anything in package, anything that inherits
    // class will be able to access object
    protected WebDriver driver;
    protected Actions actions;

    public BasePageToInheritFrom(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        actions = new Actions(driver);
    }
    // validation method
    public abstract void validatePageHasAppeared();
}
