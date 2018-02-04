package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	public static void main(String[] args) {
		//1.Define the webdriver.
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ronim_000\\Desktop\\Selenium3\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//2.Open the web browser.
		driver.get("http://sdetuniversity.com/projects/");
		driver.findElement(By.linkText("Account Management System")).click();
		//3.Enter username.
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testemail.com");
		//4.Enter password.
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");
		//5.Click "Login" button
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
		//6.Check for confirmation.
		String message = driver.findElement(By.id("conf_message")).getText();
		System.out.println("CONFIRMATION: " + message);
		String pageTitle = driver.getTitle();
			System.out.println("PAGE TITLE:" + pageTitle);
		
		//7.Close the browser.
		driver.close();
	}

}
