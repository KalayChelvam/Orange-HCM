package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	public static ExtentReports extent;
	
	public static ExtentReports extentReportBase() {
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./report/ExtentReport.html");
		extent = new ExtentReports();
		
		spark.config().setDocumentTitle("Automation Test Results");
		spark.config().setReportName("Orange Test Results");
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Kalaychelvam");
		return extent;
	}

}
