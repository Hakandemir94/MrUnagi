package tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import cucumber.api.java.en.*;
import pages.LandingPage;

public class AddToCartSteps extends LandingPage{

	public static WebDriver driver = new ChromeDriver();

	@Given("User enters valid {string} and {string}")
	public void userLoginsWithValidAnd(String username, String password) {
		try {
			System.out.println("cart test start");
			driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Given("User click on Products button")
	public void userClickOnProductsButton() {
		driver.findElement(By.xpath("//a[.=' Products']")).click();
	     
	}

	@Given("User searches for a {string}")
	public void userSearchesForA(String itemName) {
		driver.findElement(By.cssSelector("input[name='search']")).sendKeys(itemName);
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
	     
	}

	@When("User hovers over Add To Cart button")
	public void userHoversOverAddToCartButton() {
		Actions hover = new Actions(driver);
		WebElement Elem_to_hover = driver.findElement(By.id("id"));
		hover.moveToElement(Elem_to_hover);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//a[@data-product-id='1'])[2]")).click();
	}

	@When("User clicks on Add To Cart button on the dropped layout")
	public void userClicksOnAddToCartButtonOnTheDroppedLayout() {
		driver.findElement(By.xpath("(//a[@data-product-id='1'])[2]")).click();
	     
	}

	@Then("Confirmation message should pop-up")
	public void confirmationMessageShouldPopUp() {
		String confirmationText = driver.findElement(By.cssSelector("h4.modal-title.w-100")).getText();
		assertEquals(confirmationText, "Added!");
		System.out.println(confirmationText);
	}

}