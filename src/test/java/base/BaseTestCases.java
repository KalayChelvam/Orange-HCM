package base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import utils.ConfigReader;
import utils.DataReader;

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
	
	@DataProvider(name = "getData")
	public Object[][] getData(Method method) throws IOException {
		
		String filePath = System.getProperty("user.dir")+"//src//test//java//resources//TestData.json";
		
		Map<String, List<HashMap<String, String>>> allData = DataReader.readJson(filePath);
		
		String testName = method.getName();
		List<HashMap<String, String>> testData = allData.get(testName);
		
		Object[][] data = new Object[testData.size()][1];
		for(int i =0; i < testData.size(); i++) {
			data[i][0] = testData.get(i);
		}
		return data;
	}


}
