package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.switchTo().frame(0);
		Actions builder=new Actions(driver);
		WebElement item1=driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item2=driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement item3=driver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement item4=driver.findElement(By.xpath("//li[text()='Item 4']"));
		WebElement item5=driver.findElement(By.xpath("//li[text()='Item 5']"));
		WebElement item6=driver.findElement(By.xpath("//li[text()='Item 6']"));
		WebElement item7=driver.findElement(By.xpath("//li[text()='Item 7']"));
		//builder.clickAndHold(item1);
		//builder.moveToElement(item6);
		//builder.release(item6);
		//builder.perform();
		builder.dragAndDrop(item3, item2).perform();
	}

}