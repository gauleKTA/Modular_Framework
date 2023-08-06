package commonLibs.implementations;

import org.openqa.selenium.WebElement;

import commonLibs.contracts.ICommonElement;

public class CommonElement implements ICommonElement{

	public String getText(WebElement element) throws Exception {
		
		return element.getText();
	}

	public void clickElement(WebElement element) throws Exception {
		element.click();
		
	}

	public String getAttribute(WebElement element, String attribute) throws Exception {
		// TODO Auto-generated method stub
		return element.getAttribute(attribute);
	}

	public String getCssValue(WebElement element, String csspropertyName) throws Exception {
		// TODO Auto-generated method stub
		return element.getCssValue(csspropertyName);
	}

	public boolean isElementEnabled(WebElement element) throws Exception {
		
		return element.isEnabled();
	}

	public boolean isElementVisible(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return element.isDisplayed();
	}

	public boolean isElementSelected(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return element.isSelected();
	}

	public void setText(WebElement element, String textToWrite) throws Exception {
		
		element.sendKeys(textToWrite);
	}

	public void clearText(WebElement element) throws Exception {
		element.clear();
		
	}

	public void changeCheckboxStatus(WebElement element, boolean expectedStatus) throws Exception {
	//We need to check scenario for this.
	//First when expected is true and current is false.
	//Second when expected is false and current is true.
	//Because when both the values are same, we don't need to click.
		boolean currentStatus = element.isSelected();
		if(currentStatus != expectedStatus) {
			element.click();
		}
		
	}

	public int getXLocation(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return element.getLocation().x;
	}

	public int getYLocation(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return element.getLocation().y;
	}

}
