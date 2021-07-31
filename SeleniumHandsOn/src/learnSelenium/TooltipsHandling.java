package learnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TooltipsHandling {

	static WebDriver driver = null;
	

	public static void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dharm\\Downloads\\Webdriver\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.leafground.com");
		driver.manage().window().maximize();

	}
	
	public static void fetchTooltipName() {	
		WebElement eleTooltiplink = driver.findElement(By.xpath("//a[@href='pages/tooltip.html']"));
		eleTooltiplink.click();	
		WebElement txtName = driver.findElement(By.xpath("//input[@id='age']")); 
		/*
		 * Actions action = new Actions(driver);
		 * action.moveToElement(txtName).perform();
		 */
		String txtTooltip = txtName.getAttribute("title");
		System.out.println("Tooltip Value: "+txtTooltip);
	}
	
	public static void tearDown() {
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		launchBrowser();
		fetchTooltipName();
		Thread.sleep(5000);
		tearDown();
	}
}
