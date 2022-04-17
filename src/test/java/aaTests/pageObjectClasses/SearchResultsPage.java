package aaTests.pageObjectClasses;

import org.openqa.selenium.By;
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

	String searchResultsPageHeaderXpath = "//h1[@id='aa-pageTitle' and contains(text(), 'Choose flights')]";
	String departureAndArrivalCitiesXpath = "//span[@class='visible-phone']";
	String firstOriginSearchResultDynamicXpath = "//div[@class='span4 span-phone6']/span[@class='flight-airport-code' and contains(text(), '%s')]";
	String firstArrivalSearchResultDynamicXpath = "//div[@class='span4 span-phone5']/span[@class='flight-airport-code' and contains(text(), '%s')]";
	String typeofTripInSearchResultsValidationDynamicXpath = "(//div[@class='triptype']['%s'])";
	String selectFareDynamicXpath = "//button[@data-farename='%s']";


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

	public void checkOriginArrivalTripType(String origin, String arrival, String tripType){

//        List<WebElement> departureAndArrivalCities  = driver.findElements(By.xpath(departureAndArrivalCitiesXpath));
		// Elements are not intractable or able to verified. Cannot get text with selenium, must use JS executor
		// Test is still valid because we see the arrival and destination in search results
//        Assert.assertTrue(departureAndArrivalCities.get(0).getText().contains(origin));
//        Assert.assertTrue(departureAndArrivalCities.get(1).getText().contains(arrival));

		Assert.assertTrue(exceptionHandling.isDisplayedEnhanced(String.format(firstOriginSearchResultDynamicXpath, origin.toUpperCase()), 5, driver));
		Assert.assertTrue(exceptionHandling.isDisplayedEnhanced(String.format(firstArrivalSearchResultDynamicXpath, arrival.toUpperCase()), 5, driver));

		StringBuilder sb = new StringBuilder(tripType.toLowerCase());

		char firstCharUpperCase =  (char) (sb.charAt(0) - 32);
		sb.deleteCharAt(0).reverse();
		sb.append(firstCharUpperCase).reverse();

		WebElement typeOfTripInSearchResultsValidation = driver.findElement(By.xpath(String.format(typeofTripInSearchResultsValidationDynamicXpath, sb)));
		Assert.assertTrue(typeOfTripInSearchResultsValidation.getText().contains(sb));
	}

	public void selectClassandFare(String classType){

		Assert.assertTrue(exceptionHandling.isDisplayedEnhanced(String.format(selectFareDynamicXpath, classType),5, driver));
		driver.findElement(By.xpath(String.format(selectFareDynamicXpath, classType))).click();
	}
}
