package com.glen.demo;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Ehom {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File app=new File("/Users/jiapeng/Downloads/Picooc-release-picooc.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "44a394a6");
        capabilities.setCapability("app", app.getAbsolutePath()); 
        AppiumDriver driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        //AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement> (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(5000);
        try{
        	WebElement login=driver.findElement(By.id("com.picooc:id/login_text"));
        	login.click();
        	WebElement username=driver.findElement(By.id("com.picooc:id/email"));
        	username.click();
        	username.sendKeys("15011431611");
        	WebElement pwd=driver.findElement(By.id("com.picooc:id/pwd"));
        	pwd.sendKeys("a1234567");
        	WebElement loginbotton=driver.findElement(By.id("com.picooc:id/btn_login"));
        	loginbotton.click();
        	Thread.sleep(5000);
        	
        	        }catch(Exception e){
        	
        }

	}

}
