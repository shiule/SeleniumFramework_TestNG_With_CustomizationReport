package src_main_java;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseClass{
	Properties prop = null;
	WebDriver driver = null;

	public LoginPage(WebDriver driver) throws IOException {
		prop = ReadingPropertiesFile.readFile(
				"C:/Users/shiule.maitra/Desktop/ZenotiPractice/src/" + "src_main_resources/propertiesFiles.properties");
	}

	public void SignUp_User(WebDriver driver) throws InterruptedException {

		driver.navigate().to(prop.getProperty("URL1"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleIs("Demo Script Test drive - PHPTRAVELS"));
		//driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		driver.manage().window().maximize();
/**		Thread.sleep(10000);

		/**
		 * Handling Windows tab String parentWindow=driver.getWindowHandle();
		 * ArrayList<String> tabs = new ArrayList<String>
		 * (driver.getWindowHandles()); int x=tabs.size(); System.out.print(x);
		 * for (int i=0;i<x;i++){ driver.switchTo().window(tabs.get(i));
		 * System.out.println(driver.getTitle()); } Iterator<String>
		 * it=tabs.iterator(); while(it.hasNext()){ String
		 * childWindow=it.next(); if(parentWindow.equals(childWindow)){
		 * Thread.sleep(3000); driver.switchTo().window(parentWindow);
		 * Thread.sleep(3000);
		 * 
		 * } }
		 **/
		//driver.findElement(By.xpath(prop.getProperty("Account_Dropdown_Btn"))).click();
		//System.out.print(prop.getProperty("Register_Btn"));
	/**	WebElement e1=driver.findElement(By.cssSelector("#inputEmail"));
        System.out.print(e1.isDisplayed());
		driver.findElement(By.id(prop.getProperty("inputFirstName"))).sendKeys("Shiule");
		driver.findElement(By.id(prop.getProperty("inputLastName"))).sendKeys("Maitra");
		driver.findElement(By.id(prop.getProperty("inputEmail"))).sendKeys("xy@gmail.com");
		driver.findElement(By.id(prop.getProperty("inputPhone"))).sendKeys("1234567890");
		driver.findElement(By.id(prop.getProperty("inputAddress1"))).sendKeys("Address 1");
		driver.findElement(By.id(prop.getProperty("inputCity"))).sendKeys("Hyderabad");
		WebElement password = driver.findElement(By.id(prop.getProperty("inputNewPassword1")));
		WebElement Confirmpassword = driver.findElement(By.id(prop.getProperty("inputNewPassword2")));
		password.sendKeys("xyz");
		Confirmpassword.sendKeys("xyz");
		String passwordStrength = driver.findElement(By.id(prop.getProperty("passwordStrengthTextLabel"))).getText();
		while (passwordStrength.contains("Poor")) {
			password.clear();
			Confirmpassword.clear();
			password.sendKeys("Hyderabad002");
			Confirmpassword.sendKeys("Hyderabad002");
		}**/
	}

}
