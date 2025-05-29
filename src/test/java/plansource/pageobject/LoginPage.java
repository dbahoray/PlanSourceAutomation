package plansource.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "user_name")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "logon_submit")
	WebElement lgnBtn;
	
	public void enterUerName(String Username)
	{
		username.sendKeys(Username);
	}
	public void enterPassword(String Password)
	{
		password.sendKeys(Password);
	}
	public void ClickOnLoginButton()
	{
		lgnBtn.click();
	}

}
