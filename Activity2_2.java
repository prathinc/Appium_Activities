package AppiumSDETTest.AppiumTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2_2 {
	AppiumDriver<MobileElement> driver = null;
  @BeforeMethod
  public void beforeTest() throws MalformedURLException {
      // Set the Desired Capabilities
      DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceId", "2fb5cf35");
      caps.setCapability("deviceName", "OnePlus 6");
      caps.setCapability("platformName", "Android");
      caps.setCapability("appPackage", "com.oneplus.calculator");
      caps.setCapability("appActivity", "Calculator");
      caps.setCapability("noReset", true);

          // Initialize driver
      URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(appServer, caps);
  }
  
  @Test
  public void multiply()
  {
	  driver.findElement(By.id("com.oneplus.calculator:id/digit_5")).click();
	  driver.findElement(By.id("com.oneplus.calculator:id/op_mul")).click();
	  driver.findElement(By.id("com.oneplus.calculator:id/digit_1")).click();
	  driver.findElement(By.id("com.oneplus.calculator:id/digit_0")).click();
	  driver.findElement(By.id("com.oneplus.calculator:id/digit_0")).click();
	  driver.findElement(By.id("com.oneplus.calculator:id/result")).click();
	  
	  //getResult
	  String expected = "500";
	  String result = driver.findElement(By.id("com.oneplus.calculator:id/result")).getText();
	  Assert.assertEquals(result, expected,"Value is 500");
	  
  }
  
  @Test
  public void add()
  {
	  driver.findElement(By.id("com.oneplus.calculator:id/digit_5")).click();
	  driver.findElementByAccessibilityId("plus").click();
	  driver.findElement(By.id("com.oneplus.calculator:id/digit_9")).click();
	  driver.findElement(By.id("com.oneplus.calculator:id/result")).click();
	  
	  //getResult
	  String expected = "14";
	  String result = driver.findElement(By.id("com.oneplus.calculator:id/result")).getText();
	  Assert.assertEquals(result, expected,"Value is 14");
	  
  }
  
  @Test
  public void subtract()
  {
	  driver.findElement(By.id("com.oneplus.calculator:id/digit_1")).click();
	  driver.findElement(By.id("com.oneplus.calculator:id/digit_0")).click();
	  driver.findElementByAccessibilityId("minus").click();
	  driver.findElement(By.id("com.oneplus.calculator:id/digit_5")).click();
	  driver.findElement(By.id("com.oneplus.calculator:id/result")).click();
	  
	  //getResult
	  String expected = "5";
	  String result = driver.findElement(By.id("com.oneplus.calculator:id/result")).getText();
	  Assert.assertEquals(result, expected,"Value is 5");
	  
  }
  
  @Test
  public void division()
  {
	  driver.findElement(By.id("com.oneplus.calculator:id/digit_5")).click();
	  driver.findElement(By.id("com.oneplus.calculator:id/digit_0")).click();
	  driver.findElementByAccessibilityId("divide").click();
	  driver.findElement(By.id("com.oneplus.calculator:id/digit_2")).click();
	  driver.findElement(By.id("com.oneplus.calculator:id/result")).click();
	  
	  //getResult
	  String expected = "25";
	  String result = driver.findElement(By.id("com.oneplus.calculator:id/result")).getText();
	  Assert.assertEquals(result, expected,"Value is 25");
	  
  }
  @AfterMethod
  public void afterTest() {
	  driver.quit();
  }
}
