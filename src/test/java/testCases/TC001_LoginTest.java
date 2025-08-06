package testCases;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC001_LoginTest extends BaseClass{
	
	@Test
	
	public void verify_login() {
		try {
			LoginPage lp = new LoginPage(driver);
			lp.setUsername(p.getProperty("username"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			HomePage hp = new HomePage(driver);
			if (hp.getTittleDashboard().equals("Dashboard")) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}catch(Exception e) {
			Assert.fail();
		}
		
	}
}
