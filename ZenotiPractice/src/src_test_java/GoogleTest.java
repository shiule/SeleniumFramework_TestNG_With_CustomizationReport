package src_test_java;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleTest {
	WebDriver driver;
	WebDriverWait wait;
	boolean iframe_state;
	String parentWindow;

	//Launching the webdriver by setting the chrome driver property
	@BeforeSuite(groups="functional")
	public void setUp() {
		System.out.println("Entering BeforeSuite method");
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/shiule.maitra/Desktop/SeleniumDriver1/chromedriver.exe");
		driver = new ChromeDriver();
	}

	//Navigating to the google.com page and waiting till page loads
	@BeforeClass(groups="functional")
	public void launchBrowser() {
		System.out.println("Entering the BeforeClass method");
		driver.navigate().to("https://www.google.com/");
		
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Google apps']"))));
		
	}

	@BeforeMethod(groups="functional")
	public void navigateToGoogleApps() throws InterruptedException {
		System.out.println("Entering the Beforemethod");
		driver.findElement(By.xpath("//a[@title='Google apps']")).click();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//iframe[@role='presentation']"))));
	}
	
	@DataProvider(name="data")
	public static Object[][] object_data(){
		return new Object[][] {{"//span[text()='Gmail']","Gmail - Email from Google"},
			{"//span[text()='Account']","Google Account"}};
 
	}
		
	

	@Test(groups="functional",dataProvider="data")
//	@Parameters("navigationElement")
	public void navigatingToAccounts(String navigationElement,String title ) throws InterruptedException {
		System.out.println("Entering the Test method1");
		iframe_state = driver.findElement(By.xpath("//iframe[@role='presentation']")).isDisplayed();
		System.out.print(navigationElement+" "+title);
		if (iframe_state == true) {
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@role='presentation']")));
			driver.findElement(By.xpath(navigationElement)).click();
			Thread.sleep(4000);
		}
	//System.out.println(this.getClass().getEnclosingMethod().getName());
		Assert.assertEquals(driver.getTitle(), title);
	}
	
	@Test
	public void newTest(){
		//boolean a=1>2;
		Assert.fail();
	}
	

/**	@Test(dependsOnMethods={"navigatingToAccounts"},groups="regression")
	public void navigatingToGmail() {
		System.out.println("Entering the Test method2");
		iframe_state = driver.findElement(By.xpath("//iframe[@role='presentation']")).isDisplayed();
		if (iframe_state == true) {
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@role='presentation']")));
			driver.findElement(By.xpath("//span[text()='Gmail']")).click();
		}
		Assert.assertEquals(driver.getTitle(), "Gmail - Email from Google");
	}**/

	/**
	 * @throws InterruptedException
	 * @Test public boolean navigatingToAccounts(){
	 * 
	 *       System.out.print("Returning Method"); return false; }
	 **/

	@AfterMethod(groups="functional")
	public void afterMethod() throws InterruptedException {
		System.out.println("Entering the Aftermethod");
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	}

	@AfterClass(groups="functional")
	public void afterClass() {
		System.out.print("After Class");

	}

	@AfterSuite(groups="functional")
	public void afterSuite() {
		driver.quit();
	}

}
