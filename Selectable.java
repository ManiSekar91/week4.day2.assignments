package week4.day2.assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement frame = driver.findElement(By.xpath("//iframe[@class = 'demo-frame']"));
	driver.switchTo().frame(frame);
	WebElement item2 = driver.findElement(By.xpath("//li[text() = 'Item 2']"));
	WebElement item5 = driver.findElement(By.xpath("//li[text() = 'Item 5']"));
	Actions builder = new Actions(driver);
	builder.clickAndHold(item2).moveToElement(item5).release().perform();
	
	}

}
