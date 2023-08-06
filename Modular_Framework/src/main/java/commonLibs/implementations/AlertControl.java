package commonLibs.implementations;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IAlert;
import commonLibs.utils.WaitUtils;

public class AlertControl implements IAlert {
	// We will need driver instance in alert so we can call it from CommonDriver
	// class by creating constructor of AlertControl class.
	private WebDriver driver;

	public AlertControl(WebDriver driver) {
		this.driver = driver;
	}

	// Since we have to call alert instance in all the methods so we will just
	// create one method for alert.
	private Alert getAlert() {
		return driver.switchTo().alert();
	}

	public void acceptAlert() throws Exception {
		getAlert().accept();

	}

	public void rejectAlert() throws Exception {
		getAlert().dismiss();

	}

	public String getMessageFromAlert() throws Exception {
		// TODO Auto-generated method stub
		return getAlert().getText();
	}

	public boolean checkAlertPresent(int timeoutInseconds) throws Exception {
		try {
			WaitUtils.waitTillAlertIsPresent(driver, timeoutInseconds);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
