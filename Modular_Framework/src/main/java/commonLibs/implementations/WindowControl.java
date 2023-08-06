package commonLibs.implementations;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IWindow;

public class WindowControl implements IWindow {
	private WebDriver driver;

	public WindowControl() {
		this.driver = driver;
	}

	public void switchToAnyWindow(String windowhandle) throws Exception {
		driver.switchTo().window(windowhandle);

	}

	public void switchToAnyWindow(int chidWindowIndex) throws Exception {
		// First get the window handle of of child window before we switch
		// Create new string and call .getWindowHandles which will return set of Strings
		// of all the unique values
		// Convert that value to an Array and go to childWindowIndex and convert it to
		// String.
		String childWindowHandle = driver.getWindowHandles().toArray()[chidWindowIndex].toString();

		driver.switchTo().window(childWindowHandle);

	}

	public String getWindowhandle() throws Exception {

		return driver.getWindowHandle();
	}

	public Set<String> getWindowHandels() throws Exception {
		// TODO Auto-generated method stub
		return driver.getWindowHandles();
	}

}
