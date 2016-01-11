package testing_pack;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class elementScreenshot {
 WebDriver driver;
 @BeforeTest
 public void setup() throws Exception {
  driver =new FirefoxDriver();     
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get("http://only-testing-blog.blogspot.in/2014/09/selectable.html");
 }
 
 @Test
 public void captureScreenshot() throws Exception {
  //Locate Image element to capture screenshot.
        WebElement Image = driver.findElement(By.xpath("//img[@border='0']"));
        //Call captureElementScreenshot function to capture screenshot of element.
        captureElementScreenshot(Image);
 }
 
 public void captureElementScreenshot(WebElement element) throws IOException{
  //Capture entire page screenshot as buffer.
  //Used TakesScreenshot, OutputType Interface of selenium and File class of java to capture screenshot of entire page.
  File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
  
  //Used selenium getSize() method to get height and width of element.
  //Retrieve width of element.
  int ImageWidth = element.getSize().getWidth();
  //Retrieve height of element.
  int ImageHeight = element.getSize().getHeight();  
  
  //Used selenium Point class to get x y coordinates of Image element.
  //get location(x y coordinates) of the element.
  Point point = element.getLocation();
  int xcord = point.getX();
  int ycord = point.getY();
  
  //Reading full image screenshot.
  BufferedImage img = ImageIO.read(screen);
  
  //cut Image using height, width and x y coordinates parameters.
  BufferedImage dest = img.getSubimage(xcord, ycord, ImageWidth, ImageHeight);
  ImageIO.write(dest, "png", screen);
  
  //Used FileUtils class of apache.commons.io.
  //save Image screenshot In C: drive. C:\SQA Solution\backup\Training\Miscellaneous
  FileUtils.copyFile(screen, new File("C:\\SQA Solution\\backup\\Training\\Miscellaneous\\screenshot.png"));
 }
}
