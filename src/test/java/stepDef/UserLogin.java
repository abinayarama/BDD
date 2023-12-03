package stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserLogin {
	WebDriver driver=new ChromeDriver();
	WebElement user,pwd,submit,Msg;
	@Given("User is on Login Page")
	public void user_is_on_login_page() {
	    driver.get("https://practicetestautomation.com/practice-test-login/");
	    user=driver.findElement(By.id("username"));
	    pwd=driver.findElement(By.id("password"));
	    submit=driver.findElement(By.id("submit"));
	}
	@When("User enters credentials")
	public void user_enters_credentials() {
	    
	    user.sendKeys("student");
	    pwd.sendKeys("Password123");
	    submit.click();
	}
	@Then("Should display Home page")
	public void should_display_home_page() {
		Msg=driver.findElement(By.xpath("//strong"));
	    Assert.assertEquals(Msg, "Congratulations student. You successfully logged in!");
	}
}
