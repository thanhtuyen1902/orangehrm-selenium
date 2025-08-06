package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//span[normalize-space()='Admin']") WebElement adminTab;
	@FindBy(xpath="//span[normalize-space()='PIM']") WebElement PIMTab;
	@FindBy(xpath="//span[normalize-space()='Leave']") WebElement leaveTab;
	@FindBy(xpath="//span[normalize-space()='Recruitment']") WebElement recruitmentTab;
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Dashboard']") WebElement dashboardTab;
	
	
	@FindBy(xpath="//p[@class='oxd-userdropdown-name']") WebElement userDD;
	@FindBy(xpath="//a[normalize-space()='Logout']") WebElement btnLogout;

	public void clickAdmin() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", adminTab);
	}
	public void clickPIM() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", PIMTab);
	}
	public void clickLeave() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", leaveTab);
	}
	
	public void clickRecruit() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", recruitmentTab);
	}
	
	public void clickDashboard() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", dashboardTab);
	}
	public String getTittleDashboard() {
		return dashboardTab.getText();
	}

	public void clickUserDD() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", userDD);
	}
	
	public void clickLogout() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", btnLogout);
	}
	
}
