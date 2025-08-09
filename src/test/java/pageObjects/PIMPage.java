package pageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PIMPage extends BasePage{
	
	public PIMPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	@FindBy(xpath="//a[normalize-space()='Employee List']") WebElement employeeListTab;
	@FindBy(xpath="//a[normalize-space()='Add Employee']") WebElement addEmployeeTab;
	@FindBy(xpath="//a[normalize-space()='Reports']") WebElement reportTab;
	
	
	public void clickemployeeListTab() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", employeeListTab);
	}
	public void clickaddEmployeeTab() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", addEmployeeTab);
	}
	public void clickreportTab() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", reportTab);
	}
	
	
	
}
