package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManageContact {

	public static void main(String[] args) throws InterruptedException {
		
	    WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
	    driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
	    driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();      
	    driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
	    Set<String> wind = driver.getWindowHandles();
	    List<String>list=new ArrayList<String>(wind);
	    driver.switchTo().window(list.get(1));
	    driver.findElement(By.xpath("//a[@class='linktext']")).click();
	    driver.switchTo().window(list.get(0));       
	    driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	    Set<String> wind2 = driver.getWindowHandles();
	    List<String>list1=new ArrayList<String>(wind2);
	    driver.switchTo().window(list1.get(1));
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("(//table[@class = 'x-grid3-row-table'])[2]//a")).click();
	    driver.switchTo().window(list1.get(0));   
	    driver.findElement(By.linkText("Merge")).click();
	    Thread.sleep(3000);
		driver.switchTo().alert().accept();
		String title=driver.getTitle();
		System.out.println(title);
		String title2 = "Merge Contacts";
		boolean result = title.equals(title2);
		if(result == true)
			System.out.println("Title verified");
		else
			System.out.println("Title unverified");

	}

}