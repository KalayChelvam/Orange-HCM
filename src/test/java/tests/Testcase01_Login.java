package tests;

import java.util.HashMap;

import org.testng.annotations.Test;

import base.BaseTestCases;
import pages.LoginPage;

public class Testcase01_Login extends BaseTestCases{
	
	@Test(dataProvider = "getData", enabled = false)
	public void loginTestcase(HashMap<String, String> input){
				
		LoginPage login = new LoginPage(driver);
		System.out.println(input.get("username"));
		System.out.println(input.get("password"));
		login.enterUsername(input.get("username"))
		.enterPassword(input.get("password"))
		.loginSubmitButton();
		
		
	}

}
