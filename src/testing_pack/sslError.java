package testing_pack;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class sslError {
 
 public static void main(String[] args) {
  //Access firefox browser profile "certificateIssue" to use It In test.
   ProfilesIni firProfiles = new ProfilesIni();
   
   FirefoxProfile wbdrverprofile = firProfiles.getProfile("certificateIssue"); 
   
   wbdrverprofile.setAcceptUntrustedCertificates(true); 
   wbdrverprofile.setAssumeUntrustedCertificateIssuer(false);
   WebDriver Driver = new FirefoxDriver(wbdrverprofile); 
   
   Driver.get("site URL where certificate error");
  }
}
