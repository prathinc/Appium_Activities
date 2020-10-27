package AppiumSDETTest.AppiumTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2_3 {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait = null;
  @BeforeMethod
  public void beforeTest() throws MalformedURLException {
      // Set the Desired Capabilities
      DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceId", "2fb5cf35");
      caps.setCapability("deviceName", "OnePlus 6");
      caps.setCapability("platformName", "Android");
      caps.setCapability("appPackage", "com.oneplus.contacts");
      caps.setCapability("appActivity", ".activities.OPPeopleActivity");
      caps.setCapability("noReset", true);

          // Initialize driver
      URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(appServer, caps);
      wait = new WebDriverWait(driver, 5);
  }
  
  @Test
  public void createContact()
  {
	  driver.findElement(By.id("com.android.contacts:id/floating_action_button")).click();
	  driver.findElement(By.id("com.android.contacts:id/expansion_view")).click();
	  /*driver.findElementByXPath("//android.widget.LinearLayout/android.widget.EditText[2]").click();
	  MobileElement firstName = driver.findElementByXPath("//android.widget.LinearLayout/android.widget.EditText[2][@text()='First name']");
	  MobileElement lastName = driver.findElementByXPath("//android.widget.LinearLayout/android.widget.EditText[4][@text()='Surname']");
	  MobileElement phoneNumber = driver.findElementByXPath("//android.widget.LinearLayout/android.widget.EditText[@text()='Phone']");*/
	  
	  MobileElement firstName = driver.findElementByXPath("//android.widget.EditText[@text='First name']");
      MobileElement lastName = driver.findElementByXPath("//android.widget.EditText[@text='Surname']");
      MobileElement phoneNumber = driver.findElementByXPath("//android.widget.EditText[@text='Phone']");
	  firstName.sendKeys("Sriram");
	  lastName.sendKeys("SDET");
	  phoneNumber.sendKeys("9446566466");
	  
	  //save Contact
	  driver.findElementByXPath("//android.view.ViewGroup/android.widget.LinearLayout").click();
	  
	// Wait for contact card to appear
      wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.LinearLayout/android.widget.ScrollView")));
      
   
  }
  @AfterMethod
  public void afterTest() {
	  driver.quit();
  }
}
