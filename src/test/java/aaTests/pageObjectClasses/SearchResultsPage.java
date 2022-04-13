package aaTests.pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.text.DateFormatSymbols;
import java.time.LocalDate;

public class SearchResultsPage extends BasePageToInheritFrom {

	@FindBy(xpath = "//h1[@id='aa-pageTitle' and contains(text(), 'Choose flights')]")
	WebElement searchResultsPageHeader;
	String searchResultsPageHeaderXPath = "//h1[@id='aa-pageTitle' and contains(text(), 'Choose flights')]";

	@FindBy(xpath = "//div[@id = 'flight-summary']/h3")
	WebElement dateOfDepartAndArrival;
	String dateOfDepartAndArrivalXPath = "//div[@id = 'flight-summary']/h3";

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}

	public void validatePageHasAppeared() {
		Assert.assertTrue(exceptionHandling.isDisplayedEnhanced(searchResultsPageHeaderXPath, 60, driver));
	}

	public void validateCorrectDepartDate(int expectedMonthAsInt, int expectedDateAsInt, int expectedYearAsInt){
		//convert month int to month String
		String expectedMonthAsString = new DateFormatSymbols().getMonths()[expectedMonthAsInt-1];

		String[] splitUpDateString = dateOfDepartAndArrival.getText().replaceAll(" ", "").split(",");
		LocalDate dateOfDep = LocalDate.of(expectedYearAsInt, expectedMonthAsInt, expectedDateAsInt);
		String dayOfDeptAsString = dateOfDep.getDayOfWeek().toString();

		Assert.assertTrue(
				splitUpDateString[1].contains(expectedMonthAsString)
						&& splitUpDateString[1].contains(Integer.toString(expectedDateAsInt))
						&& splitUpDateString[2].equals(Integer.toString(expectedYearAsInt))
						&& splitUpDateString[0].equalsIgnoreCase(dayOfDeptAsString));
	}
}
