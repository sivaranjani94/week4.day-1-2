package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erailsort {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement from = driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
		from.clear();
		from.sendKeys("MS", Keys.TAB);
		WebElement to = driver.findElement(By.xpath("//input[@id='txtStationTo']"));
		to.clear();
		to.sendKeys("MDU", Keys.ENTER);
		int row = driver.findElements(By.xpath("//table[@class='DataTable DataTableHeader TrainList TrainListHeader']"))
				.size();
		System.out.println(row);
		List<String> trainNames = new ArrayList<String>();
		for (int i = 1; i <= row; i++) {

			String trains = driver
					.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr[" + i + "]/td[2]"))
					.getText();

			trainNames.add(trains);
		}

		System.out.println(row);
		Collections.sort(trainNames);

		System.out.println("No.of trains available:" + trainNames.size());

		System.out.println("List of trains:" + trainNames);

	}

}