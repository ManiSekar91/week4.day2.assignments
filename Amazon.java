package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("https://www.amazon.in/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']")).sendKeys("Oneplus 9 pro", Keys.ENTER);
String price = driver.findElement(By.xpath("//span[@class = 'a-price-whole']")).getText();
System.out.println("The mobile price is: " + price);
String cusrating = driver.findElement(By.xpath("//span[@class = 'a-size-base']")).getText();
	System.out.println("Total Customer Rating: " + cusrating);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//i[@class = 'a-icon a-icon-star-small a-star-small-4 aok-align-bottom']")).click();
//	Actions builder = new Actions(driver);
//	builder.moveToElement(star).perform();
	String percent_rating = driver.findElement(By.xpath("//span[@class = 'a-size-base']/a")).getAttribute("title");
	System.out.println("Total of 5 Star Rating Percentage is: " + percent_rating);
	
	driver.findElement(By.xpath("//span[@class = 'a-size-medium a-color-base a-text-normal']")).click();
	
	Set<String> winset = driver.getWindowHandles();
	List<String> winlist = new ArrayList<String>(winset);
	driver.switchTo().window(winlist.get(1));
	
	WebElement mobilepic = driver.findElement(By.xpath("//div[@id = 'imgTagWrapperId']"));
	File src = mobilepic.getScreenshotAs(OutputType.FILE);
	File des = new File("./snaps/amazon.png");
	FileUtils.copyFile(src, des);
	
	Thread.sleep(2000);
	driver.findElement(By.id("add-to-cart-button")).click();
	String finalprice = driver.findElement(By.xpath("//span[@id = 'attach-accessory-cart-subtotal']")).getText();
	if (price.contains(finalprice)) {
		System.out.println("The Cart Value is Same");
	}else {
		System.out.println("The Cart Value is Different");
	}
	}

}
