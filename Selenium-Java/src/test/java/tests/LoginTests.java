package tests;

import static org.testng.Assert.assertEquals;

//import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import io.cucumber.datatable.DataTable;
import pages.LandingPage;
import pages.LoginSignupPage;
import pages.NavigationBar;

public class LoginTests extends LandingPage{
	
	private NavigationBar navBar;
	private LoginSignupPage loginPage;
	public LoginTests(NavigationBar navBar, LoginSignupPage loginPage) { 
		this.navBar = navBar;
		this.loginPage = loginPage;
	}

	@Given("User navigates to Automationexercise website")
	public void userNavigatesToAutomationexerciseWebsite() {
	    goToLandingPage();
	}

	@And("User clicks on Signup / Login button")
	public void userClicksOnSignupLoginButton() {
		navBar.selectLoginSignup();
	}
	
	@And("User enters a valid username: {string}")
	public void userEntersAValidUsername(String username) {
		driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys(username);
	}

	@And("User enters a valid password: {string}")
	public void userEntersAValidPassword(String password) {
		driver.findElement(By.name("password")).sendKeys(password);
	}

	@When("User clicks Login button")
	public void userClicksLoginButton() {
		loginPage.clickLoginButton();
	}

	@Then("Login should be successfull")
	public void shoppingLandingPageIsVisible() {
		try {
			String loginMessage = driver.findElement(By.xpath("//a[contains(.,'Logged in as hakan')]")).getText();
			assertEquals(loginMessage, "Logged in as hakan");
			System.out.println(loginMessage);
			driver.quit();
			wait(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("Login should fail")
	public void loginShouldFail() {
		String text = driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']")).getText();
		Assert.assertEquals(text.trim(), "Your email or password is incorrect!"); // This is negative assertion
		driver.quit();
	}
	
	
}