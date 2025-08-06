package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalDetailsPage extends BasePage{

	public PersonalDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//h6[normalize-space()='Personal Details']") WebElement tittlePersonalDetails;
	@FindBy(css=".oxd-text.oxd-text--h6.--strong") WebElement tittleName;
	@FindBy(xpath="//a[normalize-space()='Personal Details']") WebElement personalDetailsTab;
	
	public boolean isTittlePersonalDetailsDisplayed() {
		return tittlePersonalDetails.isDisplayed();
	}

	public boolean isTittleNameDisplayed() {
		return tittleName.isDisplayed();
	}

	
}
