package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTestCases;
import utils.ConfigReader;

public class E2ETestCase extends BaseTestCases {
	
	@Test
	public void endToEndTestcase(){
		

		driver.findElement(By.id("txtUsername")).sendKeys(ConfigReader.getProperty("username"));
		driver.findElement(By.id("txtPassword")).sendKeys(ConfigReader.getProperty("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("(//span[text()='Leave'])[1]")).click();
		driver.findElement(By.xpath("//a[@data-automation-id='menu_leave_applyLeave']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("tile-header")));
		
		List<WebElement> listOfLeaveType = driver.findElements(By.className("tile-header"));
		for(WebElement leaveTypeGoingToApply : listOfLeaveType) {
			String leaveTypeText = leaveTypeGoingToApply.getText().trim();
			if(leaveTypeText.equals("Sick Leave - US")) {
				leaveTypeGoingToApply.click();
				break;
			}
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//div[@class='oxd-date-input-icon-wrapper'])[1]")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='oxd-calendar-selector-month-selected']/i")))).click();
		List<WebElement> fromMonths = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='oxd-calendar-dropdown']/li")));
		for(WebElement fromMonth : fromMonths) {
			String selectFromMonthToApplyLeave = fromMonth.getText().trim();
			if(selectFromMonthToApplyLeave.equals("October")) {
				fromMonth.click();
				break;
			}
		}
		
		List<WebElement> listOfFromDate = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='oxd-calendar-date']")));
		for(WebElement fromDate : listOfFromDate) {
			String selectFromDate = fromDate.getText().trim();
			if(selectFromDate.equals("23")) {
				fromDate.click();
				break;
			}
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//div[@class='oxd-date-input-icon-wrapper'])[2]")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='oxd-calendar-selector-month-selected']/i"))).click();
		List<WebElement> toMonths = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='oxd-calendar-dropdown']/li")));
		for(WebElement toMonth : toMonths) {
			String selectMonthToApplyLeave = toMonth.getText().trim();
			if(selectMonthToApplyLeave.equals("October")) {
				toMonth.click();
				break;
			}
		}
		
		List<WebElement> listOfToDate = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='oxd-calendar-date']")));
		for(WebElement toDate : listOfToDate) {
			String selectToDate = toDate.getText().trim();
			if(selectToDate.equals("24")) {
				toDate.click();
				break;
			}
		}
		
		List<WebElement> ifPartialDays = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='radio-pill-group']//label")));
		for(WebElement selectPartialDay : ifPartialDays) {
			String getTextOfPartialDay = selectPartialDay.getText().trim();
			if(getTextOfPartialDay.equals("Start Day Only")) {
				selectPartialDay.click();
				break;
			}
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='oxd-select-text--arrow']"))).click();
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		
		driver.findElement(By.id("leave.assign_comments")).sendKeys("Adding Comments on the leave applying");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

}
