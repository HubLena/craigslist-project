package testing_pack_part6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEBrowserSampleTest {

 public static void main(String[] args) throws Exception {

  // Set path of IEDriverServer.exe.
  // Note : IEDriverServer.exe should be In D: drive.
  System.setProperty("webdriver.ie.driver", "C://libs//IEDriverServer.exe");

  // Initialize InternetExplorerDriver Instance.
  WebDriver driver = new InternetExplorerDriver();

  // Load sample calc test URL.
  driver.get("http://only-testing-blog.blogspot.com/2014/04/calc.html");

  // Execute sample calc test.
  driver.findElement(By.xpath("//input[@id='1']")).click();
  driver.findElement(By.xpath("//input[@id='plus']")).click();
  driver.findElement(By.xpath("//input[@id='6']")).click();
  driver.findElement(By.xpath("//input[@id='equals']")).click();
  String result = driver.findElement(By.xpath("//input[@id='Resultbox']")).getAttribute("value");
  System.out.println("Calc test result Is : " + result);
 // driver.close();
 }
}