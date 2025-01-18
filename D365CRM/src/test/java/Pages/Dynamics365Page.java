package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Dynamics365Page {

	WebDriver driver;

	// Locators
	@FindBy(xpath = "//*[contains(@id, 'dialogCloseIconButton')]")
	WebElement popupicon;

	@FindBy(xpath = "//input[@id='app-search-input']")
	WebElement searchapps;

	@FindBy(xpath = "//div[@title='IET UCI']")
	WebElement ietuciapp;

	@FindBy(xpath = "//button[@aria-controls='Microsoft.Copilot.Pane']")
	WebElement copilotpane;

	@FindBy(xpath = "//span[contains(text(),'Member/Contact')]")
	WebElement membercontacttab;

	@FindBy(xpath = "//img[@title='New']")
	WebElement addnewcontacticon;

	public Dynamics365Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void closePopupDialog() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		if (popupicon.isDisplayed() && popupicon.isEnabled()) {
			wait.until(ExpectedConditions.visibilityOf(popupicon));
			wait.until(ExpectedConditions.elementToBeClickable(popupicon));
			popupicon.click();
			System.out.println("Popup icon clicked successfully.");
		}
	}

	public void searchForApp() {

		driver.switchTo().frame("AppLandingPage");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchapps));
		searchapps.click();
		searchapps.sendKeys("IET UCI");

	}

	public void clickOnApp() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ietuciapp));
		wait.until(ExpectedConditions.elementToBeClickable(ietuciapp));
		ietuciapp.click();
		System.out.println("Clicked on IET UCI app.");
		driver.switchTo().defaultContent();

	}

	public void navigateToDashboardTab() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(copilotpane));
		wait.until(ExpectedConditions.elementToBeClickable(copilotpane));
		copilotpane.click();
		System.out.println("Navigated to dashboard tab.");

	}

	public void clickOnMemberContactTab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(membercontacttab));
		wait.until(ExpectedConditions.elementToBeClickable(membercontacttab));
		membercontacttab.click();
		System.out.println("Clicked on Member/Contact tab.");
	}

	public void clickAddNewContactIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(addnewcontacticon));
		wait.until(ExpectedConditions.elementToBeClickable(addnewcontacticon));
		addnewcontacticon.click();
		System.out.println("Clicked on Add New Contact icon.");
	}
}
