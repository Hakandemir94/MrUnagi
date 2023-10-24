package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LandingPage {
	
	protected static WebDriver driver;

	private void openBrowser() {
		try {
	    	System.setProperty("webdriver.chrome.driver", "E:\\web_development\\Java\\LambdaSelDemo\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Boolean goToLandingPage() {
		try {
			openBrowser();
			driver.get("https://www.automationexercise.com");
			System.out.println("WEBSITE TITLE: " + driver.getTitle());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void closeBrowser() {
        driver.quit();
    }
}