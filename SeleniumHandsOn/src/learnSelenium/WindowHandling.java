package learnSelenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowHandling {
	static WebDriver driver = null;

	public static void chromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dharm\\Downloads\\Webdriver\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();

	}

	public static void edgeBrowser() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\dharm\\Downloads\\Webdriver\\Edge\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();

	}
	
	//WindowHandles

	public static void openHomePage() {

		String parentWindow = driver.getWindowHandle();
		WebElement btnOpenHomePage = driver.findElement(By.xpath("//button[text()='Open Home Page']"));
		btnOpenHomePage.click();

		Set<String> allWindows = driver.getWindowHandles();

		for (String childWindow : allWindows) {
			driver.switchTo().window(childWindow);
			driver.manage().window().maximize();
		}
		WebElement btnEdit = driver.findElement(By.xpath("//*[@id='post-153']/div[2]/div/ul/li[1]/a/img"));
		btnEdit.click();
		driver.close();
		
		driver.switchTo().window(parentWindow);
		WebElement btnMultiWin = driver.findElement(By.xpath("//button[text()='Open Multiple Windows']"));
		btnMultiWin.click();
		driver.manage().window().maximize();
		
		int windowsCount= driver.getWindowHandles().size();
		System.out.println("Windows Opened "+windowsCount);
	}
	
	

	
	public static void tearDown() {
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		chromeBrowser();
		openHomePage();
		Thread.sleep(2000);
		tearDown();
		
	}

}
