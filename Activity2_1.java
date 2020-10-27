package AppiumSDETTest.AppiumTest;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Activity2_1 {
	AndroidDriver<MobileElement> driver = null;
	WebDriverWait wait = null;
	
	@BeforeTest
	  public void beforeTest() throws MalformedURLException {
		  DesiredCapabilities caps = new DesiredCapabilities();
		  caps.setCapability("deviceId", "2fb5cf35");
	      caps.setCapability("deviceName", "OnePlus 6");
		  caps.setCapability("platformName", "Android");
		  caps.setCapability("appPackage", "com.android.chrome");
		  caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		  caps.setCapability("noReset", true);

		  // Instantiate Appium Driver
		  URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		  driver = new AndroidDriver<MobileElement>(appServer, caps);
		  wait = new WebDriverWait(driver, 10);
	  }
	
  @Test
  public void WebApp() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// Open the browser with the URL
	  String websiteUrl = "https://www.training-support.net/selenium";
	  driver.get(websiteUrl);
	  
	// Wait for the page to load
      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View")));
	  
	  //Scroll TO DO List
      driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"To-Do List\"))")).click();
	  //add task
      
      driver.findElement(By.id("//android.view.View/android.view.View[3]/android.view.View[1]/android.widget.EditText"));
  }
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
