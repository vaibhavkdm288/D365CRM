package Pages;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(xpath = "//input[@name='loginfmt']")
	WebElement username;

	@FindBy(xpath = "//input[@id='idSIButton9']")
	WebElement nextbtn;

	@FindBy(xpath = "//input[@name='passwd']")
	WebElement pass;

	@FindBy(xpath = "//input[@value='Sign in']")
	WebElement loginbtn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterValidLogin() throws IOException {
		username.sendKeys("vaibhavkadam@theiet.org");
		nextbtn.click();
		pass.sendKeys("Nectechnologies@123");


		FileReader reader = new FileReader(Paths.get("C:\\Users\\Vaibhav.Kadam\\OneDrive - NEC Software Solutions\\Desktop\\Login_Data.xlsx").toFile());
	    Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader().parse(reader);

	    for (CSVRecord record : records) {
	        String username = record.get("username");
	        String password = record.get("password");
	    }

	}

	public void clickLogin() {
		loginbtn.click();
	}

}
