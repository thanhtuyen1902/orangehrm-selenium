package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	@FindBy(xpath="//input[@placeholder='Username']") WebElement tbUsername;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement tbPwd;
	@FindBy(xpath="//button[normalize-space()='Login']") WebElement btnLogin;

	public void setUsername(String username) {
		tbUsername.sendKeys(username);
	}
	
	public void setPassword(String pwd) {
		tbPwd.sendKeys(pwd);
	}
	
	public void clickLogin() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", btnLogin);
	}
	
	public HomePage login(String username, String password) {
		tbUsername.sendKeys(username);
		tbPwd.sendKeys(password);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", btnLogin);
		
		//// Sau khi login, điều hướng sang HomePage
		return new HomePage(driver);
	}
}
