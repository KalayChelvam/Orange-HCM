package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import components.AbstractComp;
import utils.ConfigReader;

public class LoginPage extends AbstractComp{
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "txtUsername")
	WebElement userName;
	
	@FindBy(id = "txtPassword")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginSubmit;
	
	public LoginPage enterUsername() {
		userName.sendKeys(ConfigReader.getProperty("username"));
		return this;
	}
	
	public LoginPage enterPassword() {
		password.sendKeys(ConfigReader.getProperty("password"));
		return this;
	}
	
	public DashBoardPage loginSubmitButton() {
		loginSubmit.click();
		return new DashBoardPage();
	}

}
