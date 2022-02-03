package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		// Launch the Driver

		ChromeDriver driver = new ChromeDriver();

		// Load the URL

		driver.get("https://www.nykaa.com/");

		// Maximise the Browser

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Actions builder = new Actions(driver);
		// Mouseover on Brands and Search L'Oreal Paris
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		builder.moveToElement(brands).perform();
		// Click L'Oreal Paris
		driver.findElement(By.xpath("//div[@id='list_topbrands']/following::a[text()=\"L'Oreal Paris\"]")).click();
		// getTitle
		String title = driver.getTitle();
		System.out.println(title);
		if (title.contains("Paris"))
			System.out.println("Title is verified");
		else
			System.out.println("You are at wrong page");

		// Click sort By and select customer top rated
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();

		// Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();

		// Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		// check whether the Filter is applied with Shampoo
		String text = driver.findElement(By.xpath("//div[@class='css-1kwg5gr']/span")).getText();
		System.out.println(text);
		if (text.contains("Shampoo"))
			System.out.println("Fliter is applied");
		else
			System.out.println("Filter is not applied");

		// Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//div[contains(text(),'Protect')]")).click();

		// GO to the new window and select size as 175ml
		Set<String> w = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(w);
		String list1 = list.get(1);
		driver.switchTo().window(list1);
		WebElement dd = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select droDown = new Select(dd);
		droDown.selectByValue("1");
		// Print the MRP of the product
		String mrp = driver.findElement(By.xpath("//span[text()='MRP:']/following::span[1]")).getText();
		System.out.println(mrp);
		// Click on ADD to BAG
		driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
		// Go to Shopping Bag
		driver.findElement(By.xpath("//button[@type='button']")).click();
		// Print the Grand Total amount
		driver.switchTo().frame(0);
		String totalAmt = driver.findElement(By.xpath("(//span[text()='Grand Total'])[2]/following::div")).getText();
		System.out.println(totalAmt);
		// Click Proceed
		driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed ']")).click();
		driver.switchTo().defaultContent();

		// Click on Continue as Guest
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();

		// Check if this grand total is the same in step 14
		String grandTotal = driver.findElement(By.xpath("//div[text()='Grand Total']/following::div")).getText();
		System.out.println(grandTotal);
		if (grandTotal.contains(totalAmt))
			System.out.println("Both the totals tally");
		else
			System.out.println("Both the totals are not same");

	}

}
