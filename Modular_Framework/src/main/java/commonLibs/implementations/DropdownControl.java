package commonLibs.implementations;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import commonLibs.contracts.IDropdown;

public class DropdownControl implements IDropdown {
//Instead of creating Select interface for all the methods
//We can simply create one method in the class and call them in all the methods.
	private Select getSelect(WebElement element) {
		Select select = new Select(element);
		return select;
	}

	public void selectViaVisibleText(WebElement element, String visibleText) throws Exception {
		// For all the drop down we can use Select class. For that we need to define
		// interface first
		// Select select = new Select(element);
		getSelect(element).selectByVisibleText(visibleText);

	}

	public void selectViaValue(WebElement element, String value) throws Exception {
		getSelect(element).selectByValue(value);

	}

	public void selectViaIndex(WebElement element, int index) throws Exception {
		getSelect(element).selectByIndex(index);

	}

	

	public List<WebElement> getAllOptions(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return getSelect(element).getOptions();
	}

}
