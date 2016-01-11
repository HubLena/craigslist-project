package CraiglistSearch;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CraiglistSearch {

	static WebDriver driver;
	static WebDriverWait wait;
	static boolean start = true;
	
	private static HashSet<JavaPosition> positions = new HashSet<JavaPosition>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.ie.driver", "C://libs//IEDriverServer.exe");

		driver = new InternetExplorerDriver();
		//driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();

		wait = new WebDriverWait(driver, 10);
		driver.get("http://sfbay.craigslist.org/");
		driver.manage().window().maximize();

		javaSearch();

		while (start) {
			readData();
			start = gotoNextPage();
		}
		CreateOutputFile.outputFile(positions);
		
	}

	private static void javaSearch() {
		//find the job column
		By jobsLocator = By.xpath(".//*[@id='jjj']/h4/a");
		wait.until(ExpectedConditions.elementToBeClickable(jobsLocator));
		driver.findElement(jobsLocator).click();
		//find the search field 
		By queryLocator = By.name("query");
		wait.until(ExpectedConditions.visibilityOfElementLocated(queryLocator));
		driver.findElement(queryLocator).sendKeys("java");
		//find and click on Search button
		driver.findElement(By.className("searchbtn")).click();

	}

	private static boolean gotoNextPage() {
		boolean nextpageExists = false;

		// Scroll_Page2();

		try {
			By footerLocator = By.cssSelector(".center");
			wait.until(ExpectedConditions.elementToBeClickable(footerLocator));
			WebElement footer = driver.findElement(footerLocator);

			By nextpageLocator = By.cssSelector(".button.next");
			wait.until(ExpectedConditions.elementToBeClickable(nextpageLocator));
			footer.findElement(nextpageLocator).click();

			System.out.println("Next page...");

			Thread.sleep(5000L);
			nextpageExists = true;

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(" Expanded everything... ");
			nextpageExists = false;
		}
		return nextpageExists;
	}

	private static void Scroll_Page2() throws IOException, InterruptedException {
		// Scroll down to bottom of the page.
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
		Thread.sleep(3000);
	}

	private static void readData() {
		By formLocator = By.className("content");
		wait.until(ExpectedConditions.visibilityOfElementLocated(formLocator));

		WebElement searchform = driver.findElement(formLocator);

		By rowLocator = By.className("row");
		wait.until(ExpectedConditions.visibilityOfElementLocated(rowLocator));

		List<WebElement> resultList = searchform.findElements(rowLocator);
		System.out.println("Number of rows is " + resultList.size());

		for (int i = 0; i < resultList.size(); i++) {

			JavaPosition position = new JavaPosition();
//			try {
//				//need to capture the date when a position was posted
//				By dateLocator = By.cssSelector(".pl>time");
//				wait.until(ExpectedConditions.visibilityOfElementLocated(dateLocator));
//				String postedDate = resultList.get(i).findElement(dateLocator).getAttribute("datetime");
//				//System.out.println("Posted Date " + i + " " + postedDate);
//				
//				//find a position title
//				By titleLocator = By.className("hdrlnk");
//				wait.until(ExpectedConditions.elementToBeClickable(titleLocator));
//				WebElement title = resultList.get(i).findElement(titleLocator);
//				System.out.println("Title " + i + " " + title.getText());
//				
//				//capture location where a position is posted
//				By demogLocator = By.cssSelector(".pnr>small");
//				wait.until(ExpectedConditions.elementToBeClickable(demogLocator));
//				WebElement demog = resultList.get(i).findElement(demogLocator);

//				//populate position object
//				position.setPostedDate(postedDate);
//				position.setTitle(title.getText());
//				position.setDemographic(demog.getText());
//
//			} catch (Throwable t) {
//				// t.printStackTrace();
//			}
//			if (position.getTitle() != "No Title") {
//				positions.add(position);
//			}
		}
	}
}
