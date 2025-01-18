package StepDefinitions;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.Dynamics365Page;
import Pages.LoginPage;
import Pages.NewMemberContactPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NewContactSteps {

	WebDriver driver;
	NewMemberContactPage newMemberContactPage;
	LoginPage loginPage;
	Dynamics365Page dynamics365Page;
	WebDriverWait wait;

	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://iet-prod.crm11.dynamics.com/main.aspx?");

	}

	@When("user enters credentials")
	public void user_enters_credentials() throws IOException {
		loginPage = new LoginPage(driver);
		loginPage.enterValidLogin();
	}

	@When("clicks on the login button")
	public void clicks_on_the_login_button() {
		loginPage.clickLogin();
	}

	@Then("the user is navigated to the home page")
	public void the_user_is_navigated_to_the_home_page() {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "Dynamics 365";
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Title Matched");
		} else {
			System.out.println("Title didn't match");
		}

	}

	@When("the user searches for the IET UCI App")
	public void the_user_searches_for_the_iet_uci_app() throws InterruptedException {
		dynamics365Page = new Dynamics365Page(driver);
		dynamics365Page.closePopupDialog();
		dynamics365Page.searchForApp();
	}

	@When("clicks on the IET UCI App")
	public void clicks_on_the_iet_uci_app() {
		dynamics365Page.clickOnApp();

	}

	@Then("the user is navigated to the dashboard tab of IET UCI")
	public void the_user_is_navigated_to_the_dashboard_tab_of_iet_uci() throws InterruptedException {
		dynamics365Page.navigateToDashboardTab();
	}

	@When("the user clicks on the member\\/contact tab")
	public void the_user_clicks_on_the_member_contact_tab() {
		dynamics365Page.clickOnMemberContactTab();
	}

	@When("clicks on the add new contact icon")
	public void clicks_on_the_add_new_contact_icon() {
		dynamics365Page.clickAddNewContactIcon();
	}

	@Then("the new contact form is displayed")
	public void the_new_contact_form_is_displayed() {
		validatePageTitle("New Contact - Microsoft Dynamics 365");

	}

	@When("the user enters the first name and last name and selects the gender")
	public void the_user_enters_the_first_name_and_last_name_and_selects_the_gender() {
		newMemberContactPage = new NewMemberContactPage(driver);
		newMemberContactPage.handleErrorModal();
		newMemberContactPage.selectTitle();
		newMemberContactPage.setFirstName();
		newMemberContactPage.setLastName();
		newMemberContactPage.selectGender();

	}

	@When("clicks on the Home & Local Networks tab")
	public void clicks_on_the_home_local_networks_tab() {
		newMemberContactPage.selectHomeAndLocalNetworks();
	}

	@Then("the user is navigated to the Home & Local Networks page")
	public void the_user_is_navigated_to_the_home_local_networks_page() {
		validatePageTitle("Home & Local Networks - Microsoft Dynamics 365");
	}

	@When("the user selects the home address")
	public void the_user_selects_the_home_address() {
		newMemberContactPage.setAddressCountry();
		newMemberContactPage.selectSillertonHouseAddress();
	}

	@When("clicks on the save & close button")
	public void clicks_on_the_save_close_button() {
		newMemberContactPage.clickSaveAndClose();
	}

	@Then("the user is navigated to the Active Members\\/Contacts view")
	public void the_user_is_navigated_to_the_active_members_contacts_view() {
		validatePageTitle("Active Members/Contacts - Microsoft Dynamics 365");
	}

	private void validatePageTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		System.out.println("Actual Title: " + actualTitle);
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Title matched");
		} else {
			System.out.println("Title mismatch");
		}
	}
}
