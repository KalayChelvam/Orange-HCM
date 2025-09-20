package tests;

import java.util.HashMap;

import org.testng.annotations.Test;

import base.BaseTestCases;
import pages.LoginPage;

public class Testcase01_Login extends BaseTestCases{
	
	@Test(dataProvider = "getData")
	public void loginTestcase(HashMap<String, String> input){
				
		LoginPage login = new LoginPage(driver);
		login.enterUsername(input.get("username"))
		.enterPassword(input.get("password"))
		.loginSubmitButton();
		
		
	}

}
