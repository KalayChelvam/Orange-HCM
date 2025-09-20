package tests;

import org.testng.annotations.Test;

import base.BaseTestCases;
import pages.LeavePage;
import pages.LoginPage;

public class Testcase02_ApplyLeave extends BaseTestCases{
	
	@Test
	public void applyLeave() {
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername()
		.enterPassword()
		.loginSubmitButton();
		LeavePage applyLeave = new LeavePage(driver);
		applyLeave.clickOnLeftMenuLeave()
		.clickOnTopMenuApplyLeave()
		.selectTheLeaveTypeGoingToApply()
		.clickOnFromDateCalendarIcon()
		.clickOnFromMonthInsideCalendar()
		.selectFromMonthToApplyLeave()
		.selectFromDateToApplyLeave()
		.clickOnToDateCalendarIcon()
		.clickOnToMonthInsideCalendar()
		.selectToMonthToApplyLeave()
		.selectToDateToApplyLeave()
		.selectPartialDaysAny()
		.selectLeaveStartDay()
		.addCommentForLeave()
		.leaveSubmit();
		
	}


}
