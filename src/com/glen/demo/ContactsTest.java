package com.glen.demo;

import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;  
import org.openqa.selenium.*; 
import org.openqa.selenium.interactions.HasTouchScreen; 
import org.openqa.selenium.interactions.TouchScreen; 
import org.openqa.selenium.remote.RemoteTouchScreen; 
import org.openqa.selenium.remote.RemoteWebDriver; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities; 
import java.io.File;  
import java.net.URL;  
import java.util.List;

public class ContactsTest {
    private AppiumDriver driver; 
    @Before
    public void setUp() throws Exception {
        //设置apk的路径
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "ContactManager.apk");
               
        //设置自动化相关参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "44a394a6");
        
        //设置安卓系统版本
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability(CapabilityType.PLATFORM,"WINDOWS");
        //设置apk路径
        capabilities.setCapability("app", app.getAbsolutePath()); 
        
        //设置app的主包名和主类名
        capabilities.setCapability("appPackage", "com.example.android.contactmanager");
        capabilities.setCapability("appActivity", ".ContactManager");
        
        //初始化
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);       
    }

    
    @Test
  public void addContact(){
      WebElement el = driver.findElement(By.id("com.example.android.contactmanager:id/addContactButton"));
      el.click();
      WebElement username =driver.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText"));
      username.click();
      username.sendKeys("jiapeng");
      
      WebElement save =driver.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText"));
      username.click();
      username.sendKeys("jiapeng");
      
      //      List<WebElement> textFieldsList = driver.findElements(By.tagName("textfield"));
//      textFieldsList.get(0).sendKeys("Jiapeng");
//      textFieldsList.get(2).sendKeys("jiapeng@qq.com");
		driver.findElement(By.id("com.example.android.contactmanager:id/contactSaveButton")).click();
  }

   
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}





/*
 * 这是从51testing上下载的测试代码*
 */




//import org.junit.After;
// import org.junit.Before;
// import org.junit.Test;
// import org.openqa.selenium.*;
// import org.openqa.selenium.interactions.HasTouchScreen;
// import org.openqa.selenium.interactions.TouchScreen;
// import org.openqa.selenium.remote.CapabilityType;
// import org.openqa.selenium.remote.DesiredCapabilities;
// import org.openqa.selenium.remote.RemoteTouchScreen;
// import org.openqa.selenium.remote.RemoteWebDriver;
// import java.io.File;
// import java.net.URL;
// import java.util.List;
//
// public class ContactsTest {
//     private WebDriver driver;
//
//     @Before
//     public void setUp() throws Exception {
//         // set up appium
//         File classpathRoot = new File(System.getProperty("user.dir"));
//         File appDir = new File(classpathRoot, "apps/ContactManager");
//         File app = new File(appDir, "ContactManager.apk");
//         DesiredCapabilities capabilities = new DesiredCapabilities();
//         capabilities.setCapability("device","Android");
//         capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
//         capabilities.setCapability(CapabilityType.VERSION, "4.4");
//         capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");
//         capabilities.setCapability("app", app.getAbsolutePath());
//         capabilities.setCapability("app-package", "com.example.android.contactmanager");
//         capabilities.setCapability("app-activity", ".ContactManager");
//         driver = new SwipeableWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//     }
//
//     @After
//     public void tearDown() throws Exception {
//         driver.quit();
//     }
//
//     @Test
//     public void addContact(){
//         WebElement el = driver.findElement(By.name("Add Contact"));
//         el.click();
//         List<WebElement> textFieldsList = driver.findElements(By.tagName("textfield"));
//         textFieldsList.get(0).sendKeys("Some Name");
//         textFieldsList.get(2).sendKeys("Some@example.com");
//         driver.findElement(By.name("Save")).click();
//     }
//
//     public class SwipeableWebDriver extends RemoteWebDriver implements HasTouchScreen {
//         private RemoteTouchScreen touch;
//
//         public SwipeableWebDriver(URL remoteAddress, Capabilities desiredCapabilities) {
//             super(remoteAddress, desiredCapabilities);
//             touch = new RemoteTouchScreen(getExecuteMethod());
//         }
//
//         public TouchScreen getTouch() {
//             return touch;
//         }
//     }
// }



/*
 * demo3 *
 */


//package com.Demo;

//
//import io.appium.java_client.AppiumDriver;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
// 
//import java.io.File;
//import java.net.URL;
//import java.util.List;
// 
//public class ContactsTest {
//    private AppiumDriver driver;
// 
//    @Before
//    public void setUp() throws Exception {
//        // set up appium
//        File classpathRoot = new File(System.getProperty("user.dir"));
//        File appDir = new File(classpathRoot, "apps");
//        File app = new File(appDir, "ContactManager.apk");
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("deviceName","Android Emulator");
//        capabilities.setCapability("platformVersion", "4.4");
//        capabilities.setCapability("app", app.getAbsolutePath());
//        capabilities.setCapability("appPackage", "com.example.android.contactmanager");
//        capabilities.setCapability("appActivity", ".ContactManager");
//        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//    }
// 
//    @After
//    public void tearDown() throws Exception {
//        driver.quit();
//    }
// 
//    @Test
//    public void addContact(){
//        WebElement el = driver.findElement(By.name("Add Contact"));
//        el.click();
//        List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
//        textFieldsList.get(0).sendKeys("Some Name");
//        textFieldsList.get(2).sendKeys("Some@example.com");
//        driver.swipe(100, 500, 100, 100, 2);
//        driver.findElementByName("Save").click();
//    }
//}




/* 
 * 博客园代码*/

//package com.glen.demo;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.*;
//import org.openqa.selenium.interactions.HasTouchScreen;
//import org.openqa.selenium.interactions.TouchScreen;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteTouchScreen;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import java.io.File;
//import java.net.URL;
//import java.util.List;
//
//public class ContactsTest {
//    private WebDriver driver;
//
//    @Before
//    public void setUp() throws Exception {
//        // set up appium
//        File classpathRoot = new File(System.getProperty("user.dir"));
//        File appDir = new File(classpathRoot, "apps");
//        File app = new File(appDir, "ContactManager.apk");
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("device","Android");
//        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
//        capabilities.setCapability("deviceName","44a394a6");
//        capabilities.setCapability(CapabilityType.VERSION, "4.4");
//        capabilities.setCapability(CapabilityType.PLATFORM, "Android");
//        capabilities.setCapability("app", app.getAbsolutePath());
//        capabilities.setCapability("app-package", "com.example.android.contactmanager");
//        capabilities.setCapability("app-activity", ".ContactManager");
//        driver = new SwipeableWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        driver.quit();
//    }
//
//    @Test
//    public void addContact(){
//        WebElement el = driver.findElement(By.name("Add Contact"));
//        el.click();
//        List<WebElement> textFieldsList = driver.findElements(By.tagName("textfield"));
//        textFieldsList.get(0).sendKeys("Some Name");
//        textFieldsList.get(2).sendKeys("Some@example.com");
//        driver.findElement(By.name("Save")).click();
//    }
//
//    public class SwipeableWebDriver extends RemoteWebDriver implements HasTouchScreen {
//        private RemoteTouchScreen touch;
//
//        public SwipeableWebDriver(URL remoteAddress, Capabilities desiredCapabilities) {
//            super(remoteAddress, desiredCapabilities);
//            touch = new RemoteTouchScreen(getExecuteMethod());
//        }
//
//        public TouchScreen getTouch() {
//            return touch;
//        }
//    }
//}
