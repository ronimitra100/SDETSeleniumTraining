package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import pages.LoginPageFactory;

public class LoginFactoryTest {
	
	@Test
	public void loginTestPageFactory() {
		
		String username="tim@testemail.com";
		String password = "trpass";

		//1. Initialize driver.
		WebDriver driver = utilities.DriverFactory.open("Chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		//2. Enter login information.
		LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
		loginPageFactory.login(username,password);
		
		//3. Close the driver.
		driver.quit();
		
	}
	

}
