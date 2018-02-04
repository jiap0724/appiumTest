package com.picooc.com;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class InitDriver {

	// Android配置
	public static AndroidDriver<AndroidElement> AndroidinitDriver() throws Exception {
		DesiredCapabilities caps = new DesiredCapabilities();

		// deviceName这个参数在安卓上的值可以随便写
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "c41a105d");
		// 表示指定连接的哪一台设备，值写设备的udid
		caps.setCapability(MobileCapabilityType.UDID, "c41a105d");
		// 测试引擎
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		// 被测试的app
		caps.setCapability(MobileCapabilityType.APP, "/Users/jiapeng/Desktop/release/android-release.apk");
		// 这个设置为true表示使用appium自带的unicode输入法，来支持键盘的隐藏以及中文输入
		caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
		caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
		// 不重置app应用
		caps.setCapability(MobileCapabilityType.NO_RESET, true);
		// 初始化driver
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		return driver;
	}
}
