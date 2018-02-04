package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	WebDriver driver;
	
	//Define Web Elements at class level.
	@FindBy(id="MainContent_txtUserName")
	WebElement usernameBox;
	
	@FindBy(id="MainContent_txtPassword")
	WebElement passwordBox;
	
	@FindBy(id="MainContent_btnLogin")
	WebElement loginButton;
	
	//Steps
	public void setUserName(String username) {
		usernameBox.sendKeys(username);		
	}
	
	public void setPassword(String password) {
		passwordBox.sendKeys(password);
	}
	
	public void clickSubmit() {
		loginButton.click();
	}
	
	//Actions
	public void login(String username, String password) {
		setUserName(username);
		setPassword(password);	
		clickSubmit();
	}
	
	//Constructor to initialize the state of the driver
	public LoginPageFactory(WebDriver driver) {
		this.driver=driver;
		//Initialize web elements
		PageFactory.initElements(driver, this);
	}

}
