package Assignment.Week4.day2;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import java.util.List;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement mensFashion = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
		Actions builder = new Actions(driver);
		builder.click(mensFashion).perform();
		
		WebElement sportsShoe = driver.findElement(By.xpath("(//span[@class='linkTest'])[1]"));
		builder.click(sportsShoe).perform();
		
		WebElement total = driver.findElement(By.xpath("//div[@class='sub-cat-count ']"));
		String subTotal = total.getText();
		System.out.println("Total of Men's Shoe "+subTotal);
		
		WebElement trainingShoe = driver.findElement(By.xpath("(//div[@class='child-cat-name '])[2]"));
		builder.click(trainingShoe).perform();
		
		Thread.sleep(3000);
		
		WebElement sortBy = driver.findElement(By.xpath("//div[contains(@class,'sort-drop')]/i"));
		builder.click(sortBy).perform();
		
		driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]")).click();
		
		List<WebElement> ps = driver.findElements(By.xpath("//span[contains(@class,'product-price')]"));
		
		List<String> obj = new ArrayList<String>();
		for (WebElement s : ps) {
			obj.add(s.getText());
		}
		
		System.out.println(obj);
		
		
		WebElement priceSort = driver.findElement(By.xpath("(//div[@class='price-text-box'])[1]/input"));
		priceSort.clear();
		priceSort.sendKeys("500",Keys.TAB);
		
		WebElement priceSort1 = driver.findElement(By.xpath("(//div[@class='price-text-box'])[2]/input"));
		priceSort1.clear();
		priceSort1.sendKeys("1200",Keys.ENTER);
		
		//driver.findElement(By.xpath("(//div[@class='filters-list sdCheckbox'])[5]")).click();
		
		List<WebElement> filters = driver.findElements(By.xpath("//div[@class='filters']"));
		List<String> filtered = new ArrayList<String>();
		
		for (WebElement s : filters) {
			filtered.add(s.getText());
		}
		
		System.out.println(filtered);
		
		WebElement product = driver.findElement(By.xpath("//p[@class='product-title']"));
		
		builder.moveToElement(product).perform();
		
		driver.findElement(By.xpath("(//div[@class='clearfix row-disc'])[1]/div")).click();
		
		List<WebElement> cost = driver.findElements(By.xpath("(//div[@class='lfloat'])[1]/div[2]"));
		List<String> price = new  ArrayList<String>();
		for (WebElement s : cost) {
			price.add(s.getText());
			
		}
		System.out.println(price);
		
		File snap = driver.getScreenshotAs(OutputType.FILE);
		File image = new File("./snaps/img003.jpg");
		FileUtils.copyFile(snap, image);
		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
