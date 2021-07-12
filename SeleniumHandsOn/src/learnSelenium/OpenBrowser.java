package learnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class OpenBrowser {
	static WebDriver driver = null;

	public static void chromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dharm\\Downloads\\Webdriver\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();

	}

	public static void edgeBrowser() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\dharm\\Downloads\\Webdriver\\Edge\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();

	}

	public static void tearDown() {
		
		driver.quit();
	}
	
	public static void searchOperation() {
		
		driver.findElement(By.name("q")).sendKeys("Chennai"+Keys.ENTER);
	}

	public static void main(String[] args) throws InterruptedException {

		// Launching Chrome browser
		chromeBrowser();
		searchOperation();
		Thread.sleep(2000); 
		tearDown();
		
		// Launching Edge browser
		edgeBrowser();
		searchOperation();
		Thread.sleep(3000); 
		tearDown();

	}

}
