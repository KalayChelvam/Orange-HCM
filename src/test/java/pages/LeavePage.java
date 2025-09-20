package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import components.AbstractComp;

public class LeavePage extends AbstractComp{
	
	WebDriver driver;
	
	public LeavePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[text()='Leave'])[1]")
	WebElement leftMenuLeave;
	
	@FindBy(xpath = "//a[@data-automation-id='menu_leave_applyLeave']")
	WebElement topMenuApplyLeave;
	
	By leaveType = By.className("tile-header");
	
	@FindBy(xpath = "(//div[@class='oxd-date-input-icon-wrapper'])[1]")
	WebElement fromDataCalendarIcon;
	
	@FindBy(xpath = "//div[@class='oxd-calendar-selector-month-selected']/i")
	WebElement fromMonthClickOnCalendar;
	
	By fromMonthSelection = By.xpath("//ul[@class='oxd-calendar-dropdown']/li");
	
	By fromDateSelection = By.xpath("//div[@class='oxd-calendar-date']");
	
	@FindBy(xpath = "(//div[@class='oxd-date-input-icon-wrapper'])[2]")
	WebElement toDateCalendarIcon;
	
	By toMonthCLickOnCalendar = By.xpath("//div[@class='oxd-calendar-selector-month-selected']/i");
	
	By toMonthSelection = By.xpath("//ul[@class='oxd-calendar-dropdown']/li");
	
	By toDateSelection = By.xpath("//div[@class='oxd-calendar-date']");
	
	By partialDays = By.xpath("//div[@class='radio-pill-group']//label");
	
	By leaveStartDay = By.xpath("//div[@class='oxd-select-text--arrow']");
	
	@FindBy(id = "leave.assign_comments")
	WebElement addComments;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement leaveSubmitButton;
	
	
	
	public LeavePage clickOnLeftMenuLeave() {
		
		leftMenuLeave.click();
		return this;
	}
	

	
	public LeavePage clickOnTopMenuApplyLeave() {
		
		topMenuApplyLeave.click();
		return this;
	}
	
	public LeavePage selectTheLeaveTypeGoingToApply() {
		
		List<WebElement> listOfLeaveType = waitUntilVisibleAllElementsByLocator(leaveType);
		for(WebElement leaveTypeGoingToApply : listOfLeaveType) {
			String leaveTypeText = leaveTypeGoingToApply.getText().trim();
			if(leaveTypeText.equals("Sick Leave - US")) {
				leaveTypeGoingToApply.click();
				break;
			}
		} return this;
	}
	
	public LeavePage clickOnFromDateCalendarIcon() {
		
		waitUntilElementClickable(fromDataCalendarIcon);
		return this;
	}
	
	public LeavePage clickOnFromMonthInsideCalendar() {
		
		waitUntilElementClickable(fromMonthClickOnCalendar);
		return this;
	}
	
	public LeavePage selectFromMonthToApplyLeave() {
		
		List<WebElement> fromMonths = waitUntilVisibleAllElementsByLocator(fromMonthSelection);
		for(WebElement fromMonth : fromMonths) {
			String selectFromMonthToApplyLeave = fromMonth.getText().trim();
			if(selectFromMonthToApplyLeave.equals("October")) {
				fromMonth.click();
				break;
			}
		} return this;
	}
	
	public LeavePage selectFromDateToApplyLeave() {
		
		List<WebElement> listOfFromDate = waitUntilVisibleAllElementsByLocator(fromDateSelection);
		for(WebElement fromDate : listOfFromDate) {
			String selectFromDate = fromDate.getText().trim();
			if(selectFromDate.equals("23")) {
				fromDate.click();
				break;
			}
		} return this;
	}
	
	public LeavePage clickOnToDateCalendarIcon() {
		
		waitUntilElementClickable(toDateCalendarIcon);
		return this;
	}
	
	public LeavePage clickOnToMonthInsideCalendar() {
		
		waitUntilElementClickable(toMonthCLickOnCalendar);
		return this;
	}
	
	public LeavePage selectToMonthToApplyLeave() {
		
		List<WebElement> toMonths = waitUntilVisibleAllElementsByLocator(toMonthSelection);
		for(WebElement toMonth : toMonths) {
			String selectMonthToApplyLeave = toMonth.getText().trim();
			if(selectMonthToApplyLeave.equals("October")) {
				toMonth.click();
				break;
			}
		} return this;
	}
	
	public LeavePage selectToDateToApplyLeave() {
		
		List<WebElement> listOfToDate = waitUntilVisibleAllElementsByLocator(toDateSelection);
		for(WebElement toDate : listOfToDate) {
			String selectToDate = toDate.getText().trim();
			if(selectToDate.equals("24")) {
				toDate.click();
				break;
			}
		} return this;
	}
	
	public LeavePage selectPartialDaysAny() {
		
		List<WebElement> ifPartialDays = waitUntilVisibleAllElementsByLocator(partialDays);
		for(WebElement selectPartialDay : ifPartialDays) {
			String getTextOfPartialDay = selectPartialDay.getText().trim();
			if(getTextOfPartialDay.equals("Start Day Only")) {
				selectPartialDay.click();
				break;
			}
		} return this;
	}
	
	public LeavePage selectLeaveStartDay() {
		
		waitUntilElementClickable(leaveStartDay);
		actionDownArrow(2);
		return this;
	}
	
	public LeavePage addCommentForLeave() {
		
		addComments.sendKeys("Adding Comments on the leave applying");
		return this;
	}

	public void leaveSubmit() {
		
		leaveSubmitButton.click();
	}
	
	

}
