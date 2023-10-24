package pages;

import org.openqa.selenium.By;

public class LoginSignupPage extends LandingPage{
	
	private By loginPageMessage = By.xpath("//h2[text()='Login to your account']");
	private By loginButton = By.xpath("(//button[@class='btn btn-default'])[1]");
	
	public String getPageMessage() {
        return driver.findElement(loginPageMessage).getText();
	}
	public String getPageTitle() {
        return driver.getTitle();
    }
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
		}
}