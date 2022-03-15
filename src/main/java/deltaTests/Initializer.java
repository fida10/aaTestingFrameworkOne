package deltaTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Initializer{

	private WebDriver driver;

	public void createChromeDriverInstance(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
	}

	public WebDriver getDriver(){
		return driver;
	}
}
