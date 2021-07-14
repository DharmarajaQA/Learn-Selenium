package learnSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchSuggestions {
	static WebDriver driver=null;
	public static void searchSuggestionsHandling() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dharm\\Downloads\\Webdriver\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();		
		driver.findElement(By.name("q")).sendKeys("World test championship");
		Thread.sleep(5000);
		List<WebElement> suggestionElementsList = driver.findElements(By.xpath("//ul[@role = 'listbox']//following::li"));
		
		for (WebElement allElements : suggestionElementsList) {
			String suggestiontext = allElements.getText();
			System.out.println(suggestiontext);
			
			if (suggestiontext.contains("india")) {
				allElements.click();
				break;
			}
		}
	
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		searchSuggestionsHandling();
	}

}
