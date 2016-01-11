package miscellaneous;

import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

	//private static HashSet<JavaPosition> positions = new HashSet<JavaPosition>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.ie.driver", "C://libs//IEDriverServer.exe");

		// Initialize InternetExplorerDriver Instance.
		// WebDriver driver = new InternetExplorerDriver();
		// String PROXY = "localhost:8080";
		//
		// Proxy proxy = new Proxy();
		// proxy.setHttpProxy(PROXY)
		// .setFtpProxy(PROXY)
		// .setSslProxy(PROXY);
		// DesiredCapabilities cap = new DesiredCapabilities();
		// cap.setCapability(CapabilityType.PROXY, proxy);
		// cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		//// WebDriver driver = new FirefoxDriver(cap);
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().deleteAllCookies();

		// ChromeOptions options = new ChromeOptions();
		// // set some options
		// DesiredCapabilities dc = DesiredCapabilities.chrome();
		// dc.setCapability(ChromeOptions.CAPABILITY, options);
		// WebDriver driver = new RemoteWebDriver(dc);

		// System.setProperty("webdriver.chrome.driver",
		// "C://Program Files (x86)//Google//Chrome//Application/chrome.exe");
		// WebDriver driver=new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("http://sfbay.craigslist.org/");
		driver.manage().window().maximize();

		String currentWindow = driver.getWindowHandle();

		By jobsLocator = By.xpath(".//*[@id='jjj']/h4/a");
		wait.until(ExpectedConditions.elementToBeClickable(jobsLocator));
		driver.findElement(jobsLocator).click();

		By queryLocator = By.name("query");
		wait.until(ExpectedConditions.visibilityOfElementLocated(queryLocator));
		driver.findElement(queryLocator).sendKeys("java");

		driver.findElement(By.className("searchbtn")).click();

		// By formLocator = By.xpath(".//*[@id='searchform']/div[2]/div[3]");
		// <div class="content"
		By formLocator = By.className("content");
		wait.until(ExpectedConditions.visibilityOfElementLocated(formLocator));

		WebElement searchform = driver.findElement(formLocator);

		By rowLocator = By.className("row");
		wait.until(ExpectedConditions.visibilityOfElementLocated(rowLocator));

		List<WebElement> resultList = searchform.findElements(rowLocator);
		System.out.println("Number of rows is " + resultList.size());

		while (true) {
			try {

				for (int i = 0; i < resultList.size() - 1; i++) {

					//JavaPosition position = new JavaPosition();
					try {
						By titleLocator = By.className("hdrlnk");
						wait.until(ExpectedConditions.elementToBeClickable(titleLocator));
						WebElement title = resultList.get(i).findElement(titleLocator);
						System.out.println("Title " + i + " " + title.getText());

						By demogLocator = By.cssSelector(".pnr>small");
						wait.until(ExpectedConditions.elementToBeClickable(demogLocator));
						WebElement demog = resultList.get(i).findElement(demogLocator);

						System.out.println("Demographic " + i + " " + demog.getText());

//						position.setTitle(title.getText());
//						position.setDemographic(demog.getText());

					} catch (Throwable t) {
						// t.printStackTrace();
					}
//					if (position.getTitle() != "No Title") {
//						positions.add(position);
//					}
				}

				By nextpageLocator = By.xpath(".button.next");
				wait.until(ExpectedConditions.elementToBeClickable(nextpageLocator));
				driver.findElement(nextpageLocator).click();
				
				System.out.println("Next page...");
				Thread.sleep(5000L);

			} catch (Throwable t) {
				System.out.println(" Expanded everything... ");
				break;
			}
		}

	}
}
