package demos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import utilities.DriverFactory;

public class NewAccount {
	public static void main(String[] args) {
		String name="Mary Smith";
		String email="ms@testemail.com";
		String password="mspass";
		String country ="Germany";
		String phoneNumber="1231231234";
		String browserType="ie";
		WebDriver driver = null;
		
		String gender;
		String weeklyEmail;
		String monthlyEmail;
		String occasionalEmail;
		
		
		//1.Define WebDriver.
		driver = utilities.DriverFactory.open("chrome");
		
		//2.Navigate to Account Management Page >> Click on "Create Account".
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.xpath("//a[contains(@class,'btn-default')]")).click();
		
		//3.Fill out the form.
		
		//3.1:Fill out the text boxes
		driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys(name);
		driver.findElement(By.id("MainContent_txtEmail")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id='MainContent_txtHomePhone']")).sendKeys(phoneNumber);
		driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']")).sendKeys(password);
		driver.findElement(By.id("MainContent_txtVerifyPassword")).sendKeys(password);
		
		//3.2: Select radio buttons
		driver.findElement(By.id("MainContent_Female")).click();
		
		//3.3: Select option in dropdown list.
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText(country);
		
		//3.4: Select a checkbox
		driver.findElement(By.id("MainContent_checkWeeklyEmail")).click();
		
		//3.5: Click "Submit" button.
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		
		
		//4.Get confirmation.
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		System.out.println("CONFIRMATION: " + conf);
		
		//5.Close the browser.
		driver.quit();
	}

}
