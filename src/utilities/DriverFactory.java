package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	static WebDriver driver;
	public static WebDriver open(String browserType) {
		if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\ronim_000\\Desktop\\Selenium3\\chromedriver.exe");
			System.out.println("Using Chrome");
			driver= new ChromeDriver();
		}
		else if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\ronim_000\\Desktop\\Selenium3\\geckodriver.exe");
			System.out.println("Using Firefox");
			driver= new FirefoxDriver();
		}
		else if (browserType.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver","C:\\Users\\ronim_000\\Desktop\\Selenium3\\IEDriverServer.exe");
			System.out.println("Using Internet Explorer");
			driver= new InternetExplorerDriver();
		}
		else {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\ronim_000\\Desktop\\Selenium3\\chromedriver.exe");
			System.out.println("Using Chrome");
			driver= new ChromeDriver();
		}
		return driver;
	}
}
