package testing_pack_part6;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SSLErrorInIE {

 public static void main(String[] args) {  
  
  // Set path of IEDriverServer.exe
  // Note : IEDriverServer.exe should be In D: drive.
  System.setProperty("webdriver.ie.driver", "C://libs//IEDriverServer.exe");

  WebDriver driver = new InternetExplorerDriver();
  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  
  driver.get("URL of SSL error site");
  
  //To click on "Continue to this website (not recommended)." link to load original website.
  driver.navigate().to("javascript:document.getElementById('overridelink').click()");
 }
}