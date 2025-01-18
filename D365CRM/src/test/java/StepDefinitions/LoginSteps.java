package StepDefinitions;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.LoginPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://iet-prod.crm11.dynamics.com/main.aspx?");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() throws IOException {
        loginPage.enterValidLogin();
    }

    @And("click on login button")
    public void click_on_login_button() throws InterruptedException {
        loginPage.clickLogin();
        Thread.sleep(7000); // Adjust or replace this with WebDriverWait if necessary
    }

    @Then("user is navigated to home page")
    public void user_is_navigated_to_home_page() {
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Microsoft Dynamics 365";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title Matched");
        } else {
            System.out.println("Title didn't match");
        }
        driver.quit(); // Ensure the browser closes after execution
    }
}
