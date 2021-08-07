package learnSelenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {
	static WebDriver driver;
	
	public static void TC01_AlertBox() throws InterruptedException {		
		WebElement eleAlertBox = driver.findElement(By.xpath("//button[text()='Alert Box']"));
		eleAlertBox.click();
		Thread.sleep(5000);
		switchtoAlert();
	}

	public static void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dharm\\Downloads\\Webdriver\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.leafground.com");
		driver.manage().window().maximize();
		WebElement eleAlertPage = driver.findElement(By.xpath("//a[@href='pages/Alert.html']"));
		eleAlertPage.click();
	}
	
	public static void switchtoAlert() throws InterruptedException {
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert text: "+alertText);
		Thread.sleep(5000);
		alert.accept();
	}
	
	public static void tearDown() {
		driver.quit();
	}


	public static void main(String[] args) throws InterruptedException {
		launchBrowser();
		TC01_AlertBox();
		Thread.sleep(5000);
		tearDown();
	}
}
