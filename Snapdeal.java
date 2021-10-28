package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("https://www.snapdeal.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
WebElement menfashion = driver.findElement(By.xpath("//li[@class = 'navlink lnHeight']/a/span"));
	Actions builder = new Actions(driver);
	builder.moveToElement(menfashion).perform();
	driver.findElement(By.xpath("//span[text() = 'Sports Shoes']")).click();
	WebElement shoecount = driver.findElement(By.xpath("//span[@class = 'category-count']"));
	String str = shoecount.getText();
	System.out.println("Total Sports Shoe Count is: "+ str);
	driver.findElement(By.xpath("//div[text() = 'Training Shoes']")).click();
	Thread.sleep(5);
	
	driver.findElement(By.xpath("//span[@class = 'sort-label']")).click();
	
	driver.findElement(By.xpath("(//li[@data-index = '1'])[2]")).click();
	
	driver.findElement(By.xpath("//input[@name = 'fromVal']")).clear();
	driver.findElement(By.xpath("//input[@name = 'fromVal']")).sendKeys("900");
	
	driver.findElement(By.xpath("//input[@name = 'toVal']")).clear();
	driver.findElement(By.xpath("//input[@name = 'toVal']")).sendKeys("2500");
	
	driver.findElement(By.xpath("//div[@class= 'price-go-arrow btn btn-line btn-theme-secondary']")).click();
	
	
	Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for = 'Color_s-Navy']")).click();
		

	List<WebElement> appliedFilters = driver.findElements(By.xpath("//div[@class = 'filters']"));
	for (WebElement filter : appliedFilters) {
		String fil = filter.getText();
	System.out.println("Applied Filters are: " + fil);
	}
	
	
	WebElement quickview = driver.findElement(By.xpath("//div[@class = 'product-tuple-image ']"));
	Actions builder1 = new Actions(driver);
	builder1.moveToElement(quickview).perform();
	
	Thread.sleep(2000);

		driver.findElement(By.xpath("//div[contains(@class,'center quick-view-bar')]")).click();
	
		WebElement price = driver.findElement(By.xpath("//span[@class = 'payBlkBig']"));
		String str1 = price.getText();
		System.out.println("Price of the Shoe is: " + str1);
		
		WebElement disprice = driver.findElement(By.xpath("//span[@class = 'percent-desc ']"));
		String str2 = disprice.getText();
		System.out.println("Discount for the Shoe is: " + str2);
		
		WebElement shoescreenshot = driver.findElement(By.xpath("//img[@itemprop = 'image']"));
		File src = shoescreenshot.getScreenshotAs(OutputType.FILE);
		File des = new File("./snaps/shoe.png");
		FileUtils.copyFile(src, des);

		driver.quit();
	
	
	}

}
