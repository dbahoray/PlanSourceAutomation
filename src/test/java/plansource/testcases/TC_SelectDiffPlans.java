package plansource.testcases;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;
import plansource.pageobject.LoginPage;
import plansource.pageobject.NewHireEnrollment;
import plansource.pageobject.SelectPlans;
import plansource.utilities.EnrollmentAPI;

public class TC_SelectDiffPlans extends BaseClass{
	
	@Test
	public void verifydiffPlans() throws InterruptedException, IOException
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
		enrol.SelectRelationShip();
		enrol.ClickOnSaveButton();
		logger.info("Successfully clicked on the save button to save a family member.");
		
		SelectPlans splns = new SelectPlans(driver);
		String actualMessage2 = splns.GetSuccessMessage();
		Assert.assertEquals(actualMessage2, "Successfully saved your family member.", "Success message not matched.");
		
		splns.ClickOnShopForBenefits();
		splns.ClickOnMedicalShopPlans();
		Thread.sleep(3000);
		splns.ClickOnUpdateCartButton();
		Thread.sleep(3000);
		logger.info("Successfully selected medical plan.");
		splns.ClickOnBackTobenefits();
		splns.ClickOnVoluntaryEmployeeShopPlans();
		splns.SelectAmount();
		splns.ClickOnUpdateCartButton();
		splns.ClickOnConfirmBox();
		Thread.sleep(2000);
		splns.ClickOnBackTobenefits();
		logger.info("Successfully selected voluntary employee plan.");
		
		String sessionId = "455bf7fa84267f11b7d26434a865120b";
		String referer = "https://partner-dev-benefits.plansource.com/subscriber/benefit/121137668";
		
		Map<String, Object> jsonBody = new HashMap<>();
	    Map<String, Object> election = new HashMap<>();
	    election.put("coverage_level_id", 137);
	    election.put("dependent_ids", new int[]{});
	    election.put("org_plan_id", 319901188);
	    
	    jsonBody.put("election", election);
	    jsonBody.put("enrollment_context_type", "initial");
	    jsonBody.put("include_benefits_in_response", true);
	    jsonBody.put("include_related_coverage_changes", true);
	    jsonBody.put("life_event_completed", false);
	    jsonBody.put("org_benefit_id", 121137668);
	    
	    Response response = EnrollmentAPI.enrollEmployee(sessionId, referer, jsonBody);
	    
	    Assert.assertEquals("Enrollment API failed",200, response.getStatusCode());
	    System.out.println("Enrollment Response: " + response.getBody().asString());
	    
	    splns.ClickOnSideBar();
	    splns.ClickOnAdmin();
	    splns.ClickOnProceedToCheckout();
	    Thread.sleep(2000);
	    splns.ClickOnCheckoutButton();
	    
	    String expectedmessage = "Congratulations. You have completed the new hire enrollment process and confirmed your benefits.";
	    WebElement msg = driver.findElement(By.xpath("(//p[@class='p-y-xs'])[1]"));
	    String actualmessage = msg.getText().trim();
	   if(actualmessage.equals(expectedmessage)) {
		   logger.info("Congrats message displayed.");
		   Assert.assertTrue(true);
		   splns.ClickOnDownloadButton();
	   }
	   else {
		   logger.info("Congrats message not displayed.");
		   captureScreenShot(driver, "verifydiffPlans");
		   Assert.assertTrue(false);
	   }
	}

}
