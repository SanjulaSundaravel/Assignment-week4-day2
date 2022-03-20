package Assignment.Week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag {
	public static void main(String[] args){
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/drag.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement drag = driver.findElement(By.id("draggable"));
		
		Point location = drag.getLocation();
		int x = location.getX();
		int y = location.getY();
		
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(drag, x+100, y+100).perform();
		
	}

}
