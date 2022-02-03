package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		List<WebElement> iframeCount = driver.findElements(By.tagName("iframe"));
		List<WebElement> count = new ArrayList<WebElement>();
		int total = 0;
		for (WebElement i : iframeCount) {
			count.add(i);
			total++;

		}

		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[@id='Click']")).click();
		File source = driver.getScreenshotAs(OutputType.FILE);
		File inside = new File("./images/button.png");
		FileUtils.copyFile(source, inside);
		driver.switchTo().defaultContent();

		driver.switchTo().frame(1);
		List<WebElement> iframeCount1 = driver.findElements(By.tagName("iframe"));
		List<WebElement> count1 = new ArrayList<WebElement>();

		for (WebElement i : iframeCount1) {
			count1.add(i);
			total++;

		}
		driver.switchTo().frame("frame2");
		driver.findElement(By.xpath("//button[@id='Click1']")).click();

		driver.switchTo().defaultContent();

		driver.switchTo().frame(2);
		List<WebElement> iframeCount2 = driver.findElements(By.tagName("iframe"));
		List<WebElement> count2 = new ArrayList<WebElement>();

		for (WebElement i : iframeCount2) {
			count2.add(i);
			total++;

		}
		System.out.println("Total number of iframe are: " + total);

	}

}