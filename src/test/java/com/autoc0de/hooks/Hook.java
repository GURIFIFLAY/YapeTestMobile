package com.autoc0de.hooks;


import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;



public class Hook {
    private static RemoteWebDriver driver;

    public static String screenshotdir = System.getProperty("user.dir")+"/test-output/screenshots/";
    File filePath = new File(System.getProperty("user.dir"));
    File appDir = new File(filePath, "src/test/resources/apps");
    File app = new File(appDir, "booking-com-32-9.apk");

    @Before
    public void setUp() throws MalformedURLException {
        //CAPABILITIES
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("app", app.getAbsolutePath());
        caps.setCapability("platformName", "Android");
        caps.setCapability("avd", "Pixel_6");
        caps.setCapability("resetKeyboard", "true");
        caps.setCapability("unicodeKeyboard", "true");
        caps.setCapability("appActivity", "");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("udid", "emulator-5556");
        caps.setCapability("appPackage", "com.booking");
        //URL APPIUM SERVER
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        //DRIVERS
        driver = new AndroidDriver<>(url, caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario s) throws IOException {

        if(s.isFailed()) {
            try {
                final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
                s.attach(screenshot, "image/png", s.getName());
            } catch (Exception e){
                getDriver().quit();
            }
        }
        getDriver().quit();
    }

    public static RemoteWebDriver getDriver()
    {
        return driver;
    }

}
