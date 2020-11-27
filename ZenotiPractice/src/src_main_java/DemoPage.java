package src_main_java;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoPage extends BaseClass{
	WebDriver driver;
	Properties prop;
	public DemoPage() {
		try {
			prop= ReadingPropertiesFile.readFile(
					"C:/Users/shiule.maitra/Desktop/ZenotiPractice/src/" + "src_main_resources/propertiesFiles.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	public void navigatingToDemoPage(WebDriver driver) throws InterruptedException{
    driver.navigate().to("https://phptravels.com/demo");
   // Thread.sleep(2000);
	//driver.findElement(By.xpath((String)prop.get("DemoLink"))).click();
    Thread.sleep(2000);
    driver.manage().window().maximize();
	Actions action=new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath((String)prop.get("img")))).perform();
	
	driver.findElement(By.xpath((String)prop.get("img"))).click();
			}

}
