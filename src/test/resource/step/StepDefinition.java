package step;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
public class StepDefinition {
	
	 WebDriver driver;
	    WebDriverWait wait;

	    @Before
	    public void setup() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	    }

	    @Given("User is on the FR homepage")
	    public void user_is_on_fr_homepage() {
	        driver.get("https://www.americanexpress.com/fr-fr/?inav=NavLogo");
	    }

	    @When("User clicks on {string}")
	    public void user_clicks_on(String linkText) {
	        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText))).click();
	    }

	    @When("User clicks on {string} for Gold American Express card")
	    public void user_clicks_on_en_savoir_plus_for_gold_american_express() {
	        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("En Savoir Plus"))).click();
	    }

	    @When("User clicks on {string}")
	    public void user_clicks_on_button(String buttonText) {
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'" + buttonText + "')]"))).click();
	    }

	    @When("User fills in the application form with invalid details")
	    public void user_fills_application_form() {
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("firstName"))).sendKeys("dharanika");
	        driver.findElement(By.name("lastName")).sendKeys("Dhara");
	        driver.findElement(By.name("email")).sendKeys("dharani#gmail.com");
	        driver.findElement(By.name("fieldControl-input-dateOfBirth")).sendKeys("01/02/98");
	        driver.findElement(By.name("mobilePhoneNumber")).sendKeys("9565690960");  // Invalid number
	    }

	    @When("User clicks on {string}")
	    public void user_clicks_on_save_continue(String buttonText) {
	    	driver.findElement(By.xpath("//button[contains(text(),'Sauvegarder et Continuer')]")).click();
	    }

	    @Then("User should see a validation error message")
	    public void user_should_see_validation_error() {
	    }		

	    @After
	    public void teardown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}


