package Assignment.Week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/selectable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement item1 = driver.findElement(By.xpath("(//li[@class='ui-widget-content ui-selectee'])[1]"));
		WebElement item3 = driver.findElement(By.xpath("(//li[@class='ui-widget-content ui-selectee'])[3]"));
		WebElement item5 = driver.findElement(By.xpath("(//li[@class='ui-widget-content ui-selectee'])[5]"));
		
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(item1).click(item3).click(item5).perform();
		
		
	}
	

}
