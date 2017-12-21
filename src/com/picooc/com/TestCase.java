package com.picooc.com;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/*
 * 这是测试case 
 */
public class TestCase {

	// android 设备登陆
	public static void AndroidLogin(AndroidDriver<AndroidElement> driver) throws Exception {
		// 在定位控件之前，一定要加上等待
		Thread.sleep(5000);
		// 定位登陆按钮，并点击
		AndroidElement login = driver.findElement(By.id("com.picooc:id/login_text"));
		// ("com.picooc:id/login_text");
		login.click();
		Thread.sleep(2000);
		// 定位username输入框，并输入username
		AndroidElement username = driver.findElementById("com.picooc:id/email");
		username.sendKeys("15210000000");
		Thread.sleep(2000);
		// 定位password输入框，并输入密码
		AndroidElement password = driver.findElementById("com.picooc:id/pwd");
		password.sendKeys("poi098");
		Thread.sleep(2000);
		// 点击登陆按钮
		AndroidElement loginbtu = driver.findElementById("com.picooc:id/btn_login");
		loginbtu.click();
		Thread.sleep(8000);
		// 判读上秤控件是否存在，如果存在，则登陆成功
		if (driver.getPageSource().contains("上秤")) {
				System.out.println("登陆成功！");
			} else{
				System.out.println("登陆失败");
			}
		Thread.sleep(5000);

	}

	// 滑动工具栏
	public static void tool(AndroidDriver<AndroidElement> driver) throws Exception {
		Thread.sleep(2000);
		AndroidElement tool1 = driver.findElement(By.id("com.picooc:id/pager_tool_pedometer"));
		// 向左滑动
		Swipe swipe = new Swipe(driver);
		// 向左滑动工具区三次
		for (int i = 0; i < 4; i++) {
			swipe.swipe_Left(500);
		}
		Thread.sleep(2000);
		// 左滑删除体重
		AndroidElement body_index = driver.findElement(By.id("com.picooc:id/relative"));
		swipe.swipe_Left(500);
		// 定位删除按钮并点击
		AndroidElement delete = driver.findElement(By.id("com.picooc:id/tv_delete"));
		delete.click();
		Thread.sleep(2000);
		//定位弹窗删除按钮并点击
		AndroidElement delete_button=driver.findElement(By.id("com.picooc:id/confirm_button"));
		delete_button.click();
		Thread.sleep(1000);
		File screen=driver.getScreenshotAs(OutputType.FILE);
		File screenFile = new File("/Users/jiapeng/Desktop/删除后.png");
		Thread.sleep(2000);
		

	}

	// 查看测量报告详情页 查看S博士并截屏，最后保存在本地

	public static void Body_index(AndroidDriver<AndroidElement> driver) throws Exception {
		Thread.sleep(5000);
		// 定位数据展示区，并点击
		AndroidElement data = driver.findElement(By.id("com.picooc:id/dyn_kg"));
		data.click();
		Thread.sleep(2000);
		// 查看S博士点评
		AndroidElement comment = driver.findElement(By.id("com.picooc:id/s_doctor_detail"));
		comment.click();
		Thread.sleep(2000);
		// 截屏并保存到指定文件中
		File screen = driver.getScreenshotAs(OutputType.FILE);
		File screenFile = new File("/Users/jiapeng/Desktop/S.png");
		try {
			FileUtils.copyFile(screen, screenFile);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// 向上滑动
		Swipe swipe = new Swipe(driver);
		swipe.swipe_Up(5000);
		Thread.sleep(2000);
		// 定位返回箭头，并点击
		AndroidElement back = driver.findElement(By.id("com.picooc:id/title_left"));
		back.click();
		Thread.sleep(2000);
		// 定位右上角分享按钮并点击
		AndroidElement right_share = driver.findElement(By.id("com.picooc:id/title_right"));
		right_share.click();
		Thread.sleep(5000);
		// 保存到手机里
		AndroidElement save = driver.findElement(By.id("com.picooc:id/share_save"));
		save.click();
		// 抓取toast 判断是否保存成功
		Thread.sleep(2000);
		String toast = "已经保存到系统相册";
		try {
			final WebDriverWait wait = new WebDriverWait(driver, 10);
			Assert.assertNotNull(wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'" + toast + "')]"))));
			System.out.println("找到了toast 保存成功");
		} catch (Exception e) {
			throw new AssertionError("找不到" + toast + "保存失败");
		}
		Thread.sleep(2000);
}


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = InitDriver.AndroidinitDriver();
		// AndroidLogin(driver);
		// Thread.sleep(2000);
		// Body_index(driver);

		tool(driver);
		Thread.sleep(2000);
		driver.quit();
	}
}
