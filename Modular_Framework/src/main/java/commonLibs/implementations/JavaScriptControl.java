package commonLibs.implementations;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IJavaScript;

public class JavaScriptControl implements IJavaScript {
	private JavascriptExecutor jsEngine;

	public JavaScriptControl(WebDriver driver) {
		jsEngine = (JavascriptExecutor) driver;
	}

	public void executeJavaScript(String scriptToExecute) throws Exception {
		jsEngine.executeScript(scriptToExecute);

	}

	public void scrollDown(int x, int y) throws Exception {
		String jsCommand = String.format("window.scroll(%d,%d)", x, y);
		jsEngine.executeScript(jsCommand);

	}

	public String executeJavaScriptWithReturnValue(String scriptToExecute) throws Exception {
		// For this, it will be same as executejavaScript method but it is returning as
		// object. So we need to convert that as String
		return jsEngine.executeScript(scriptToExecute).toString();
	}

}
