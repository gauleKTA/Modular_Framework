package in.co.mercuryTravel.tests;

import java.util.Properties;

import org.asynchttpclient.config.AsyncHttpClientConfigHelper.Config;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonLibs.implementations.CommonDriver;
import commonLibs.implementations.ScreenshotControl;
import commonLibs.utils.ConfigFileUtiles;
import commonLibs.utils.DateUtils;
import in.co.mercuryTravel.pages.HomePage;

public class BaseTest {
//It will consist all the test cases that will be repeated
//Eg:Invoking Browser, closing browser
	CommonDriver cmnDriver;
	HomePage homePage;
	private WebDriver driver;
	private String browsertype;
	private int elementDetationtimeOut;
	private int pageLoadtimeOut;
	private String baaseURL;
	static String currentWorkingDirectory;
	static String executionStartDate;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest extentTest;// Variable for testcase
	String screenshotFileName;
	ScreenshotControl screenshotControl;
	static String reportFileName;
	static String configFileName;// = "config.properties";
	static Properties configProperties;
	// static block is a block that execute as a first thing the class.
	static {
		try {
			currentWorkingDirectory = System.getProperty("user.dir");
			executionStartDate = DateUtils.getCurrentDateAndTime();
			configFileName = String.format("%s/config/config.properties", currentWorkingDirectory);
			configProperties = ConfigFileUtiles.readProperties(configFileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public void preSetup() {
		// Finding the location of the file
		// If we don't mention second %s then it will overwrite in the same file.
		// We want the report when it was created.
		reportFileName = String.format("%s/reports/MercuryTravelsReport-%s.html", currentWorkingDirectory,
				executionStartDate);
		htmlReporter = new ExtentHtmlReporter(reportFileName);// Have to pass the file name.
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	@BeforeClass
	public void setup() throws Exception {
		extentTest = extent.createTest("Setup - pre-requist to start the automation test");
		browsertype = configProperties.getProperty("browserType");
		extentTest.log(Status.INFO, "Browser invoked is " + browsertype);// Storing the logs of test cases.
		cmnDriver = new CommonDriver(browsertype);
		// configProperties.getProperty() will always return String value so we need to
		// user
		// Integer.parseInt(value) to convert it into int
		pageLoadtimeOut = Integer.parseInt(configProperties.getProperty("pageLoadTimeOut"));
		extentTest.log(Status.INFO, "Page Load Time Out is " + pageLoadtimeOut);

		cmnDriver.setPageloadTimeout(pageLoadtimeOut);
		elementDetationtimeOut = Integer.parseInt(configProperties.getProperty("elementDetationTimeOut"));
		extentTest.log(Status.INFO, "Element Detaction Time Out is " + elementDetationtimeOut);

		cmnDriver.setElementDetectionTimeout(elementDetationtimeOut);
		baaseURL = configProperties.getProperty("baseURL");
		extentTest.log(Status.INFO, "Invoked URL is " + baaseURL);

		cmnDriver.navigateToFirstUrl(baaseURL);
		driver = cmnDriver.getDriver();
		// Only initialize after url
		homePage = new HomePage(driver);
		screenshotControl = new ScreenshotControl(driver);

	}

	@AfterClass
	public void cleanup() throws Exception {
		extentTest = extent.createTest("Cleanup - Clean Up Process");
		cmnDriver.closeAllBrowser();
		extentTest.log(Status.INFO, "Closing all the browser instances ");

	}

	@AfterSuite
	public void postCleanup() {
		extent.flush();// This is required after running the ExtentTest

	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {
		// Create the name of testcase
		String testcaseName = result.getTestName();
		String screenshotFileName = String.format("%s/screenshots/%s-%s.jpeg", currentWorkingDirectory, testcaseName,
				executionStartDate);

		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "Test case PASS no. " + testcaseName);
		} else if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, "Test case FAIL no. " + testcaseName);
			screenshotControl.captureAndSaveScreenshot(screenshotFileName);
			extentTest.addScreenCaptureFromPath(screenshotFileName);
		} else {
			extentTest.log(Status.SKIP, "Test case SKIPPED no. " + testcaseName);
		}
	}
}
