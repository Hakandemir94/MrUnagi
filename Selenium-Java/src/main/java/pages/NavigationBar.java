package pages;

import org.openqa.selenium.By;

public class NavigationBar extends LandingPage{
	
	private By signupLogin = By.xpath("//a[normalize-space()='Signup / Login']");
	private By products = By.xpath("//a[.=' Products']");
	
	public LoginSignupPage selectLoginSignup() {
        driver.findElement(signupLogin).click();
        return new LoginSignupPage();
    }
	public ProductsPage selectProducts() {
        driver.findElement(products).click();
        return new ProductsPage();
	}
}