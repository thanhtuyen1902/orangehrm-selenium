package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployeePage extends BasePage{

	public AddEmployeePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//xử lý tải ảnh..
	@FindBy(xpath="//h6[normalize-space()='Add Employee']") WebElement titleAddEmployee;
	@FindBy(xpath="//input[@placeholder='First Name']") WebElement tbFirstName;
	@FindBy(xpath="//input[@placeholder='Middle Name']") WebElement tbMidName;
	@FindBy(xpath="//input[@placeholder='Last Name']") WebElement tbLastName;
	@FindBy(css=".oxd-input.oxd-input--focus") WebElement tbEmployeeId;
	@FindBy(xpath="//span[@class='oxd-switch-input oxd-switch-input--active --label-right']") WebElement swLoginDetails;
	@FindBy(xpath="//button[normalize-space()='Cancel']") WebElement btnCancel;
	@FindBy(xpath="//button[normalize-space()='Save']") WebElement btnSave;
	@FindBy(css=".oxd-input.oxd-input--focus") WebElement tbUsername;
	@FindBy(xpath="//label[normalize-space()='Enabled']") WebElement rbEnabled;
	@FindBy(xpath="//label[normalize-space()='Disabled']") WebElement rbDisabled;
	@FindBy(css="div[class='oxd-grid-item oxd-grid-item--gutters user-password-cell'] div[class='oxd-input-group oxd-input-field-bottom-space'] div input[type='password']") WebElement tbPwd;
	@FindBy(css="div[class='oxd-grid-item oxd-grid-item--gutters'] div[class='oxd-input-group oxd-input-field-bottom-space'] div input[type='password']") WebElement tbConfirmPwd;
	
	public boolean isTittleAddEmployeeDisplayed() {
		return titleAddEmployee.isDisplayed();
	}

	public void setFirstName(String firstName) {
		tbFirstName.sendKeys(firstName);
	}
	
	public void setMidName(String midName) {
		tbMidName.sendKeys(midName);
	}
	
	public void setLastName(String lastName) {
		tbLastName.sendKeys(lastName);
	}
	
	public void setEmployeeId(String employeeId) {
		tbEmployeeId.sendKeys(employeeId);
	}
	
	public void clickLoginDetails() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", swLoginDetails);
	}
	
	
	public void clickCancel() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", btnCancel);
	}
	
	public void clickSave() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", btnSave);
	}
	
	public void setUsername(String username) {
		tbUsername.sendKeys(username);
	}
	public void setPwd(String pwd) {
		tbPwd.sendKeys(pwd);
	}
	
	public void setConfirmPwd(String confirmPwd) {
		tbConfirmPwd.sendKeys(confirmPwd);
	}
	


}
