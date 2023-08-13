package utils;

import org.testng.annotations.DataProvider;

import commonLibs.utils.ExcelDriver;

public class TestDataProvider {
	@DataProvider
	public Object[][] getUserData() throws Exception{
		String currentWorkingDirectory=System.getProperty("user.dir");
		
		String workBookName=currentWorkingDirectory + "/testDataInputFiles/exceWorkbook.xlsx";
		String sheetname="TestData";
		ExcelDriver excelDriver = new ExcelDriver();
		Object[][] data;
		excelDriver.openWorkbook(workBookName);
		int rowCount = excelDriver.getRowCount(sheetname);
		int cellCount = excelDriver.getCellCountFromARow(sheetname, 0);
		data = new Object[rowCount + 1][cellCount];
		for (int row = 0; row<=rowCount; row++) {
			for (int cell = 0; cell<cellCount; cell++) {
				data[row][cell]=excelDriver.getCellData(sheetname, row, cell);
			}
		}
		return data;
	}

}
