package plansource.pageobject;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewEmployee {
	
    WebDriver ldriver;
	
	public AddNewEmployee(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[@data-method='get']")
	WebElement addnewEmp;
	
	@FindBy(id = "password")
	WebElement empPassword;
	
	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id = "last_name")
	WebElement lastName;
	
	@FindBy(id = "ssn_text")
	WebElement ssn;
	
	@FindBy(id = "address_1")
	WebElement address;
	
	@FindBy(id = "city")
	WebElement city;
	
	@FindBy(id = "stateTypeahead")
	WebElement state;
	
	@FindBy(id = "zip_code")
	WebElement zipcode;
	
	@FindBy(id = "countryTypeahead")
	WebElement country;
	
	@FindBy(id = "gender")
	WebElement gender;
	
	@FindBy(id = "marital_status")
	WebElement maritalStatus;
	
	@FindBy(id = "hire_date")
	WebElement hireDate;
	@FindBy(css = "tbody tr:nth-child(n) td:nth-child(n)")
	WebElement HDate;
	
	
	@FindBy(id = "benefits_start_date")
	WebElement startDate;
	@FindBy(css = "tbody tr:nth-child(n) td:nth-child(n)")
	WebElement SDate;
	
	@FindBy(id = "employment_level")
	WebElement Emplevel;
	
	@FindBy(id = "location")
	WebElement location;
	
	@FindBy(id = "current_salary")
	WebElement currentSalary;
	
	@FindBy(id = "benefit_salary")
	WebElement benefitSalary;
	
	@FindBy(id = "btn_save")
	WebElement saveBtn;
	
	@FindBy(xpath = "//div[@class='col alert-content']")
	WebElement successMessage;
	
	public void ClickOnAddNewEmployee()
	{
		addnewEmp.click();
	}
	public void enterPassWord(String EmpPassword)
	{
		empPassword.sendKeys(EmpPassword);
	}
	public void enterFirstName(String FirstName)
	{
		firstName.sendKeys(FirstName);
	}
	public void enterLastName(String LastName)
	{
		lastName.sendKeys(LastName);
	}
	public void enterSSNvalue(String SSNvalue)
	{
		ssn.sendKeys(SSNvalue);
	}
	public void enterAddress(String adres)
	{
		address.sendKeys(adres);
	}
	public void enterCity(String cty)
	{
		city.sendKeys(cty);
	}
	public void SelectState(String stat)
	{
		state.sendKeys(stat);
		try {
			Thread.sleep(1000);
		}catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		List<WebElement> options = ldriver.findElements(By.xpath("(//ul[@role='listbox'])[1]"));
		
		for(WebElement option:options) {
			if(option.getText().equalsIgnoreCase(stat)) {
				option.click();
				break;
			}
		}
	}
	public void enterZipCode(String zpcode)
	{
		zipcode.sendKeys(zpcode);
	}
	public void SelectCountry(String cntry)
	{
		country.sendKeys(cntry);
		try {
			Thread.sleep(1000);
		}catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		List<WebElement> options = ldriver.findElements(By.xpath("(//ul[@role='listbox'])[2]"));
		
		for(WebElement option:options) {
			if(option.getText().equalsIgnoreCase(cntry)) {
				option.click();
				break;
			}
		}
	}
	public void SelectGender(String gnd)
	{
		Select selgnd = new Select(gender);
		selgnd.selectByValue(gnd);
	}
	public void SelectMaritalStatus(String Mstatus)
	{
		Select selmstatus = new Select(maritalStatus);
		selmstatus.selectByValue(Mstatus);
	}
	public void SelectHireDate(String hDate)
	{
		hireDate.click();
		HDate.click();
	}
	public void SelectBenefitsStartDate(String sDate)
	{
		startDate.click();
		SDate.click();
	}
	public void SelectEmpLevel(String Elevel)
	{
		Select selelevel = new Select(Emplevel);
		selelevel.selectByValue(Elevel);
	}
	public void SelectLocation(String loction)
	{
		Select sellctn = new Select(location);
		sellctn.selectByValue(loction);
	}
	public void enterCurrentSalary(String CSalary)
	{
		currentSalary.sendKeys(CSalary);
	}
	public void enterBenefitSalary(String BSalary)
	{
		benefitSalary.sendKeys(BSalary);
	}
	public void ClickOnSaveButton()
	{
		saveBtn.click();
	}
	public String getSuccessMessage()
	{
		return successMessage.getText().trim();
	}
}
