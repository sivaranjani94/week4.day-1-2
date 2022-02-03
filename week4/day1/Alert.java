package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
        org.openqa.selenium.Alert alert = driver.switchTo().alert();
        String value=alert.getText();
        System.out.println(value);
        alert.accept();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
        org.openqa.selenium.Alert alert2 = driver.switchTo().alert();
        String value1=alert2.getText();
        System.out.println(value1);
        alert2.accept();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
        org.openqa.selenium.Alert alert3 = driver.switchTo().alert();
        String value2=alert3.getText();
        System.out.println(value2);
        alert2.sendKeys("siva");
        alert2.accept();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
        org.openqa.selenium.Alert alert4 = driver.switchTo().alert();
        String value3=alert4.getText();
        System.out.println(value3);
        alert4.accept();
		
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
        driver.findElement(By.xpath("//button[text()='OK']")).click();

	}

}