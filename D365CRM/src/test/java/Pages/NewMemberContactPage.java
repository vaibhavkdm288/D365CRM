package Pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewMemberContactPage {

	WebDriver driver;

	@FindBy(xpath = "//button[@title = 'OK']")
	WebElement okButton;

	@FindBy(xpath = "//button[@aria-label='Title']")
	WebElement title;

	@FindBy(xpath = "//div[@role='option']")
	List<WebElement> titlelist;

	@FindBy(xpath = "//input[@aria-label='First Name']")
	WebElement fname;

	@FindBy(xpath = "//input[@aria-label='Last Name']")
	WebElement lname;

	@FindBy(xpath = "//button[@aria-label='Gender']")
	WebElement gender;

	@FindBy(xpath = "//div[@role='listbox']//div[@role='option']")
	List<WebElement> genderlist;

	@FindBy(xpath = "//li[@title='Home & Local Networks']")
	WebElement homeandlocalnw;

	@FindBy(xpath = "//input[@role='searchbox']")
	WebElement homeaddreslookup;

	@FindBy(xpath = "//div[contains(text(), 'AL1: London Road, St. Albans')]")
	WebElement suggestion1;

	@FindBy(xpath = "//div[contains(text(), 'AL1 1AX: 11 Vickers Mews, London Road, St. Albans')]")
	WebElement suggestion2;

	@FindBy(xpath = "//img[@title = 'Save & Close']")
	WebElement saveandclosebtn;

	public NewMemberContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void handleErrorModal() {

		// Check if the modal is present
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(okButton));
		wait.until(ExpectedConditions.elementToBeClickable(okButton));
		if (okButton.isDisplayed()) {
			System.out.println("Error modal is displayed.");

			okButton.click();

		}
	}

	// Method to select a title
	public void selectTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOf(title));
		wait.until(ExpectedConditions.elementToBeClickable(title));
		title.click();

		wait.until(ExpectedConditions.visibilityOfAllElements(titlelist));

		for (WebElement option : titlelist) {
			String optionText = option.getText().trim(); // Fetch visible text
			if ("Mr".equalsIgnoreCase(optionText)) {
				System.out.println("Selecting option: " + optionText);
				option.click();
				break;
			}
		}
	}

	// Method to set the first name
	public void setFirstName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(fname));
		fname.clear();
		fname.sendKeys("Matt");
	}

	// Method to set the last name
	public void setLastName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(lname));
		lname.clear();
		lname.sendKeys("Stark");

	}

	// Method to select gender
	public void selectGender() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('tab-section3').scrollTop = 200;");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(gender));
		gender.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(genderlist));

		for (WebElement option : genderlist) {
			String optionText = option.getText().trim(); // Fetch visible text
			if ("Man".equalsIgnoreCase(optionText)) {
				System.out.println("Selecting option: " + optionText);
				option.click();
				break;
			}
		}
	}

	// Method to select home and local networks
	public void selectHomeAndLocalNetworks() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(homeandlocalnw));
		homeandlocalnw.click();
	}

	// Method to set the address country
	public void setAddressCountry() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(homeaddreslookup));
		wait.until(ExpectedConditions.elementToBeClickable(homeaddreslookup));
		homeaddreslookup.clear();
		homeaddreslookup.sendKeys("London");
		Actions actions = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].focus();", homeaddreslookup);
		actions.moveToElement(homeaddreslookup).sendKeys(Keys.RETURN).perform();

	}

	public void selectSillertonHouseAddress() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(suggestion1));
		wait.until(ExpectedConditions.elementToBeClickable(suggestion1));
		suggestion1.click();
		wait.until(ExpectedConditions.visibilityOf(suggestion2));
		wait.until(ExpectedConditions.elementToBeClickable(suggestion2));
		suggestion2.click();
	}

	// Method to click on Save & Close button
	public void clickSaveAndClose() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(saveandclosebtn));
		wait.until(ExpectedConditions.elementToBeClickable(saveandclosebtn));
		saveandclosebtn.click();

	}
}
