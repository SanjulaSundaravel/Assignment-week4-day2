package Assignment.Week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {
	
	public static void main(String[] args){
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.switchTo().frame(0);
		
		WebElement resize = driver.findElement(By.xpath("(//div[contains(@class,'ui-resizable-handle')])[3]"));
		
		
		Actions builder = new Actions(driver);
		builder.clickAndHold(resize).moveByOffset(50,20).perform();

		
	}

}
