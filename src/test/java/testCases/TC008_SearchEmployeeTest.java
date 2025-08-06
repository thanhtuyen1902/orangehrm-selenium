package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.EmployeeListPage;
import pageObjects.HomePage;
import pageObjects.PIMPage;
import testBase.BaseTest;

public class TC008_SearchEmployeeTest extends BaseTest{
	public static EmployeeListPage empList;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.clickPIM();
		PIMPage pim = new PIMPage(driver);
		pim.clickemployeeListTab();
		Thread.sleep(2000);
		
	}
	
	@Test
	public void testSearchEmpByName() throws InterruptedException {
		String expectedName = "John";
		empList = new EmployeeListPage(driver);
		empList.setEmpName(expectedName);
		Thread.sleep(1000);
		empList.clickSearch();
		
		Assert.assertTrue(empList.isFullNameDisplayed(expectedName), "Không tìm thấy nhân viên có tên chứa: " + expectedName);
		
	}
}
