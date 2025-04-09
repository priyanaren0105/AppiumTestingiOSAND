package mobileAutomation.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumiOSTest {
	
	@SuppressWarnings("deprecation")
	@Test
	public void AppiumTest() throws URISyntaxException, IOException
	{
		
		
		
			AppiumDriverLocalService service  = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
					.withIPAddress("127.0.0.1").usingPort(4723).build();
					
					//service.start();
					
			XCUITestOptions options = new XCUITestOptions();
			
			options.setDeviceName("iPhone 16 Pro");
			options.setPlatformVersion("18.3");
			options.setApp("/Users/pnarendran/eclipse-workspace/Appium/src/test/java/resources/mobiletestengtakehome.app");
			options.setCapability("noReset", true); // So it doesn't clear your session

			IOSDriver driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(),options);

			driver.startRecordingScreen();


			driver.findElement(By.xpath("//XCUIElementTypeTextField[@value='Email']")).sendKeys("TestUseriOS");
			driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@value='Password']")).sendKeys("Test1234");
			WebElement doneButton = driver.findElement(By.name("Return")); 
			doneButton.click();
			driver.findElement(By.xpath("//XCUIElementTypeOther[@name='Login']")).click();

			driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@name='Word Game'])[4]")).isDisplayed();
			driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@name=\"6 Guesses - Green: letter is in the correct location. Yellow: word contains letter, but it's in the wrong spot. Grey: letter is not used.\"])[2]")).isDisplayed();

			driver.findElement(By.xpath("//XCUIElementTypeOther[@name='⏎ Submit']")).isDisplayed();

			driver.findElement(By.xpath("//XCUIElementTypeOther[@name='RESET']")).isDisplayed();

			driver.findElement(By.xpath("//XCUIElementTypeOther[@name='← Delete']")).isDisplayed();

			driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Settings, tab, 2 of 2']")).click();

			driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@name='Settings'])[4]")).isDisplayed();

			driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@name='Dark Mode'])[2]")).isDisplayed();

			driver.findElement(By.xpath("//XCUIElementTypeOther[@name='Logout']")).isDisplayed();

			driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Word Game, tab, 1 of 2']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			String base64Video = driver.stopRecordingScreen();

			byte[] videoBytes = Base64.getDecoder().decode(base64Video);
			Files.write(Paths.get("test_run.mp4"), videoBytes);
			
			driver.quit();
			
			
	}

}