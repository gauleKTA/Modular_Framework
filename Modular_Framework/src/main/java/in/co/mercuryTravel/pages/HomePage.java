package in.co.mercuryTravel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.utils.WaitUtils;

public class HomePage extends BasePage {
	@FindBy(linkText = "International Holidays")
	private WebElement internationalHoildays;
	@FindBy(linkText = "Indian Holidays")
	private WebElement indianHolidays;
	@FindBy(linkText = "Luxury Rails")
	private WebElement luxuryRails;
	@FindBy(linkText = "Preferred Holidays")
	private WebElement preferredHolidays;
	@FindBy(linkText = "Mice")
	private WebElement mice;
	@FindBy(linkText = "Flights")
	private WebElement flights;
	@FindBy(linkText = "Hotels")
	private WebElement hotels;
	@FindBy(partialLinkText = "Customer Login")
	private WebElement customerLogin;
	@FindBy(linkText = "User Login")
	private WebElement userLogin;
	@FindBy(id = "sign_user_email")
	private WebElement userEmail;
	@FindBy(id = "sign_user_password")
	private WebElement userPassword;
	@FindBy(xpath = "//button[text()='Log in']")
	private WebElement logInButton;

	@FindBy(linkText = "Register")
	private WebElement register;

	@FindBy(id = "acc_first_name")
	private WebElement firstName;
	@FindBy(id = "acc_last_name")
	private WebElement lastName;
	@FindBy(id = "acc_user_email")
	private WebElement emailAddress;

	@FindBy(id = "acc_user_password")
	private WebElement setPassword;

	@FindBy(id = "acc_user_passconf")
	private WebElement confirmPassword;
	@FindBy(xpath = "//select[@name='countrycode']")
	private WebElement phoneCode;
	@FindBy(id = "acc_mobile_no")
	private WebElement mobileNumber;
	@FindBy(xpath = "//button[text()='Register']")
	private WebElement registerButton;
	@FindBy(partialLinkText = "Welcome,")
	private WebElement welcome;
	@FindBy (partialLinkText = "Log Out")
	private WebElement logoutLink;
	// private WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void customerLoginPage(String username, String password) throws Exception {
		WaitUtils.waitFewSeconds(3);

		mouseControl.moveToElement(customerLogin);

		mouseControl.moveToElementAndClick(userLogin);
		WaitUtils.waitFewSeconds(3);

		commonElement.setText(userEmail, username);
		WaitUtils.waitFewSeconds(3);

		commonElement.setText(userPassword, password);
		commonElement.clickElement(logInButton);
	}

	public void registerNewAccount(String fName, String lName, String email, String password, String reentrPassword,
			int code, String phoneNumber) throws Exception {
		mouseControl.moveToElement(customerLogin);
		mouseControl.moveToElementAndClick(register);
		commonElement.setText(firstName, fName);
		commonElement.setText(lastName, lName);
		commonElement.setText(emailAddress, email);
		commonElement.setText(setPassword, password);
		commonElement.setText(confirmPassword, reentrPassword);
		dropdownControl.selectViaIndex(phoneCode, code);
		commonElement.setText(mobileNumber, phoneNumber);
		commonElement.clickElement(registerButton);
	}

	public String loginVerification() throws Exception {
		return commonElement.getText(welcome);
	}
	public void logOut() throws Exception{
		mouseControl.moveToElement(welcome);
		mouseControl.moveToElementAndClick(logoutLink);
	}
}
