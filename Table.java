package Assignment.Week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {
	public static void main(String[] args) throws IOException{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		List<WebElement> col = driver.findElements(By.tagName("td"));
		System.out.println("No of colums "+col.size());
		
		List<WebElement> rows = driver.findElements(By.tagName("tr"));
		System.out.println("No of rows "+rows.size());
		
		String progress = driver.findElement(By.xpath("(//tr[@class='even'])[1]/td[2]")).getText();
		System.out.println("Get the progress value of 'Learn to interact with Elements' is "+progress);
		
		driver.findElement(By.xpath("(//tr[@class='even'])[2]//input")).click();
		
		File snap = driver.getScreenshotAs(OutputType.FILE);
		File image = new File("./snaps/img002.jpg");
		FileUtils.copyFile(snap, image);
	}
	

}
