package testing_pack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Scrolling {
 
 WebDriver driver;
 
 
 @BeforeTest
 public void setup() throws Exception {
  driver =new FirefoxDriver();     
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get("http://only-testing-blog.blogspot.in");
 }
 
 @Test
 public void Scroll_Page() throws IOException, InterruptedException {
  //To scroll down web page by 600 pixels In x(vertical) direction.  
  //You can y parameter to scroll page In horizontal direction.
  JavascriptExecutor javascript = (JavascriptExecutor) driver;
  javascript.executeScript("window.scrollBy(0,600)", "");
  
  Thread.sleep(3000);
  
  //To scroll up web page by 300 pixels In x(vertical) direction.
  javascript.executeScript("window.scrollBy(0,-300)", "");
  }
 
 @Test
 public void Scroll_Page2() throws IOException, InterruptedException {
  //Scroll down to bottom of the page.
  JavascriptExecutor javascript = (JavascriptExecutor) driver;
  javascript.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");  
  
//Scroll till element.
//JavascriptExecutor je = (JavascriptExecutor) driver;
//WebElement element = driver.findElement(By.xpath("//div[@id='dragdiv']"));
//je.executeScript("arguments[0].scrollIntoView(true);",element);


 }
 
}
