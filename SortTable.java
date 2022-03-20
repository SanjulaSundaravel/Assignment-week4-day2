package Assignment.Week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortTable {
	public static void main(String[] args) throws IOException{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sorttable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		List<WebElement> list1 = driver.findElements(By.xpath("//tr[@role='row']/td[2]"));
		List<String> names1 = new ArrayList<String>();
		for (WebElement s : list1) {
			 names1.add(s.getText());
			
		}
		
		System.out.println(list1.size());
		System.out.println(names1);
		
		Collections.sort(names1);
		System.out.println(names1);
		
		driver.findElement(By.xpath("//th[text()='Name']")).click();
		
		List<WebElement> list2 = driver.findElements(By.xpath("//tr[@role='row']/td[2]"));
		List<String> names2 = new ArrayList<String>();
		for (WebElement s : list2) {
			 names2.add(s.getText());
			
		}
		
		System.out.println(list2.size());
		System.out.println(names2);
		
		if(names1.equals(names2)) {
			System.out.println("Names are sorted");
			
		}else {
			System.out.println("Names are not sorted");
		}
		
		File snap = driver.getScreenshotAs(OutputType.FILE);
		File image = new File("./snaps/img001.jpg");
		FileUtils.copyFile(snap, image);
		
		
		
		
	}

	
}
