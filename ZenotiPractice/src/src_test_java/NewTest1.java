package src_test_java;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import src_main_java.BaseClass;
import src_main_java.DemoPage;
import src_main_java.LoginPage;
import src_main_java.NavigatingThroughLinks;
import src_main_java.RetryAnalyzer;

public class NewTest1 extends BaseClass{
	WebDriver driver;
	DemoPage demo;
	LoginPage login;
	NavigatingThroughLinks links;

	@BeforeSuite
	public void driverSetUp() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/shiule.maitra/Desktop/SeleniumDriver1/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.print("Executing NewTest1 BeforeSuite");
		//login = new LoginPage(driver);
		//login.SignUp_User(driver);

	}

	@Test
	public void validatingDemoPage() throws InterruptedException{
		System.out.print("Executing NewTest1 Test method");
		Assert.assertFalse(false);
		demo=new DemoPage();
		demo.navigatingToDemoPage(driver);
	}
	
	@AfterSuite
	public void endConnection() {
		System.out.print("Executing NewTest1 AfterSuite");
		driver.quit();
	}

}
