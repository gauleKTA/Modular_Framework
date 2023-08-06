package in.co.mercuryTravel.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MercuryTravelTestCases extends BaseTest {
	@Test
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

		AssertJUnit.assertEquals(Actual, Expected);
		extentTest.log(Status.INFO, "User Login Successful");

	}

}
