package com.glen.demo;
/*
 * 2016-11-30
 * by jiapeng
 * 多次遍历文件apps中的渠道包，自动登录，然后卸载app
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

//测试用例
public class AndroidTestcase {
	private AppiumDriver driver;

	public void runTestCase() throws Exception {
		// 输出判断结果
		System.out.println("Result：" + driver.isAppInstalled("com.picooc"));

		// 判断是否安装成功
		Assert.assertEquals(driver.isAppInstalled("com.picooc"), true, "安装失败");

		// 点击登录按钮

		try {
			Thread.sleep(5000);
			// 点击登录按钮
			WebElement login = driver.findElement(By.id("com.picooc:id/login_text"));
			login.click();
			// 点击账号，输入账号
			WebElement username = driver.findElement(By.id("com.picooc:id/email"));
			username.click();
			username.sendKeys("15210068667");
			// 点击密码，输入密码
			WebElement pwd = driver.findElement(By.id("com.picooc:id/pwd"));
			pwd.sendKeys("poi098");
			// 点击登录
			WebElement loginbotton = driver.findElement(By.id("com.picooc:id/btn_login"));
			loginbotton.click();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 卸载app
		driver.removeApp("com.picooc");
		System.out.println("app已经卸载了");
	}

	@Test
	public void Test() throws Exception {

		// 设置启动的程序位置和程序的名字，循环安装各个渠道apk文件
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "./apps");
		File[] apks = appDir.listFiles();
		for (File apk : apks) {
			System.out.println("--------this:" + apk.getName());
			if (!apk.isDirectory() && apk.getName().endsWith("apk")) {

				// 设置设备的属性
				DesiredCapabilities capabilities = new DesiredCapabilities();

				capabilities.setCapability(CapabilityType.BROWSER_NAME, "");

				// 设置平台 Android
				capabilities.setCapability("platformName", "Android");

				// 设置设备的名称，真机或者模拟器的, 设备连接电脑，在命令行输入adb devices 查看即可
				capabilities.setCapability("deviceName", "1661625889");

				// 设置Android系统的版本号，例如 4.3 4.4
				capabilities.setCapability("platformVersion", "6.0");

				// 设置apk文件的路径
				capabilities.setCapability("app", apk.getAbsolutePath());

				// 设置apk的包名
				capabilities.setCapability("appPackage", "com.picooc");

				// 设置main Activity，例如 .mainNmae.activity 记得带上点
				capabilities.setCapability("appActivity", ".activity.start.WelcomeActivity");

				// waitActivity ，如果启动成功，没有影响，可以不填写
				capabilities.setCapability("appWaitActivity", "");

				// 设置UNicode键盘支持中文输入，会默认的代替内置的键盘
				capabilities.setCapability("unicodeKeyboard", "True");
				capabilities.setCapability("resetKeyboard", "True");

				try {

					// 加载驱动,ip,填写相应的ip和端口 例如 http://172.16.11.120:4720
					driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 调用测试case
				this.runTestCase();
				// 释放驱动
				driver.quit();
			}
		}

	}

}
