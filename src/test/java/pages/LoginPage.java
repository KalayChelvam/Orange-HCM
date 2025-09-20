package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import components.AbstractComp;

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
	WebElement passWord;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginSubmit;
	
	public LoginPage enterUsername(String username) {
		userName.sendKeys(username);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		passWord.sendKeys(password);
		return this;
	}
	
	public DashBoardPage loginSubmitButton() {
		loginSubmit.click();
		return new DashBoardPage();
	}

}
