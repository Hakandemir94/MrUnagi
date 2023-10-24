package tests;

//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import pages.LandingPage;
import pages.LoginSignupPage;
import pages.NavigationBar;
//import pages.ProductsPage;

public class LandingPageTest extends LandingPage{
	//protected ProductsPage productsPage;
	private NavigationBar navBar;
	private LoginSignupPage loginPage;
	public LandingPageTest(NavigationBar navBar, LoginSignupPage loginPage) {
		this.navBar = navBar;
		this.loginPage = loginPage;
	}


	@Before
    public void initialize() {
        //Assert.assertTrue(goToLandingPage(), "An error occurred while navigating to the the homepage");
        navBar = new NavigationBar();
        loginPage = new LoginSignupPage();
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}