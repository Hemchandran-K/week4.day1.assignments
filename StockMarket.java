package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StockMarket {

	private static final WebElement Nsebulk = null;
	private static final int sizeOfrows = 0;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// load the url
		driver.get("https://www.chittorgarh.com/");
		// maximize the windows
		driver.manage().window().maximize();
		// add the wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// click on skip
		driver.findElement(By.xpath("//*[@id=\"splashBackURL\"]")).click();
		// click on stock market
		WebElement stockOption = driver.findElement(By.xpath("//a[text()='Stock Market']"));
		stockOption.click();
		// click on NSE bulk Deals
		WebElement NseBulk = driver.findElement(By.xpath("//a[text()= 'NSE BulkDeals']"));
		Nsebulk.click();

		Actions Builder = new Actions(driver);
		Thread.sleep(2000);
		Builder.moveToElement(NseBulk).click();
		// Security name
		String header = driver.findElement(By.linkText("Security Name")).getText();
		System.out.println(header);

		List<String> rowList = new ArrayList<String>();

		// Get all the Security names
		for (int i = 1; i < sizeOfrows; i++) {
			String names = driver.findElement(By.xpath("(//table)[2]//tr[" + i + "]/td[3]")).getText();
			System.out.println(names);
			rowList.add(names);
		}
		// Remove duplicate using set
		Set<String> dupnames = new LinkedHashSet<String>(rowList);
		int size = dupnames.size();
		System.out.println(size);

		// check whether the duplicates in security names
		if (rowList.size() == dupnames.size()) {
			System.out.println("It has no duplicates");
		} else {
			System.out.println("It has duplicates");
		}

	}

}
