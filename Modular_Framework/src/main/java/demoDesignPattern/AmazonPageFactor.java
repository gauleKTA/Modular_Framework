package demoDesignPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.implementations.CommonDriver;
import commonLibs.implementations.CommonElement;
import commonLibs.implementations.DropdownControl;

public class AmazonPageFactor {
	// Define the WebElement that we going to use.
	//Use @FindBy annotation and define the location
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBox;
	@FindBy(id="searchDropdownBox")
	private WebElement searchCatagory;
	@FindBy(id="nav-search-submit-button")
	private WebElement searchButton;
	//Above definition is just declaration so now we have to initialize them.
	//For that selenium provides class called PageFactory
	// Initializing classes that we are going to use from Implementation package
	private CommonElement elementControl;
	private DropdownControl dropdownControl;

	public AmazonPageFactor(WebDriver driver) {
		// We will get the driver instances from CommonDriver
		// Initialize all the WebElements.
		//Commenting the following part to get the picture of Diff between POM and Page Factor
		//searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		//searchCatagory = driver.findElement(By.id("searchDropdownBox"));
		//searchButton = driver.findElement(By.id("nav-search-submit-button"));
		
		
		//Above definition is just declaration so now we have to initialize them.
		//For that selenium provides class called PageFactory
		//Since we only have one page in this class that's why we have page name as this otherwise we have to give page name
		PageFactory.initElements(driver, this);
		elementControl = new CommonElement();
		dropdownControl = new DropdownControl();

	}

	public void searchProduct(String product, String catagory) throws Exception {
		// Now we will perform all the actions using different classes from
		// Implementations packages
		// We have to initialize those classes before we use them
		elementControl.setText(searchBox, product);// Passing the product name to the search box
		dropdownControl.selectViaVisibleText(searchCatagory, catagory);// Selecting the
		elementControl.clickElement(searchButton);// Click to search

	}

}
