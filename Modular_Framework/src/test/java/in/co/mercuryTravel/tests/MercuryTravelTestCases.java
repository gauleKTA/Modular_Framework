package in.co.mercuryTravel.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import utils.TestDataProvider;

import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MercuryTravelTestCases extends BaseTest {
	@Test(enabled = true)
	public void verifyUserLoginWithCorrectCredentials() throws Exception {
		extentTest = extent.createTest("TC001 - Verifying the login process with correct credentials");
		String username = configProperties.getProperty("username");
		extentTest.log(Status.INFO, "Username passed is " + username);

		String password = configProperties.getProperty("password");
		extentTest.log(Status.INFO, "Password passed is  " + password);

		homePage.customerLoginPage(username, password);
		String Expected = configProperties.getProperty("Expected");
		extentTest.log(Status.INFO, "Expected message is " + Expected);
		String Actual = homePage.loginVerification();
		extentTest.log(Status.INFO, "Actual message is " + Actual);

		Assert.assertEquals(Actual, Expected);
		extentTest.log(Status.INFO, "User Login Successful");
		homePage.logOut();

	}
	//Tell what is the name of data provider
	//ANd where do you have that dataprovider class
	@Test(enabled = false,dataProvider="getUserData",dataProviderClass=TestDataProvider.class)
	public void verifyUserLoginWithCorrectCredentials(String username, String password, String Expected) throws Exception {
		extentTest = extent.createTest("TC001 - Verifying the login process with correct credentials");
		
		extentTest.log(Status.INFO, "Username passed is " + username);

		
		extentTest.log(Status.INFO, "Password passed is  " + password);

		homePage.customerLoginPage(username, password);
		
		
		String Actual = homePage.loginVerification();
		extentTest.log(Status.INFO, "Actual message is " + Actual);

		Assert.assertEquals(Actual, Expected);
		extentTest.log(Status.INFO, "User Login Successful");
		homePage.logOut();

	}

}
