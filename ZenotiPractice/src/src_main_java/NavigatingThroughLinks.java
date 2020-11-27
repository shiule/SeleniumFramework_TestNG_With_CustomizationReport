package src_main_java;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigatingThroughLinks extends BaseClass{
	WebDriver driver;
	Properties prop;

	public void menuLinks(WebDriver driver) throws InterruptedException {
		String[] tags = { "a", "div" };
		int j = 0;
		while (j < tags.length) {
			List<WebElement> elements = driver
					.findElements(By.xpath("//nav[@class='clearfix']/child::" + tags[j] + ""));
			for (int i = 1; i <= elements.size(); i++) {
				if (driver.findElement(By.xpath("//nav[@class='clearfix']/child::" + tags[j] + "[" + i + "]"))
						.isDisplayed()) {
					String text = driver
							.findElement(By.xpath("//nav[@class='clearfix']/child::" + tags[j] + "[" + i + "]"))
							.getText();
					System.out.println("The link for menu items" + " " + text);
					String pattern = "^(Features|Product|Company)$";
					if (text.matches(pattern)) {
						Alert alert;
						Actions action = new Actions(driver);
						action.moveToElement(driver
								.findElement(By.xpath("//nav[@class='clearfix']/child::" + tags[j] + "[" + i + "]")))
								.perform();
						List<WebElement> elements1 = driver.findElements(By.xpath("//nav[@class='clearfix']/child::"
								+ tags[j] + "[" + i + "]/" + "div[contains(@class,'dropdown-content')]/a"));
						for (int k = 1; k <= elements1.size(); k++) {
							WebDriverWait wait = new WebDriverWait(driver, 5);
							System.out.println(">> " + driver
									.findElement(By.xpath("//nav[@class='clearfix']/child::" + tags[j] + "[" + i + "]/"
											+ "div[contains(@class,'dropdown-content')]/a" + "[" + k + "]"))
									.getText());

						}
					}
				}
			}
			j++;
		}

	}
}
