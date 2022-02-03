package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {
	ChromeDriver driver;

	@Test
	public void main() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://developer.servicenow.com/");
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("sivamalar555@gmail.com");
		driver.findElement(By.xpath("//button[@id='usernameSubmitButton']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("siva@94");
		driver.findElement(By.xpath("//button[@id='submitButton']")).click();
		driver.get("https://dev111473.service-now.com/login.do?user_name=admin&sys_action=sysverb_login&user_password=f8iPAAGxT4cl");
		

	}

}