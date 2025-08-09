package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeeListPage extends BasePage{
	public static WebDriverWait wait;
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

	@FindBy(xpath="//div[@class='oxd-table-body']") WebElement resultTable;
//	@FindBy(xpath="//span[normalize-space()='No Records Found']") WebElement noResult;
	@FindBy(css="div[class='orangehrm-horizontal-padding orangehrm-vertical-padding'] span[class='oxd-text oxd-text--span']") WebElement countResult;
	
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
	

	//Lấy dữ liệu trong bảng, tolowercase
	public String getResultText() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(resultTable));
		return resultTable.getText().toLowerCase();
	}


	public boolean getCountResult() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(countResult));
		if (countResult.equals("No Records Found")) {
			return false;
		}
		
		return true;
		
	}

}
