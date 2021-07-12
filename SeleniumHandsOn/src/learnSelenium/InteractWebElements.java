package learnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InteractWebElements {

	static WebDriver driver = null;

	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dharm\\Downloads\\Webdriver\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.leafground.com/");
		driver.manage().window().maximize();
	}

	public static void verifyTextField() throws InterruptedException {
		driver.findElement(By.linkText("Edit")).click();
		Thread.sleep(3000);

		//Enter value to the text field
		driver.findElement(By.id("email")).sendKeys("selenium@gmail.com");	

		//Clear value from the text field
		driver.findElement(By.xpath("//input[@name='username' and @value ='Clear me!!']")).clear();

		//Verify Text field is enabled
		WebElement disabledField = driver.findElement(By.xpath("//input[@disabled='true']"));
		if(disabledField.isEnabled()) {
			System.out.println("Text field is enabled");

		}else
			System.out.println("Text field is disabled");
		
		//Get Text from Default field
		WebElement defaultField =driver.findElement(By.xpath("//input[@name='username' and @value='TestLeaf']"));
		String string = defaultField.getText().toString();
		System.out.println("Default Text value is "+string);
	}

	public static void tearDown() {
		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {
		openBrowser();
		verifyTextField();
		Thread.sleep(3000);
		tearDown();

	}
}
