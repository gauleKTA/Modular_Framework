package demoDesignPattern;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import demoDesignPattern.AmazonPOM;
import commonLibs.implementations.CommonDriver;

public class AmazonHomePagePageFactorTest {
	


	
		CommonDriver cmnDriver;
		AmazonPageFactor amazonPageFactor;
		String currentURL="https://www.amazon.com/";
		WebDriver driver;
		@BeforeClass
	public void invokeBrowser() throws Exception{
			cmnDriver = new CommonDriver("chrome");
			cmnDriver.setPageloadTimeout(60);//Calling these methods that is present in CommonDriver class already defined
			cmnDriver.setElementDetectionTimeout(10);
			cmnDriver.navigateToFirstUrl(currentURL);
			driver=cmnDriver.getDriver();
			amazonPageFactor = new AmazonPageFactor(driver);
	}
		
		@Test
		public void searchProduct() throws Exception {
			String product ="Iphone";
			String catagory ="Electronics";
			amazonPageFactor.searchProduct(product, catagory);
			
		}
		
		@AfterClass
	public void closeBrowser() throws Exception{
			cmnDriver.closeAllBrowser();
		
	}
	}


