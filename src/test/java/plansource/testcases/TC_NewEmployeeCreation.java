package plansource.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import junit.framework.Assert;
import plansource.pageobject.AddNewEmployee;
import plansource.pageobject.DatePicker;
import plansource.pageobject.LoginPage;

public class TC_NewEmployeeCreation extends BaseClass {
	
	@Test
	public void verifyAddEmployeeAndLogin() throws InterruptedException, IOException
	{	
		LoginPage lg = new LoginPage(driver);
		lg.enterUerName("plansource_test_admin");
		lg.enterPassword("password123");
		lg.ClickOnLoginButton();
		logger.info("Successfully logged in.");
		
		Thread.sleep(3000);
		
		AddNewEmployee adEmp = new AddNewEmployee(driver);
		adEmp.ClickOnAddNewEmployee();
		logger.info("Clicked on Add New Employee Link.");
		
		adEmp.enterPassWord("test10410434");
		adEmp.enterFirstName("Goku");
		adEmp.enterLastName("Vegeta");
		adEmp.enterSSNvalue("111-120-2360");
		adEmp.enterAddress("HN-2 1375 Broadway");
		adEmp.enterCity("Houston");
		adEmp.SelectState("Texas");
		adEmp.enterZipCode("77001");
		adEmp.SelectCountry("United");
		
		DatePicker dp = new DatePicker(driver);
		dp.selectBirthDate("03/11/2002");
		Thread.sleep(2000);
		
		adEmp.SelectGender("M");
		adEmp.SelectMaritalStatus("S");
		adEmp.SelectHireDate("05/24/2025");
		adEmp.SelectBenefitsStartDate("05/24/2025");
		adEmp.SelectEmpLevel("F");
		adEmp.SelectLocation("NCA");
		adEmp.enterCurrentSalary("235");
		adEmp.enterBenefitSalary("678");
		//adEmp.ClickOnSaveButton();
		logger.info("Clicked on save button.");
		
		String actualMessage = adEmp.getSuccessMessage();
		if(actualMessage.equals("Employee was successfully created.")) {
			logger.info("Successful creation.");
			Assert.assertTrue(true);
		}
		else {
			logger.info("Un-Successful creation.");
			captureScreenShot(driver, "verifyAddEmployeeAndLogin");
			Assert.assertTrue(false);
		}
	}

}
