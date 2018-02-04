package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {
	public static void main(String[] args) {
		//1.Define WebDriver.
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ronim_000\\Desktop\\Selenium3\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//2.Navigate to Account Management Page >> Click on "Create Account".
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.linkText("Create Account")).click();
		
		//3.Fill out the form.
		
		//3.1:Fill out the text boxes
		driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Mary Smith");
		driver.findElement(By.id("MainContent_txtEmail")).sendKeys("ms@testemail.com");
		driver.findElement(By.xpath("//*[@id='MainContent_txtHomePhone']")).sendKeys("1231231234");
		driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']")).sendKeys("mspass");
		driver.findElement(By.id("MainContent_txtVerifyPassword")).sendKeys("mspass");
		
		//3.2: Select radio buttons
		driver.findElement(By.id("MainContent_Female")).click();
		
		//3.3: Select option in dropdown list.
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("Canada");
		
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
