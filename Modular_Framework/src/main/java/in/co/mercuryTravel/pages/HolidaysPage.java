package in.co.mercuryTravel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HolidaysPage extends BasePage{
	@FindBy (id="holiday_category_id")
	private WebElement destination;
	@FindBy (id="dphh1")
	private WebElement startDate;
	@FindBy (id="duration_d")
	private WebElement duration;
	@FindBy (id="themes")
	private WebElement typeOfHoliday;
	@FindBy (xpath = "//div[@class='searchBtncntr']/button")
	private WebElement searchHolidyas;
	
	
	public HolidaysPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	

}
