package commonLibs.implementations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import commonLibs.contracts.IDriver;

public class CommonDriver implements IDriver {
	private WebDriver driver;
	private int pageloadTimeout;
	private int elementDetectionTimeout;
	//private String currentWorkingDirectory;

	public CommonDriver(String browserType) throws Exception {
		pageloadTimeout = 60;
		elementDetectionTimeout = 10;
		//currentWorkingDirectory = System.getProperty("user.dir");
	//Created a new folder drivers in the project and inserted all the driver
	//It will reduce the problem of reentering the location of driver if code is moved to different machine
	//It will go to current directory and opens the folder drivers and get the assigned jar files.
		if (browserType.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", currentWorkingDirectory + "/drivers/chromedriver");
			System.setProperty("webdriver.chrome.driver", "/Users/santoshpradhan/Desktop/All About Java/Lips/chromedriver");

			driver = new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", currentWorkingDirectory + "/drivers/geckodriver");
			System.setProperty("webdriver.firefox.driver", "/Users/santoshpradhan/Desktop/All About Java/Lips/geckodriver");

			driver = new FirefoxDriver();
		}

		else if (browserType.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();

		} else {

			throw new Exception(browserType + " = Not a valid browser");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(pageloadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);

	}

	// Implemented getter
	public WebDriver getDriver() {
		return driver;
	}

	// Implemented setter
	public void setPageloadTimeout(int pageloadTimeout) {
		this.pageloadTimeout = pageloadTimeout;
	}

	// Implemented setter
	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}

	public void navigateToFirstUrl(String url) throws Exception {
		driver.manage().timeouts().pageLoadTimeout(pageloadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);
		url = url.trim();// Will trim any whitespace while passing the value.
		driver.get(url);

	}

	public String getTitle() throws Exception {
		String Title = driver.getTitle();
		return Title;
	}

	public String getCurrentUrl() throws Exception {
		String CurrentUrl = driver.getCurrentUrl();
		return CurrentUrl;
	}

	public String getPageSource() throws Exception {
		String PageSource = driver.getPageSource();
		return PageSource;
	}

	public void navigateToURL(String url) throws Exception {
		url = url.trim();
		driver.navigate().to(url);

	}

	public void navigateForward() throws Exception {
		driver.navigate().forward();

	}

	public void navigateBackward() throws Exception {
		driver.navigate().back();

	}

	public void refresh() throws Exception {
		driver.navigate().refresh();

	}

	public void closeBrowser() throws Exception {
		// If there is no driver passed then there is no reason to close this method
		if (driver != null) {
			driver.close();
		}

	}

	public void closeAllBrowser() throws Exception {
		// If there is no driver passed then there is no reason to close this method

		if (driver != null) {
			driver.quit();
		}

	}

}
