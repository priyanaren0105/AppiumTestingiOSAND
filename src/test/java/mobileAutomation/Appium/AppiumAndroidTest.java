package mobileAutomation.Appium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumAndroidTest {
	
	@SuppressWarnings("deprecation")
	@Test
	public void AppiumTest() throws URISyntaxException, IOException
	{
		
		
		
			AppiumDriverLocalService service  = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
					.withIPAddress("127.0.0.1").usingPort(4723).build();
					
					//service.start();
					
			UiAutomator2Options options = new UiAutomator2Options();
			
			options.setDeviceName("emulator-5554");
			options.setApp("//Users//pnarendran//eclipse-workspace//Appium//src//test//java//resources//app-debug.apk");
			options.setCapability("noReset", true); // So it doesn't clear your session

			AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);

			driver.startRecordingScreen();


			driver.findElement(By.xpath("//android.widget.EditText[@text='Email']")).sendKeys("TestUser");
			driver.findElement(By.xpath("//android.widget.EditText[@text='Password']")).sendKeys("Test1234");
			driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Login']")).click();

			driver.findElement(By.xpath("(//android.widget.TextView[@text='Word Game'])[1]")).isDisplayed();
			driver.findElement(By.xpath("//android.widget.TextView[@text=\"6 Guesses - Green: letter is in the correct location. Yellow: word contains letter, but it's in the wrong spot. Grey: letter is not used.\"]")).isDisplayed();

			driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='⏎ Submit']")).isDisplayed();

			driver.findElement(By.xpath("//android.widget.TextView[@text='RESET']")).isDisplayed();

			driver.findElement(By.xpath("//android.widget.TextView[@text='← Delete']")).isDisplayed();

			driver.findElement(By.xpath("//android.widget.TextView[@text='Settings']")).click();

			driver.findElement(By.xpath("(//android.widget.TextView[@text='Settings'])[1]")).isDisplayed();

			driver.findElement(By.xpath("//android.widget.TextView[@text='Dark Mode']")).isDisplayed();

			driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).isDisplayed();

			driver.findElement(By.xpath("//android.widget.TextView[@text='Word Game']")).click();

			
			String base64Video = driver.stopRecordingScreen();

			byte[] videoBytes = Base64.getDecoder().decode(base64Video);
			Files.write(Paths.get("test_run.mp4"), videoBytes);
			
			driver.quit();
			
			
	}

}