package week4.day2;

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

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();

		// Launch the Driver

		ChromeDriver driver = new ChromeDriver();

		// Load the URL

		driver.get("https://www.snapdeal.com/");

		// Maximise the Browser

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Actions builder = new Actions(driver);
		// Go to Mens Fashion
		WebElement men = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		builder.moveToElement(men).perform();

		// 3. Go to Sports Shoes

		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		// 4. Get the count of the sports shoes
		String count = driver.findElement(By.xpath("//div[text()='Sports Shoes for Men']/following::div")).getText();
		System.out.println("To number of sparts shoes for Men: " + count);
		// 5. Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		// 6. Sort by Low to High
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		String text3 = driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).getText();
		driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();

		// 7. Check if the items displayed are sorted correctly

		String text = driver.findElement(By.xpath("//div[@class='sort-selected']")).getText();
		System.out.println(text);
		if (text.contains(text3))
			System.out.println("Shoes are sorted");
		else
			System.out.println("Shoes are not sorted");

		// 8.Select the price range (900-1200)
		WebElement pr1 = driver.findElement(By.xpath("//input[@name='fromVal']"));
		String text5 = pr1.getText();
		pr1.clear();
		pr1.sendKeys("900");

		WebElement pr2 = driver.findElement(By.xpath("//input[@name='toVal']"));
		String text6 = pr2.getText();
		pr2.clear();
		pr2.sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		Thread.sleep(5000);

		// 9.Filter with color Navy

		String text4 = driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).getText();
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		Thread.sleep(5000);

		// 10 verify the all applied filters
		String text2 = driver.findElement(By.xpath("//div[@class='filters']")).getText();
		System.out.println(text2);
		if (text2.contains("Navy") && text2.contains("1200"))
			System.out.println("All filters applied");
		else
			System.out.println("Filters are not applied");

		Thread.sleep(5000);

		// 11. Mouse Hover on first resulting Training shoes

		WebElement TraningShoe = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		builder.moveToElement(TraningShoe).perform();

		Thread.sleep(5000);
		// 12. click QuickView button
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		// 13. Print the cost and the discount percentage
		Set<String> w = driver.getWindowHandles();
		List<String> ww = new ArrayList<String>(w);
		String handle = ww.get(0);
		driver.switchTo().window(handle);
		Thread.sleep(5000);
		String co = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span")).getText();
		String cost = co.trim();
		System.out.println("Cost of shoe: " + cost);
		String percnt = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("Percentage off: " + percnt);

		// 14. Take the snapshot of the shoes.

		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./images/Shoes.png");
		FileUtils.copyFile(source, destination);
		// 15. Close the current window
		// 16. Close the main window

	}

}
