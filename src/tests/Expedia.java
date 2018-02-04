package tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Expedia {
	WebDriver driver;
	String browserType = "Firefox";
	String city="New York, NY";
	String checkIn="01/19/2018";
	String checkOut="01/26/2018";
	String numOfGuests="2";
	String starRating="star4";
	String searchResult="3";
	
	@Test
	public void hotelReservation() {
		//1.Search.
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.id("tab-hotel-tab-hp")).click();
		driver.findElement(By.id("hotel-destination-hp-hotel")).clear();
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
		driver.findElement(By.id("hotel-checkin-hp-hotel")).clear();
		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkIn);
		driver.findElement(By.id("hotel-checkout-hp-hotel")).clear();
		driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOut);
		new Select(driver.findElement(By.xpath("//select[contains(@class,'gcw-guests-field')]"))).selectByValue(numOfGuests);
		driver.findElement(By.cssSelector("button[data-gcw-change-submit-text='Search']")).click();
		
		
		
		//2.Modify the search results page, give criteria.
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Print the name of the city.
		String actualCity= driver.findElement(By.id("hotelResultTitle")).getText();
		System.out.println("CITY :" + actualCity);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 250)", "");
		//driver.findElement(By.xpath("//input[@id='" + starRating + "']")).click();
		
		
		
	
		
		//3.Analyze the results and make our selection.
		js.executeScript("window.scrollBy(0, 700)", "");
		driver.findElement(By.xpath("(//a[@class='flex-link'])["+searchResult+"]")).click();
		
		//Switch window to the popup
		driver.navigate().refresh();
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		//Print hotel name and star rating
		js.executeScript("window.scrollBy(0, 200)", "");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String hotelName = driver.findElement(By.cssSelector("#hotel-name")).getText();
	
		boolean isHotelRated = (driver.findElements(By.cssSelector(".rating-number")).size()!=0);
		
		String hotelRating ="";
		if (isHotelRated) {
			hotelRating= driver.findElement(By.cssSelector(".rating-number")).getText();
		}
		
		System.out.println("HOTEL NAME: " + hotelName);
		System.out.println("HOTEL RATING: " + hotelRating);
		
		//4.Book reservation.
		js.executeScript("window.scrollBy(0, 600)", "");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//div[@class='book-button-wrapper'])[1]/button")).click();
		
		//5.Fill out contact / billing.
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String hotelPrice = driver.findElement(By.xpath("//span[@class='payment-option-price']")).getText();
		System.out.println("PRICE: " + hotelPrice);
		WebElement payNowButton = driver.findElement(By.cssSelector("button#pay-now-button"));
		js.executeScript("arguments[0].click();", payNowButton);
		
		//6.Get confirmation.
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.navigate().refresh();
		String pageTitle = driver.getTitle();
		System.out.println("PAGE TITLE : " + pageTitle);
		Assert.assertTrue(pageTitle.contains("Payment"));
		/*ArrayList<String> windows2 = new ArrayList<String>(driver.getWindowHandles());
		
		Iterator<String> it = windows2.iterator();
		while (it.hasNext()) {
			System.out.println("Window title: " + it.next());
		}
		String pageTitle = driver.getTitle();
		System.out.println("PAGE TITLE : " + pageTitle);
		
		String currentWindow=driver.getWindowHandle();
		for (String w : windows2) {
			
			String windowTitle = driver.switchTo().window(w).getCurrentUrl();
			System.out.println("Window title: " + windowTitle);
			driver.switchTo().window(currentWindow);*/
		}
		
		
	
	
	@BeforeMethod
	public void setUp() {
		driver = utilities.DriverFactory.open(browserType);
		driver.get("https://www.expedia.com");
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

}
