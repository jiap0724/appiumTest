package com.glen.demo;

import java.net.URL;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.remote.MobileCapabilityType;


public class iOSTestcase {
	
	WebDriver driver;
    @Before
	public void setUp() throws Exception {
		// 配置设备、app、bundid、udid
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 5s");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		cap.setCapability(MobileCapabilityType.UDID, "91B26BEB-6251-49F9-A5D3-472E941021B0");
		cap.setCapability("bundleId", "com.picooc.international");
		cap.setCapability(MobileCapabilityType.APP, "/Users/jiapeng/Desktop/PICOOC.app");
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
    }

	/*
	 * 测试流程 打开app，点击登陆按钮，注入正确的用户名和密码，登陆成功后，点击设定，滑动到最底部，点击退出登录按钮 目标：验证登陆流程和退出登陆流程
	 */
    @Test
	public void test() throws Exception {

		WebElement allow = driver.findElement(By.name("Allow"));
		allow.click();
		Thread.sleep(2000);
		// 查找登录按钮
		WebElement login = driver.findElement(By.xpath(
				"//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeScrollView[1]/XCUIElementTypeButton[2]"));
		login.click();
		Thread.sleep(2000);

		// 输入密码
		WebElement password = driver.findElement(By.xpath(
				"//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeSecureTextField[1]"));
		password.sendKeys("ppp000");
		Thread.sleep(2000);

		// 输入用户名
		WebElement username = driver.findElement(By.xpath(
				"//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeTextField[1]"));
		username.clear();
		username.sendKeys("15210068667");
		Thread.sleep(2000);

		// 点击登录按钮
		WebElement loginbotton = driver.findElement(By.xpath(
				"//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[2]"));
		loginbotton.click();
		Thread.sleep(5000);

		// 点击设定
		WebElement setting = driver.findElement(By.xpath(
				"//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTabBar[1]/XCUIElementTypeButton[5]"));
		setting.click();

		// 向底部滑动 采用ios特有的scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		// 这里可以设置方向3
		scrollObject.put("direction", "down");
		// scrollObject.put("element", ((RemoteWebElementfacebook).getId());
		js.executeScript("mobile: scroll", scrollObject);

		// 点击推出登录按钮
		WebElement logout = driver.findElement(By.xpath(
				"//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeButton[1]"));
		logout.click();
		Thread.sleep(3000);

		// 点击弹框的ok按钮退出登录
		WebElement ok = driver.findElement(By.name("OK"));
		ok.click();
		Thread.sleep(2000);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
