package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra2 {

	public static void main(String[] args) throws InterruptedException, IOException {
WebDriverManager.chromedriver().setup();
		
		//Launch the Driver
		
		ChromeDriver driver=new ChromeDriver();
		
		//Load the URL
		
		driver.get(" https://www.myntra.com/");
		
		//Maximise the Browser
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions builder=new Actions(driver);
		
			//2) Mouse hover on MeN
		WebElement men = driver.findElement(By.xpath("//a[text()='Men']"));
		builder.moveToElement(men).perform();
		
		Thread.sleep(5000);
			//3) Click Jackets 
		driver.findElement(By.xpath("//a[text()='Jackets']")).click();
		
			//4) Find the total count of item 
		String itemCount = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		System.out.println("Total item: "+itemCount);
		Thread.sleep(5000);
			//5) Validate the sum of categories count matches
		String jack = driver.findElement(By.xpath("//span[@class='categories-num']")).getText();
		System.out.println(jack);
		String ja = jack.replace("(","");
		String ja1 = ja.replace(")","");
		String rainC = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		System.out.println(rainC);
		String ra = rainC.replace("(","");
		String ra1 = ra.replace(")","");
		int jack1=Integer.parseInt(ja1);
		int rainC1=Integer.parseInt(ra1);
		int sum=jack1+rainC1;
		String sumCac= Integer.toString(sum);
		//String sumCac1= "-"+" "+ sumCac+" "+"items";
		System.out.println("The sum of categories:"+sumCac);
		if(itemCount.contains(sumCac))
			System.out.println("Count is verified");
		else
			System.out.println("Count is unverified");
		
			//6) Check jackets
		driver.findElement(By.xpath("//div[@class='common-checkboxIndicator']")).click();
		Thread.sleep(5000);
		
			//7) Click + More option under BRAND
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		Thread.sleep(5000);
			//8) Type Duke and click checkbox
		driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("Duke");
		driver.findElement(By.xpath("//label[@class=' common-customCheckbox']")).click();
		Thread.sleep(5000);
		
			//9) Close the pop-up x
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
			//10) Confirm all the Coats are of brand DukeHint : use List 
		List<WebElement> w = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		int size=w.size();
		int count=0;
		for (WebElement coat : w) {
			if(coat.getText().contains("Duke"))
				count++;
			
		}
		if(size==count)
			System.out.println("All coats are of brand Duke");
		else
			System.out.println("You have choosed wrong brand");
		
			//11) Sort by Better Discount
		WebElement sort = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		builder.moveToElement(sort).perform();
		driver.findElement(By.xpath("//label[text()='Better Discount']")).click();
		
			//12) Find the price of first displayed item Click on the first product
		String text = driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
		System.out.println("Price: "+text);
		driver.findElement(By.xpath("//div[@class='product-productMetaInfo']")).click();
			//13) Take a screen shot
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination=new File("./images/Jackets.png");
		FileUtils.copyFile(source, destination);
			//14) Click on WishList Now
		driver.findElement(By.xpath("//span[text()='Wishlist']")).click();
			//15) Close Browser
	}

}