package plansource.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewHireEnrollment {
	
	WebDriver ldriver;
	
	public NewHireEnrollment(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//table[@class='table table-borderless basic']//tbody//tr[1]")
	WebElement viewedEmps;
	
	@FindBy(xpath = "(//a[normalize-space()='New Hire Enrollment'])[1]")
	WebElement HireEnrollment;
	
	@FindBy(id = "enrollmentStepOne")
	WebElement getStarted;
	
	@FindBy(id = "submit_form")
	WebElement reviewMyFamily;
	
	@FindBy(id = "AddDependentDiv")
	WebElement familyMember;
	
	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstname;
	
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastname;
	
	@FindBy(xpath = "//button[@data-id='gender']")
	WebElement selGender;
	
	@FindBy(xpath = "//button[@data-id='relationship']")
	WebElement selRelationship;
	
	@FindBy(xpath = "//button[@id='submit_form']")
	WebElement SaveBtn;
	
	
	public void ClickOnRecentlyViewedEmployee()
	{
		viewedEmps.click();
	}
	
	public void ClickOnHireEnrollmentLink()
	{
		HireEnrollment.click();
	}
	public void ClickOnGetStartedButton()
	{
		getStarted.click();
	}
	public void ClickOnNextReviewMyFamilyButton()
	{
		((JavascriptExecutor) ldriver).executeScript("arguments[0].scrollIntoView(true);", reviewMyFamily);
		reviewMyFamily.click();
	}
	public void ClickOnAddNewFamilyMember()
	{
		familyMember.click();
	}
	public void enterDependantFirstName(String fname)
	{
		firstname.click();
	}
	public void enterDependantLastName(String lname)
	{
		lastname.click();
	}
	public void SelectGender() throws InterruptedException
	{
		selGender.click();
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		WebElement genderOption = ldriver.findElement(By.xpath("//ul[contains(@class,'dropdown-menu')]//span[text()='Male']"));
		genderOption.click();
	}
	public void SelectRelationShip()
	{
		selRelationship.click();
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		WebElement relOption = ldriver.findElement(By.xpath("//ul[contains(@class,'dropdown-menu')]//span[text()='Child']"));
		relOption.click();
		
	}
	public void ClickOnSaveButton()
	{
		SaveBtn.click();
	}

}
