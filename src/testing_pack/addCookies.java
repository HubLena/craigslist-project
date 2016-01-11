package testing_pack;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class addCookies {
 WebDriver driver;
 
 @BeforeTest
 public void setup() throws Exception {
  driver = new FirefoxDriver();
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  driver.get("Your test site URL");
 }
 
 @Test
 public void addCookie(){
  //Set cookie value and then add It for current domain.
  Cookie name = new Cookie("testCookie", "WSfed-ffsd-234DFGe-YUTYU");
  driver.manage().addCookie(name);
  
  //Get all cookies and print them.
  Set<Cookie> totalCookies = driver.manage().getCookies();
  System.out.println("Total Number Of cookies : " +totalCookies.size());
  
  for (Cookie currentCookie : totalCookies) {
      System.out.println(String.format("%s -> %s -> %s", "Domain Name : "+currentCookie.getDomain(), "Cookie Name : "+currentCookie.getName(), "Cookie Value : "+currentCookie.getValue()));
  }  
 }
}
