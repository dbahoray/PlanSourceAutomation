package plansource.pageobject;


import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;

import java.time.LocalDate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePicker {
	
	WebDriver ldriver;
	WebDriverWait wait;
	
    public DatePicker(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
    
    @FindBy(id = "birthdate")
    WebElement birthDate;

    @FindBy(css = ".datepicker-days .datepicker-switch")
    WebElement calendarHeader;

    @FindBy(css = "div[class='datepicker-days'] th[class='next']")
    WebElement rightArrow;

    @FindBy(css = "div[class='datepicker-days'] th[class='prev']")
    WebElement leftArrow;

    @FindBy(xpath = "//div[contains(@class,'datepicker')]//td[contains(@class,'day')]")
    List<WebElement> dates;

    @FindBy(css = ".datepicker-months .datepicker-switch")
    WebElement monthYearHeader;

    @FindBy(css = ".datepicker-years .datepicker-switch")
    WebElement yearHeader;

    @FindBy(xpath = "//div[contains(@class,'datepicker-months')]//span[contains(@class,'month')]")
    List<WebElement> months;

    @FindBy(xpath = "//div[contains(@class,'datepicker-years')]//span[contains(@class,'year')]")
    List<WebElement> years;

    public void selectBirthDate(String bDate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
            LocalDate targetDate = LocalDate.parse(bDate, formatter);
           
            // Click on birth date field to open calendar
            birthDate.click();
           
            // Wait for calendar to be visible
            wait.until(ExpectedConditions.visibilityOf(calendarHeader));
           
            selectDate(targetDate);
           
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use dd/MM/yyyy format (e.g., 15/03/1990)", e);
        } catch (Exception e) {
            throw new RuntimeException("Error selecting birth date: " + e.getMessage(), e);
        }
    }

    private void selectDate(LocalDate targetDate) {
        // First navigate to correct year
        navigateToYear(targetDate.getYear());
       
        // Then navigate to correct month
        navigateToMonth(targetDate.getMonthValue());
       
        // Finally select the day
        selectDay(targetDate.getDayOfMonth());
    }

    private void navigateToYear(int targetYear) {
        // Click on month/year header to go to year view
        calendarHeader.click();
        wait.until(ExpectedConditions.visibilityOf(monthYearHeader));
       
        monthYearHeader.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(years));
       
        // Find and click the target year
        boolean yearFound = false;
        for (WebElement yearElement : years) {
            if (yearElement.getText().trim().equals(String.valueOf(targetYear))) {
                yearElement.click();
                yearFound = true;
                break;
            }
        }
       
        if (!yearFound) {
            throw new RuntimeException("Year " + targetYear + " not found in the date picker");
        }
       
        // Wait for month view to be visible
        wait.until(ExpectedConditions.visibilityOfAllElements(months));
    }

    private void navigateToMonth(int targetMonth) {
        // Month names array (0-based index)
        String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                              "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
       
        String targetMonthName = monthNames[targetMonth - 1];
       
        boolean monthFound = false;
        for (WebElement monthElement : months) {
            if (monthElement.getText().trim().equals(targetMonthName)) {
                monthElement.click();
                monthFound = true;
                break;
            }
        }
       
        if (!monthFound) {
            throw new RuntimeException("Month " + targetMonthName + " not found in the date picker");
        }
       
        // Wait for day view to be visible
        wait.until(ExpectedConditions.visibilityOfAllElements(dates));
    }

    private void selectDay(int targetDay) {
        boolean dayFound = false;
        for (WebElement dayElement : dates) {
            String dayText = dayElement.getText().trim();
            if (dayText.equals(String.valueOf(targetDay)) &&
                !dayElement.getAttribute("class").contains("old") &&
                !dayElement.getAttribute("class").contains("new")) {
                dayElement.click();
                dayFound = true;
                break;
            }
        }
       
        if (!dayFound) {
            throw new RuntimeException("Day " + targetDay + " not found in the current month");
        }
    }

}
