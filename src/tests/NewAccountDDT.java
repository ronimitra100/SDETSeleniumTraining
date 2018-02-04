package tests;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@RunWith(value=Parameterized.class)
public class NewAccountDDT {
	
	String name, email, phone, gender, password, country;
	boolean weeklyEmail, monthlyEmail, occassionalEmail;
	WebElement nameElement, emailElement, phoneElement, passwordElement,verifyPasswordElement, countryElement, maleRadio, femaleRadio, weeklyCheckbox, monthlyCheckbox, occassionalCheckbox,submitButton;
	WebDriver driver;

	@Test
	public void newAccountTest() {
		System.out.println("NEW RECORD: " + name + " "+ email+ " " +
	phone+ " "+gender+ " "+password+ " "+country + " "+weeklyEmail+ " " + monthlyEmail + " " + occassionalEmail);
				
		defineElements();
				//3.1:Fill out the text boxes
				nameElement.sendKeys(name);
				emailElement.sendKeys(email);
				phoneElement.sendKeys(phone);
				passwordElement.sendKeys(password);
				verifyPasswordElement.sendKeys(password);
				
				//3.2: Select radio buttons
				if (gender.equals("Male")) {
					maleRadio.click();
				}
				else {
					femaleRadio.click();
				}
				
				//3.3: Select option in dropdown list.
				new Select(countryElement).selectByVisibleText(country);
				
				//3.4: Select a checkbox
				if (weeklyEmail) {
					if (!weeklyCheckbox.isSelected()) {
						weeklyCheckbox.click();
					}
				}
				weeklyCheckbox.click();
				
				//3.5: Click "Submit" button.
				submitButton.click();
				
				
				//4.Get confirmation.
				String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
				System.out.println("CONFIRMATION: " + conf);
				
		
	}
	
	//This annotated method is deigned to pass parameters to the class using a constructor
	@Parameters
	public static List<String[]> getData(){
		return utilities.CSV.get("C:\\Users\\ronim_000\\Documents\\UserAccounts.csv");
		
	}
	
	//Constructor that passes parameters to the test method
	public NewAccountDDT(String name, String email, String phone, String gender,String password,
			String country, String weeklyEmail, String monthlyEmail, String occassionalEmail){
		this.name=name;
		this.email=email;
		this.phone=phone;
		this.gender=gender;
		this.password=password;
		this.country=country;
		
		if(weeklyEmail.equals("TRUE")) {
			this.weeklyEmail=true;
		}
		else {
			this.weeklyEmail=false;
		}
		
		
		if(monthlyEmail.equals("TRUE")) {
			this.monthlyEmail=true;
		}
		else {
			this.monthlyEmail=false;
		}
		
		if(occassionalEmail.equals("TRUE")) {
			this.occassionalEmail=true;
		}
		else {
			this.occassionalEmail=false;
		}
		
	}
	
	@Before
	public void SetUp() {
		driver = utilities.DriverFactory.open("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.xpath("//a[contains(@class,'btn-default')]")).click();	
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	
	public void defineElements() {
		nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		phoneElement = driver.findElement(By.xpath("//*[@id='MainContent_txtHomePhone']"));
		passwordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']"));
		verifyPasswordElement = driver.findElement(By.id("MainContent_txtVerifyPassword"));
		maleRadio = driver.findElement(By.id("MainContent_Male"));
		femaleRadio = driver.findElement(By.id("MainContent_Female"));
		countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		weeklyCheckbox = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
		monthlyCheckbox = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
		occassionalCheckbox = driver.findElement(By.id("MainContent_checkUpdates"));
		submitButton = driver.findElement(By.cssSelector("input[value='Submit']"));
		}
	

}
