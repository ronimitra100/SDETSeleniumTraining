package smoketests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LoginElementsPresentTestNG {
	WebDriver driver;
	
	@Test
	public void loginElementsPresentTest() {
		System.out.println("Running test.");
		boolean isCreateAccountPresent = false;
		
		boolean loginEmailText = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
		boolean passwordText = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();
		
		Assert.assertTrue(loginEmailText, "Email textbox present");
		Assert.assertTrue(passwordText,"Password textbox present");
		
		List <WebElement> aElements = driver.findElements(By.tagName("a"));
		int aNumOfAElements = aElements.size();
		System.out.println("There are " + aNumOfAElements + " a tags on the page");
		for (WebElement aElement:aElements) {
			System.out.println(aElement.getText());
			if (aElement.getText().equals("CREATE ACCOUNT")) {
				isCreateAccountPresent = true;
			}
		}
		Assert.assertTrue(isCreateAccountPresent);
	}
	
	@BeforeTest
	public void setUp() {
		System.out.println("Starting test.");
		driver = utilities.DriverFactory.open("chrome");
		String webUrl="http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		driver.get(webUrl);
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("Closing test.");
		driver.close();
	}
	

}
