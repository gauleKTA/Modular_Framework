package commonLibs.implementations;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IScreenshot;

public class ScreenshotControl implements IScreenshot {
	private TakesScreenshot camera;

	public ScreenshotControl(WebDriver driver) {
		// There is a class TakesScreenshot. Create instance of it. It helps to take
		// screenshot
		// Type cast it with driver instance
		camera = (TakesScreenshot) driver;
	}

	public void captureAndSaveScreenshot(String pathFile) throws Exception {
		// Trim pathFile
		pathFile = pathFile.trim();
		// Create file name
		File imgFile, tempFile;
		// Initialize imgFile with File and give the path
		imgFile = new File(pathFile);
		// Put a condition, if imgFile exists then throw an exception
		if (imgFile.exists()) {
			throw new Exception("Image with this file name already exists");
		}
		// It will create and output with file and store it to tempFile
		tempFile = camera.getScreenshotAs(OutputType.FILE);
		// We have replace tempFile with imgFile.
		// Use FileUtils class for that. You have to have Apache Commons IO dependencies
		// to use this class.
		// Whatever file is created in temFile, FileUtils will replace with imgFile
		FileUtils.moveFile(tempFile, imgFile);

	}

}
