package Assignment.Week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions builder = new Actions(driver);
		
		WebElement brand = driver.findElement(By.xpath("//ul[@class='HeaderNav css-f7ogli'][2]//a[1]"));
		Point location = brand.getLocation();
		int x = location.getX();
		int y = location.getY();
		
		builder.moveByOffset(x, y).clickAndHold().perform();
		
		 driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		 driver.findElement(By.xpath("//div[@class='css-ov2o3v'][1]/a")).click();
		 String title = driver.findElement(By.xpath("//h1[@class='css-mrgb7e'][1]")).getText();
		 System.out.println(title);
		 
		 driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		 WebElement sortBy = driver.findElement(By.xpath("(//label[contains(@class,'control-radio')])[4]/div[2]"));
		 builder.click(sortBy).perform();
		 
	    WebElement category = driver.findElement(By.xpath("(//div[contains(@class,'filter-open')])[1]"));
		builder.click(category).perform();
		WebElement hair = driver.findElement(By.xpath("(//div[@class=' css-b5p5ep'])[2]/span[2]"));
		builder.click(hair).perform();
		WebElement hairCare = driver.findElement(By.xpath("(//div[@class=' css-b5p5ep'])[1]/span[2]"));
		builder.click(hairCare).perform();
		WebElement shampoo = driver.findElement(By.xpath("//label[@for='checkbox_Shampoo_316']"));
		builder.click(shampoo).perform();
		
		WebElement concern = driver.findElement(By.xpath("((//div[@class='css-vuirr6'])[6]//div)[2]"));
		builder.click(concern).perform();
		WebElement colorProtection = driver.findElement(By.xpath("//label[contains(@for,'checkbox_Color')]/div[2]"));
		builder.click(colorProtection).perform();
		
		 List<WebElement> filtered = driver.findElements(By.xpath("//div[@class='css-rtde4j']/div"));
		 List<String> filters = new ArrayList<String>();
		 for (WebElement s : filtered) {
			 filters.add(s.getText());
			
		}
		 System.out.println(filters);
		 
		
		
		driver.findElement(By.xpath("(//a[@class='css-qlopj4'])[1]")).click();
		
		Set<String> noOfWindows = driver.getWindowHandles();
		List<String> newWindow = new ArrayList<String>();
		newWindow.addAll(noOfWindows);
		String newPage = newWindow.get(1);
		driver.switchTo().window(newPage);
		System.out.println(driver.getCurrentUrl());
		
		WebElement size = driver.findElement(By.xpath("//div[@class='css-11wjdq4']/select"));
		Select sc = new Select(size);
		sc.selectByVisibleText("175ml");
		
		String price = driver.findElement(By.xpath("//div[@class='css-f5j3vf']//span[2]")).getText();
		System.out.println("MRP is "+price);
		
		driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		
		driver.switchTo().frame(0);
		String grandTotal = driver.findElement(By.xpath("//div[@class='table-row ']/div[2]")).getText();
		System.out.println("Grand Total is "+grandTotal);
		
		driver.findElement(By.xpath("(//button[@type='button']//span[@class='vernacular-string'])[4]")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		
		String finalTotal = driver.findElement(By.xpath("(//div[contains(@class,'payment-details-tbl')])[4]/div[2]")).getText();
		
		if(finalTotal.equals(grandTotal)) {
			System.out.println("Amount is same");
			
		}else {
			System.out.println("Amount is not same");
		}
		
		driver.quit();	
		
	}

}
