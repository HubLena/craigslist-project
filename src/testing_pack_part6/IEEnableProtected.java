package testing_pack_part6;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEEnableProtected {

 public static void main(String[] args) throws Exception {

  // Set path of IEDriverServer.exe
  // Note : IEDriverServer.exe should be In D: drive.
  System.setProperty("webdriver.ie.driver", "C://libs//IEDriverServer.exe");

  // Set capability of IE driver to Ignore all zones browser protected mode settings.
  DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
  caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);

  // Initialize InternetExplorerDriver Instance using new capability.
  WebDriver driver = new InternetExplorerDriver(caps);
  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

  // Load sample calc test URL
  driver.get("http://only-testing-blog.blogspot.in/2014/04/calc.html");

  // Execute sample calc test.
  driver.findElement(By.xpath("//input[@id='1']")).click();
  driver.findElement(By.xpath("//input[@id='plus']")).click();
  driver.findElement(By.xpath("//input[@id='6']")).click();
  driver.findElement(By.xpath("//input[@id='equals']")).click();
  String result = driver.findElement(By.xpath("//input[@id='Resultbox']")).getAttribute("value");
  System.out.println("Calc test result Is : " + result);
  driver.close();
 }
}
