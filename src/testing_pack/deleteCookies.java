package testing_pack;


import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class deleteCookies {
WebDriver driver;
 
 @BeforeTest
 public void setup() throws Exception {
  driver = new FirefoxDriver();
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  driver.get("your website name");
 }
 
 @Test
 public void deleteCookie(){
  
  //Add 2 test cookies for your domain.
  Cookie cookie1 = new Cookie("testCookie1", "WSfed-ffsd-234DFGe-YUTYU");
  Cookie cookie2 = new Cookie("testCookie2", "xxCDFSS-234DDs-423SS2-34EE");
  driver.manage().addCookie(cookie1);
  driver.manage().addCookie(cookie2);
  
  //Get and print all cookies for google domain after adding cookies manually.
  Set<Cookie> totalCookies1 = driver.manage().getCookies();
  System.out.println("Total Number Of cookies : " +totalCookies1.size());
  
  for (Cookie currentCookie : totalCookies1) {
      System.out.println(String.format("%s -> %s -> %s", "Domain Name : "+currentCookie.getDomain(), "Cookie Name : "+currentCookie.getName(), "Cookie Value : "+currentCookie.getValue()));
  }
  
  //Deleting specific testCookie2 cookie.
  System.out.println();
  driver.manage().deleteCookieNamed("testCookie2");
  
  //Get and print all cookies for google domain after deleting cookie manually.
  Set<Cookie> totalCookies2 = driver.manage().getCookies();
  System.out.println("Total Number Of cookies after deleting one cookie : " +totalCookies2.size());
  
  for (Cookie currentCookie : totalCookies2) {
      System.out.println(String.format("%s -> %s -> %s", "Domain Name : "+currentCookie.getDomain(), "Cookie Name : "+currentCookie.getName(), "Cookie Value : "+currentCookie.getValue()));
  } 
  
  //Deleting all cookies.
  System.out.println();
  driver.manage().deleteAllCookies();
  
  //Print number of cookies after deleting all cookies.
  Set<Cookie> totalCookies3 = driver.manage().getCookies();
  System.out.println("Total Number Of cookies after delete all cookies : " +totalCookies3.size());
    
 }
}