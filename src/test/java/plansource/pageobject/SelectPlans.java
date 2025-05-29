package plansource.pageobject;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class SelectPlans {
	
    WebDriver ldriver;
	
	public SelectPlans(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	} 
	
	@FindBy(xpath = "//div[@class='alert-message']")
	WebElement successMessage2;
	
	@FindBy(xpath = "(//span[normalize-space()='Next: Shop for Benefits'])[1]")
	WebElement shopForbenefits;
	
	@FindBy(xpath = "(//a[@class='btn benefit-btn btn-primary'][normalize-space()='Shop Plans'])[1]")
	WebElement MshopPlans;
	
	@FindBy(id = "updateCartBtn")
	WebElement updateBtn1;
	
	@FindBy(xpath = "(//a[@class='m-b-sm p-a-0 btn btn-link back-nav'])[1]")
	WebElement backTobenefits;
	
	@FindBy(xpath = "(//a[@class='btn benefit-btn btn-primary'][normalize-space()='Shop Plans'])[6]")
	WebElement VEmpshoPlans;
	
	@FindBy(xpath = "(//button[@title='Select Amount'])[1]")
	WebElement selAmt;
	
	@FindBy(xpath = "(//button[@class='btn btn-primary btn-lg full-width-sm p-x-md btn btn-primary animate-ripple-out'])[1]")
	WebElement confm;
	
	@FindBy(id = "toggleNavMenu")
	WebElement sidebar;
	
	@FindBy(xpath = "(//a[@data-submenu-key='admin'])[1]")
	WebElement admin;
	
	@FindBy(xpath = "//ul[@style='opacity: 1; display: block; transform: translateY(0px);']//li[3]")
	WebElement checkout;
	
	@FindBy(xpath = "//button[@type='submit']//span[contains(text(),'Checkout')]")
	WebElement checkoutBtn;
	
	@FindBy(xpath = "(//button[@class='btn btn-link shown-while-editing'])[1]")
	WebElement download;
	
	public String GetSuccessMessage()
	{
		return successMessage2.getText().trim();
	}
	public void ClickOnShopForBenefits()
	{
		shopForbenefits.click();
	}
	public void ClickOnMedicalShopPlans()
	{
		MshopPlans.click();
	}
	public void ClickOnUpdateCartButton()
	{
		updateBtn1.click();
	}
	public void ClickOnBackTobenefits()
	{
		backTobenefits.click();
	}
	public void ClickOnVoluntaryEmployeeShopPlans()
	{
		VEmpshoPlans.click();
	}
	public void SelectAmount()
	{
		selAmt.click();
		
		WebElement opt = ldriver.findElement(By.xpath("//div[contains(@class,'dropdown-menu open show')]//a[contains(@class,'')]"));
		opt.click();
	}
	public void ClickOnConfirmBox()
	{
		confm.click();
	}
	public void ClickOnSideBar()
	{
		sidebar.click();
	}
	public void ClickOnAdmin()
	{
		admin.click();
	}
	public void ClickOnProceedToCheckout()
	{
		checkout.click();
	}
	public void ClickOnCheckoutButton()
	{
		checkoutBtn.click();
	}
	public void ClickOnDownloadButton() throws InterruptedException
	{
		download.click();
		
		Thread.sleep(4000);
		
		String downloadPath = System.getProperty("user.home") + "/Downloads/yourfile.pdf";
		File downloadedFile = new File(downloadPath);
		
		Assert.assertTrue("Downloaded file not found!", downloadedFile.exists());
	}

}
