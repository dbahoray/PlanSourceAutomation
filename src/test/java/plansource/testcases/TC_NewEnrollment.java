package plansource.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import junit.framework.Assert;
import plansource.pageobject.DatePicker;
import plansource.pageobject.LoginPage;
import plansource.pageobject.NewHireEnrollment;

public class TC_NewEnrollment extends BaseClass {
	
	@Test
	public void verifyNewEnrollment() throws IOException, InterruptedException
	{	
		LoginPage lg = new LoginPage(driver);
		lg.enterUerName("plansource_test_admin");
		lg.enterPassword("password123");
		lg.ClickOnLoginButton();
		logger.info("Successfully logged in.");
		
		Thread.sleep(3000);
		
		NewHireEnrollment enrol = new NewHireEnrollment(driver);
		enrol.ClickOnRecentlyViewedEmployee();
		enrol.ClickOnHireEnrollmentLink();
		Thread.sleep(3000);
		enrol.ClickOnGetStartedButton();
		enrol.ClickOnNextReviewMyFamilyButton();
		logger.info("Successfully clicked on my family button.");
		enrol.ClickOnAddNewFamilyMember();
		logger.info("Successfully clicked on add family button.");
		enrol.enterDependantFirstName("judetrump");
		enrol.enterDependantLastName("cathrine");
		enrol.SelectGender();
		
		DatePicker dp = new DatePicker(driver);
		dp.selectBirthDate("03/11/2002");
		Thread.sleep(2000);
		
		enrol.SelectRelationShip();
		enrol.ClickOnSaveButton();
		logger.info("Successfully clicked on the save button to save a family member.");
		
	}

}
