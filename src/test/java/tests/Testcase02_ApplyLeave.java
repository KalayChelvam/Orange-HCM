package tests;

import java.util.HashMap;

import org.testng.annotations.Test;

import base.BaseTestCases;
import pages.LeavePage;
import pages.LoginPage;

public class Testcase02_ApplyLeave extends BaseTestCases{
	
	@Test(dataProvider = "getData")
	public void applyLeave(HashMap<String, String> input) {
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(input.get("username"))
		.enterPassword(input.get("password"))
		.loginSubmitButton();
		LeavePage applyLeave = new LeavePage(driver);
		applyLeave.clickOnLeftMenuLeave()
		.clickOnTopMenuApplyLeave()
		.selectTheLeaveTypeGoingToApply(input.get("leaveOption"))
		.clickOnFromDateCalendarIcon()
		.clickOnFromMonthInsideCalendar()
		.selectFromMonthToApplyLeave(input.get("fromMonthValue"))
		.selectFromDateToApplyLeave(input.get("fromDateValue"))
		.clickOnToDateCalendarIcon()
		.clickOnToMonthInsideCalendar()
		.selectToMonthToApplyLeave(input.get("toMonthValue"))
		.selectToDateToApplyLeave(input.get("toDateValue"))
		.selectPartialDaysAny(input.get("partialDaySelection"))
		.selectLeaveStartDay()
		.addCommentForLeave(input.get("leaveComment"))
		.leaveSubmit();
		
	}


}
