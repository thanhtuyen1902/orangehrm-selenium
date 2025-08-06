package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeListPage extends BasePage{

	public EmployeeListPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Employee Information

	@FindBy(xpath="(//input[@placeholder='Type for hints...'])[1]") WebElement tbEmployeeName;
	@FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']") WebElement tbEmployeeId;
	@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--focus']//div[@class='oxd-select-text-input'][normalize-space()='-- Select --']") WebElement empStatusDD;
	@FindBy(xpath="//div[contains(text(),'Current Employees Only')]") WebElement includeDD;
	@FindBy(xpath="//div[5]//div[1]//div[2]//div[1]//div[1]//input[1]") WebElement tbSupervisorName;
	@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--focus']//div[@class='oxd-select-text-input'][normalize-space()='-- Select --']") WebElement jobTitleDD;
	@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--focus']//div[@class='oxd-select-text-input'][normalize-space()='-- Select --']") WebElement subUnitDD;
	@FindBy(xpath="//button[normalize-space()='Reset']") WebElement btnReset;
	@FindBy(xpath="//button[normalize-space()='Search']") WebElement btnSearch;

//	@FindBy (xpath="//div[@class='oxd-table-card-cell']//div[text()='First (& Middle) Name']/following-sibling::div[@class='data']") List<WebElement> firstAndMidnames;
	@FindBy (xpath="//div[@class='oxd-table-card-cell']") List<WebElement> rows;
	
	public void setEmpName(String empName) {
		tbEmployeeName.sendKeys(empName, Keys.TAB);
	}
	
	public void setEmpId(String empId) {
		tbEmployeeId.sendKeys(empId);
	}
	
	
//	public void selectEmpStatus() {
//		
//	}
	
	public void clickSearch() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", btnSearch);
	}
	public void clickReset() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", btnReset);
	}
	
	public String getFirstMidNameFromRow(WebElement row) {
		return row.findElement(By.xpath(".//div[text()='First (& Middle) Name']/following-sibling::div[@class='data']")).getText().trim();
	}
	
	public String getLastNameFromRow(WebElement row) {
		return row.findElement(By.xpath(".//div[text()='Last Name']/following-sibling::div[@class='data']")).getText().trim();
	}
	
	public boolean isFullNameDisplayed(String expectedName) {
//		if (firstAndMidnames.isEmpty()) {
//			return false;
//		}
//		
//		for (WebElement name : firstAndMidnames) {
//			String actualName = name.getText().trim().toLowerCase();
//			if (!actualName.contains(expectedName.toLowerCase())) {
//				return false;
//			}
//		}
		if (rows.isEmpty()) {
			return false;
		}
		for (WebElement row : rows) {
			String firstAndMidName = getFirstMidNameFromRow(row);
			String lastName = getLastNameFromRow(row);
			String fullName = (firstAndMidName + " " + lastName).toLowerCase();
			if (!fullName.contains(expectedName.toLowerCase())) {
				return false;
			}
		}
		return true;
	}
}
