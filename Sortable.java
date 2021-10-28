package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
WebElement frame = driver.findElement(By.xpath("//iframe[@class = 'demo-frame']"));
	driver.switchTo().frame(frame);
	Actions builder = new Actions(driver);
	WebElement item2 = driver.findElement(By.xpath("//li[text() = 'Item 2']"));
	Point location = driver.findElement(By.xpath("//li[text() = 'Item 5']")).getLocation();
	int a = location.getX();
	int b = location.getY();
	builder.clickAndHold(item2).moveByOffset(a, b).release().perform();
	}

}
