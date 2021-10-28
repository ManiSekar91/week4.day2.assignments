package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("https://www.nykaa.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
WebElement brand = driver.findElement(By.xpath("//a[text() = 'brands']"));
Actions builder = new Actions(driver);
builder.moveToElement(brand).perform();
driver.findElement(By.linkText("L'Oreal Paris")).click();
driver.findElement(By.xpath("//span[@class = 'sort-name']")).click();
driver.findElement(By.xpath("//span[text() = 'customer top rated']")).click();
driver.findElement(By.xpath("//span[text() = 'Category']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//span[text() = 'Hair']")).click();
driver.findElement(By.xpath("//span[text() = 'Hair Care']")).click();
driver.findElement(By.xpath("//span[text() = 'Shampoo']")).click();
driver.findElement(By.xpath("//span[text() = 'Concern']")).click();
driver.findElement(By.xpath("//span[text() = 'Color Protection']")).click();
List<WebElement> filterval = driver.findElements(By.xpath("//span[@class = 'filter-value']"));
for (WebElement webElement : filterval) {
	String str = webElement.getText();

System.out.println("Filters Applied for: " + str);

	}
Thread.sleep(2000);
driver.findElement(By.xpath("//div[@class = 'css-10zjw4o']")).click();
Set<String> windowHandles = driver.getWindowHandles();
List<String> winList = new ArrayList<String>(windowHandles);
driver.switchTo().window(winList.get(1));
driver.findElement(By.xpath("//select[@title = 'SIZE']")).sendKeys("175ml");
WebElement mrp = driver.findElement(By.xpath("//span[@class = 'css-12x6n3h']"));
String str = mrp.getText();
System.out.println("MRP of the product is: " + str);
Thread.sleep(2000);
driver.findElement(By.xpath("//span[@class = 'btn-text']")).click();
driver.findElement(By.xpath("//button[@class = 'css-5s18zx eoh7kvv0']")).click();
Thread.sleep(2000);
WebElement frame = driver.findElement(By.tagName("iframe"));
driver.switchTo().frame(frame);
WebElement grandtotal = driver.findElement(By.xpath("//div[@class = 'value medium-strong']"));
	String str1 = grandtotal.getText();
	System.out.println("Grand Total is: " + str1);
	driver.findElement(By.xpath("//span[text() = 'Proceed']")).click();
	driver.findElement(By.xpath("//button[@class = 'btn full big']")).click();
	WebElement grandtotal1 = driver.findElement(By.xpath("(//div[@class = 'value'])[2]"));
	String str2 = grandtotal1.getText();
	System.out.println("Grand Total in the final page is: " + str2);
	if (str1.equals(str2)) {
		System.out.println("Both the Values are Same");
		
	}else {
		System.out.println("Both the Values are different");
	}driver.quit();
	}
}
