package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectablejQuery {

	public static void main(String[] args) {
        
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/selectable/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions builder = new Actions(driver);
		
		driver.switchTo().frame(0);
		
		WebElement fe1 = driver.findElement(By.xpath("//ol/li[1]"));
		
		WebElement fe2 = driver.findElement(By.xpath("//ol/li[2]"));
		
		WebElement fe3 = driver.findElement(By.xpath("//ol/li[3]"));
		
		WebElement fe4 = driver.findElement(By.xpath("//ol/li[4]"));
		
		//builder.clickAndHold(fe1).dragAndDrop(fe2, fe4).perform(); //click&drag from 1-4 to select at a stretch
		
		builder.keyDown(Keys.CONTROL).click(fe1).click(fe2).click(fe3).click(fe4).keyUp(Keys.CONTROL).perform();
			
		
	}

}