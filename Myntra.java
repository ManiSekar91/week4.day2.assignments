package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException, IOException {
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("https://www.myntra.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
WebElement men = driver.findElement(By.xpath("//a[text() = 'Men']"));
Actions builder = new Actions(driver);
builder.moveToElement(men).perform();
driver.findElement(By.xpath("//a[text() = 'Jackets']")).click();
WebElement items = driver.findElement(By.xpath("//span[@class = 'title-count']"));
String str = items.getText().replaceAll("\\D", "");
System.out.println("Total Jackets are: " + str);

Thread.sleep(2000);
String jacket1 = driver.findElement(By.xpath("//span[@class = 'categories-num']")).getText().replaceAll("\\D", "");
Integer category1 = Integer.parseInt(jacket1);
System.out.println("Category1 Jacket counts are: " + category1);

String jacket2 = driver.findElement(By.xpath("(//span[@class = 'categories-num'])[2]")).getText().replaceAll("\\D", "");
Integer category2 = Integer.parseInt(jacket2);

Integer sum = category1 + category2;

System.out.println("Category2 Jacket counts are: " + category2);

System.out.println("Category 1 + Category 2 : " + sum);

if (str.equals(sum)) 
{
	System.out.println("Sum of the Total Jacket are Same");
	
} else {
	System.out.println("Sum of the Total Jacket are Different");
} 
Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class = 'common-checkboxIndicator']")).click();
	driver.findElement(By.xpath("//div[@class = 'brand-more']")).click();
	driver.findElement(By.xpath("//input[@class = 'FilterDirectory-searchInput']")).sendKeys("Duke");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//label[@class = ' common-customCheckbox']")).click();
	driver.findElement(By.xpath("//span[@class = 'myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
	List<WebElement> count = driver.findElements(By.xpath("//h3[text() = 'Duke']"));
	for (WebElement webElement : count) {
		String str3 = webElement.getText();
	
	if (str3.equals("Duke")) {
		
	System.out.println("All the Brands are Duke");
	}
	else {
		System.out.println("All the Brands are not Duke");
	}
	WebElement sort = driver.findElement(By.xpath("//div[@class = 'sort-sortBy']"));
	Actions builder1 = new Actions(driver);
	builder1.moveToElement(sort).perform();
	driver.findElement(By.xpath("//label[text() = 'Better Discount']")).click();
	WebElement disprice = driver.findElement(By.xpath("//span[@class = 'product-discountedPrice']"));
	System.out.println("Discounted Price of the Product is:" + disprice.getText());
	driver.findElement(By.xpath("//span[@class = 'product-discountedPrice']")).click();
	Set<String> windowHandles = driver.getWindowHandles();
	List<String> winlist = new ArrayList<String>(windowHandles);
	driver.switchTo().window(winlist.get(1));
	File src = driver.getScreenshotAs(OutputType.FILE);
	File des = new File("./snaps/pic2.png");
	FileUtils.copyFile(src, des);
	driver.findElement(By.xpath("//span[text() = 'WISHLIST']")).click();
	driver.quit();
	}
}
}