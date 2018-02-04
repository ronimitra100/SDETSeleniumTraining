package smoketests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PageTitleJUnit {
	WebDriver driver;
	String webURL="http://sdettraining.com/trguitransactions/AccountManagement.aspx";
	
	@Test
	public void pageTitleTest() {
		System.out.println("Running the test.");
		
		driver.get(webURL);
		String actualTitle=driver.getTitle();
		String expectedTitle="SDET Training | Account Management";
		Assert.assertEquals(expectedTitle, actualTitle);
		
	}
	
	@Test
	public void pageTitleTest2() {
		System.out.println("Running the test 2.");
		
		driver.get(webURL);
		String actualTitle=driver.getTitle();
		String expectedTitle="SDET Training | Account Management";
		Assert.assertEquals(expectedTitle, actualTitle);
		
	}
	
	@Before
	public void setUp() {
		System.out.println("Setting up the test.");
		System.out.println("Initializing the driver");
		driver = utilities.DriverFactory.open("chrome");
	}
	
	@After
	public void tearDown() {
		System.out.println("Closing the test.");
		System.out.println("Closing the driver");
		driver.close();
	}

}
