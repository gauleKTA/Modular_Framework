package in.co.mercuryTravel.pages;

import org.openqa.selenium.WebDriver;

import commonLibs.implementations.AlertControl;
import commonLibs.implementations.CommonElement;
import commonLibs.implementations.DropdownControl;
import commonLibs.implementations.FrameControl;
import commonLibs.implementations.MouseControl;

public class BasePage {
//We will need all the classes from implementation package
//SO instead of calling them in all the classes, we are creating a base class where we will call all the classes from implementation package
protected AlertControl alertControl;
protected CommonElement commonElement;
protected DropdownControl dropdownControl;
protected FrameControl frameControl;
protected MouseControl mouseControl;
public BasePage(WebDriver driver) {
	alertControl = new AlertControl(driver);
	commonElement = new CommonElement();
	dropdownControl = new DropdownControl();
	frameControl = new FrameControl(driver);
	mouseControl = new MouseControl(driver);
}
		
	
}
