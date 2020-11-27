package src_test_java;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import src_main_java.LoginPage;
import src_main_java.NavigatingThroughLinks;

public class NewTest {
	WebDriver driver;
	LoginPage login;
	NavigatingThroughLinks links;

	@BeforeSuite
	public void driverSetUp() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/shiule.maitra/Desktop/SeleniumDriver1/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.print("Executing NewTest BeforeSuite");
		login = new LoginPage(driver);
		login.SignUp_User(driver);
		

	}

	@Test(enabled=false)
	public void validatingMenus() throws InterruptedException {
		System.out.print("Executing NewTest Test Method");
		links = new NavigatingThroughLinks();
		links.menuLinks(driver);
	}

	@AfterSuite
	public void endConnection() {
		System.out.print("Executing NewTest AfterSuiteMethod");
		driver.quit();
	}
}
