package demoDesignPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonLibs.implementations.CommonDriver;
import commonLibs.implementations.CommonElement;
import commonLibs.implementations.DropdownControl;

public class AmazonPOM {
//Define the WebElement that we going to use.
	private WebElement searchBox;
	private WebElement searchCatagory;
	private WebElement searchButton;
//Initializing classes that we are going to use from Implementation package
	private CommonElement elementControl;
	private DropdownControl dropdownControl;
	//private WebDriver driver;

	public AmazonPOM(WebDriver driver) {
		// We will get the driver instances from CommonDriver
		// Initialize all the WebElements.
		//this.driver = driver;
		searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchCatagory = driver.findElement(By.id("searchDropdownBox"));
		searchButton = driver.findElement(By.id("nav-search-submit-button"));
		elementControl = new CommonElement();
		dropdownControl = new DropdownControl();

	}

	
	public void searchProduct(String product, String catagory) throws Exception {
		// Now we will perform all the actions using different classes from
		// Implementations packages
		// We have to initialize those classes before we use them
		elementControl.setText(searchBox, product);// Passing the product name to the search box
		dropdownControl.selectViaVisibleText(searchCatagory, catagory);// Selecting the
		elementControl.clickElement(searchButton);//Click to search

	}

}
