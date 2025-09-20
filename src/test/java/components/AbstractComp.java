package components;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComp {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions action;

	public AbstractComp(WebDriver driver) {
		
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.action = new Actions(driver);
	}

	public List<WebElement> waitUntilVisibleAllElementsByLocator(By locator) {
		
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public void waitUntilElementClickable(WebElement ele) {
		
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
	}
	
	public void waitUntilElementClickable(By locator) {
		
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	public void actionDownArrow(int count) {
		
		for(int i=0; i<count; i++) {
			action.sendKeys(Keys.ARROW_DOWN).perform();
		}
		action.sendKeys(Keys.ENTER).perform();
	}

}
