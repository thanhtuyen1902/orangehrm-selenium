package testBase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pageObjects.HomePage;
import pageObjects.LoginPage;

public class BaseTest extends BaseClass{
	protected HomePage hp;
	
	@BeforeMethod
	public void login() {
		LoginPage lp = new LoginPage(driver);
		hp = lp.login(p.getProperty("username"), p.getProperty("password"));
		
	}
	
	@AfterMethod
	public void logout() {
		hp.clickUserDD();
		hp.clickLogout();
	}
	
}
