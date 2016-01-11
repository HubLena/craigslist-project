package testing_pack_part6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLErrorInChrome {

 public static void main(String[] args) {

  //Set chrome browser's capabilities to to accept SSL certificate on runtime.
  DesiredCapabilities capability = DesiredCapabilities.chrome();
  capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

  WebDriver driver = new ChromeDriver(capability);
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  
  //Enter the URL of site where you facing SSL error.
  driver.get("https://www.google.com");
 }
}