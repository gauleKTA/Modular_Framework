package Test;

import org.testng.annotations.Test;

import commonLibs.utils.ExcelDriver;
public class TestExcel {
	@Test
	public void verifyTestExcel() throws Exception{
		ExcelDriver excelDriver= new ExcelDriver();
		String excelWorkbook = System.getProperty("user.dir") + "/testDataInputFiles/exceWorkbook.xlsx";
		String sheetName="TestData";
		excelDriver.createWorkbook(excelWorkbook);
		excelDriver.openWorkbook(excelWorkbook);
		excelDriver.createSheet(sheetName);
		excelDriver.setCellData(sheetName, 0, 0, "samthapa1234@gmail.com");
		excelDriver.setCellData(sheetName, 0, 1, "SamThapa");
		excelDriver.setCellData(sheetName, 0, 2, "Welcome, Sam");
		excelDriver.setCellData(sheetName, 1, 0, "samthapa1234@gmail.com");
		excelDriver.setCellData(sheetName, 1, 1, "SamThapa");
		excelDriver.setCellData(sheetName, 1, 2, "Welcome, Sam1");
		
		excelDriver.saveFile();
		excelDriver.closeWorkbook();
	}

}
