package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddEmployeePage;
import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.PIMPage;
import pageObjects.PersonalDetailsPage;
import testBase.BaseClass;
import testBase.BaseTest;

public class TC006_AddEmployeeTest extends BaseTest{
	
	
	@Test
	public void verify_addEmployee() {
		HomePage hp = new HomePage(driver);
		hp.clickPIM();
		
		PIMPage pim = new PIMPage(driver);
		pim.clickaddEmployeeTab();
		
		AddEmployeePage addemployee = new AddEmployeePage(driver);
		if (addemployee.isTittleAddEmployeeDisplayed()) {
			try {
				addemployee.setFirstName("Nguyen");
				addemployee.setMidName("ngoc");
				addemployee.setLastName("lan");
				addemployee.clickSave();
				
				PersonalDetailsPage pd = new PersonalDetailsPage(driver);
				if (pd.isTittlePersonalDetailsDisplayed()) {
					Assert.assertTrue(true);
				}else {
					Assert.assertTrue(false);
				}
			}catch (Exception e) {
				Assert.fail();
			}
		}
	}
}
