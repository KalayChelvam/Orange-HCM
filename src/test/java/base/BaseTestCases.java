package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ConfigReader;

public class BaseTestCases {
	
	public WebDriver driver;
	String browser;
	String url;
	
	@BeforeMethod
	public void initializeBrowser() throws IOException {
		
		ConfigReader.initializeProperty();
		browser = ConfigReader.getProperty("browser");
		url = ConfigReader.getProperty("url");
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getURL();
	}
	
	public void getURL() {
		
		driver.get(url);
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
	}


}
