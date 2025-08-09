package testCases;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

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
	
	//Test trường hợp nhập tên có trong danh sách nhân viên
	@Test
	public void testSearchEmpByName() throws InterruptedException {
		String expectedName = "John";
		empList = new EmployeeListPage(driver);
		empList.setEmpName(expectedName);
		Thread.sleep(1000);
		empList.clickSearch();
		if (empList.getResultText().isEmpty()) {
			Assert.fail();
		}
		Assert.assertTrue(empList.getResultText().contains(expectedName.toLowerCase()), "Không tìm thấy nhân viên có tên chứa: " + expectedName);
		
	}
	
	//Test trường hợp nhập tên không có trong danh sách nhân viên --> No Records Found
	@Test
	public void testSearchEmpByNameNoResult() {
		String expectedName = "jjj";
		empList = new EmployeeListPage(driver);
		empList.setEmpName(expectedName);
		empList.clickSearch();
		boolean result = empList.getCountResult();
		Assert.assertTrue(result, "");
	}
}
