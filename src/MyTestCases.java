import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MyTestCases {
	
	
	@BeforeMethod
	public void BeforeEachTest() throws MalformedURLException
	{
		String userName = "lujainalskran_yqo79J";
		String accessKey = "xM22Sb2h9f86TagJS3Ua";
		String browserStackURL = "https://"+ userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";
		driver = new AndroidDriver(new URL(browserStackURL), caps);
	}

	DesiredCapabilities caps = new DesiredCapabilities();
	
	String AppiumURL = "http://127.0.0.1:4723/wd/hub";
	
	AndroidDriver driver;
	
	
	@BeforeTest // run first
	public void MySetup()
	{
		caps.setCapability("platformName" , "Android");
		caps.setCapability("deviceName" , "Google Pixel 7 Pro");
		caps.setCapability("appiumVersion", "1.22.0");
		caps.setCapability("App" ,"bs://ef21b7207de7af40ce5d5233acd2bafc3ef6efc9" );
		
		
	}
	@Test(priority = 1 , enabled = false)
	public void ClickOnAllDigit() throws MalformedURLException 
	{
//		driver = new AndroidDriver(new URL(AppiumURL), caps);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
//		driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
//		driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
//		driver.findElement(By.id("com.google.android.calculator:id/digit_6")).click();
//		
//		driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
//		
		List<WebElement> buttons =  driver.findElements(By.className("android.widget.ImageButton"));
		for (int i =0 ; i< buttons.size() ; i++)
		{
			if (buttons.get(i).getAttribute("resource-id").contains("digit"))
			{
				buttons.get(i).click();
			}
			
		}
		
		String actual = driver.findElement(By.id("com.google.android.calculator:id/formula")).getText();
		String expected = "7894561230";
		
		Assert.assertEquals(actual, expected);
		
		
	}
	
	@Test(priority = 2 , enabled = true)
	public void ClickOnEvenNumbers() throws MalformedURLException 
	{
		//driver = new AndroidDriver(new URL(AppiumURL), caps);
	
		List<WebElement> buttons =  driver.findElements(By.className("android.widget.ImageButton"));
		for (int i=0 ; i<buttons.size() ; i++)
		{
			if (buttons.get(i).getAttribute("resource-id").contains("digit"))
			{
				String num = buttons.get(i).getAttribute("resource-id").replace("com.google.android.calculator:id/digit_", "");
				int n = Integer.parseInt(num);
				if (n%2 == 0)
				{
					buttons.get(i).click();
				}
				
			}
			
		}
		
		
		
		
	}
	
	
	
}
