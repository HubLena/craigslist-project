package testing_pack_part6;


import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Firebug {
 public static void main(String[] args) throws IOException {

  // Set Firebug and Firepath xpi file's path.
  // Note : both file's name and path should be proper. Please verify It twice.
  File firebug_path = new File("C:\\libs\\firebug-2.0.13-fx.xpi");
  File firepath_path = new File("C:\\libs\\firepath-0.9.7.1-fx.xpi");

  // Create firefox driver Instance profile.
  FirefoxProfile firefoxprofile = new FirefoxProfile();

  // Add Firebug add-on to new created profile of Firefox browser.
  firefoxprofile.addExtension(firebug_path);

  // Add FirePath add-on to new created profile of Firefox browser.
  firefoxprofile.addExtension(firepath_path);

  // Pass new created Firefox profile to the FirefoxDriver instance.
  WebDriver driver = new FirefoxDriver(firefoxprofile);
  driver.get("http://only-testing-blog.blogspot.in/2014/04/calc.html");
 }
}
