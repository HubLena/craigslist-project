package testing_pack;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Siblings_Table {
	WebDriver driver;
	
	 @BeforeTest
	 public void setup() throws Exception {
	  driver =new FirefoxDriver();     
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://only-testing-blog.blogspot.in/2015/01/table-with-checkbox.html");
	 }
	 
	 @Test
	 public void selectCheck(){
	  //Locating element using preceding-sibling In XPath.
	  driver.findElement(By.xpath("//td[contains(text(),'Cow')]/preceding-sibling::td/input[@type='checkbox']")).click();
	  //Locating element using following-sibling In XPath.
	  driver.findElement(By.xpath("//td[contains(text(),'Dog')]/following-sibling::td/input[@type='checkbox']")).click();  
	 }
	}