package tests;

import org.testng.annotations.Test;

import base.BaseTestCases;
import pages.LoginPage;

public class Testcase01_Login extends BaseTestCases{
	
	@Test
	public void loginTestcase(){
				
		LoginPage login = new LoginPage(driver);
		login.enterUsername()
		.enterPassword()
		.loginSubmitButton();
		
		
	}

}
