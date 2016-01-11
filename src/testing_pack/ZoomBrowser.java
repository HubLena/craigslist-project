package testing_pack;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ZoomBrowser {
 WebDriver driver;
 
 @BeforeTest
 public void setup() throws Exception {
  driver = new FirefoxDriver();
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get("http://google.com/"); 
 }
 
 @Test
 public void getScrollStatus(){
  //Call zooming functions to zoom in and out page.
  zoomIn();  
  zoomOut();
  zoomOut();
  set100();
 }
 
 public void zoomIn(){
  //To zoom In page 4 time using CTRL and + keys.
  for(int i=0; i<4; i++){   
  driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
  }
 }
 
 public void zoomOut(){
  //To zoom out page 4 time using CTRL and - keys.
  for(int i=0; i<4; i++){
   driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  }
 }
 
 public void set100(){
  //To set browser to default zoom level 100%
  driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
 }
}