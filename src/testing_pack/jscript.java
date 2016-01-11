package testing_pack;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class jscript {
 WebDriver driver;
 
 @BeforeTest
 public void setup() throws Exception {
  //Create new firefox custom profile.
  FirefoxProfile profile = new FirefoxProfile();
  //Disable javascript for newly created profile.
     profile.setPreference("javascript.enabled", false);
     //Use custom profile which has javascript disabled In webdriver launched browser.
     driver = new FirefoxDriver(profile);     
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
 }
 
 @Test
 public void getCoordinates(){
  //Click on button to get Javascript alert.
  driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();
  //Check If alert Is present or not.
  if(checkAlertPresent()){
   //If alert present then bellow given code will be executed.
   Alert alert = driver.switchTo().alert();
   System.out.println(alert.getText());   
   System.out.println("Alert present");
   alert.accept();
  }  
 }
 
 public boolean checkAlertPresent(){
   try{
    //It will return true If alert present.
    driver.switchTo().alert();
    return true;
   }catch(NoAlertPresentException ex){
    //It will return false If alert not present and print bellow given message In console.
    System.out.println("No Alert present. Verify If javascript Is disabled.");
    return false;
   }
 }
}