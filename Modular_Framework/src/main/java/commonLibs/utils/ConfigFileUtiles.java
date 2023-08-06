package commonLibs.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileUtiles {
//Creating one static method with return type Properties
//This method will return the properties of file that we pass
	public static Properties readProperties(String fileName) throws Exception {
		// First trim the file name
		fileName = fileName.trim();
//To read anything from file in JAVA, we have InputStream
		//FileInputStream will read the data from fileName and will provide stream of data to fileReader
		InputStream fileReader = new FileInputStream(fileName);
		//JAVA provides one class called Properties
		Properties property = new Properties();
		property.load(fileReader);//Read the stream value and load the key values in property object
		return property;

	}
}
