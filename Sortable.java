package Assignment.Week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/sortable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		

		WebElement source = driver.findElement(By.xpath("//li[@class='ui-state-default ui-sortable-handle'][3]"));
		Point location = source.getLocation();
		int x = location.getX();
		int y = location.getY();
		WebElement pick = driver.findElement(By.xpath("//li[@class='ui-state-default ui-sortable-handle'][1]"));
		
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(pick, x, y).perform();
		
		
	}

}
