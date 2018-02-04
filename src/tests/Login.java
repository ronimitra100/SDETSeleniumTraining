package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;

public class Login {
	
	@Test
	public void loginTestPOM() {

		//1. Initialize driver.
		WebDriver driver = utilities.DriverFactory.open("Chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		//2. Enter login information.
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName("tim@testemail.com");
		loginPage.setPassword("trpass");
		loginPage.clickSubmit();
		
		//3. Get confirmation (Dashboard page).
		DashboardPage dashboardPage = new DashboardPage(driver);
		String conf = dashboardPage.confirmationMessage();
		
		//4. Assertions
		Assert.assertEquals(conf, "Logged in successfully");
		String pageTitle = dashboardPage.pageTitle();
		Assert.assertTrue(pageTitle.contains("Account"));
		
		//5. Close the driver.
		driver.quit();
		
	}
	

}
