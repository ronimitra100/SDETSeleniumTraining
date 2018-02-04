package stepImplementations;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BDDLoginTest {
	WebDriver driver = utilities.DriverFactory.open("Chrome");
	
	@Given("^user is on login page$")
	public void user_is_on_login_page() {
		System.out.println("User is on Login page.");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
	
	@When("^user enters correct username and correct password$")
	public void user_enters_correct_username_and_correct_password() {
		System.out.println("User enters username and password.");
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testemail.com");
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("trpass");
		driver.findElement(By.id("MainContent_btnLogin")).click();
	}
	
	@Then("^user gets confirmation$")
	public void user_gets_confirmation() {
		System.out.println("User gets confirmation.");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(By.id("conf_message")).getText().contains("success"));
	}
	
	@When("^user enters email (.*)$")
	public void user_enters_username(String username) {
		System.out.println("TESTING: " + username);
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
	}
	
	@And("^user enters password (.*)$")
	public void user_enters_password(String password) {
		System.out.println("TESTING: " + password);
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
	}
	
	@And("^user clicks login button$")
	public void user_clicks_login_button() {
		driver.findElement(By.id("MainContent_btnLogin")).click();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
