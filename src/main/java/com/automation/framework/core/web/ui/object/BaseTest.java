package com.automation.framework.core.web.ui.object;

import com.automation.framework.core.base.OrgBaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest extends OrgBaseTest {
    private static final Logger LOGGER = Logger.getLogger(BaseTest.class);

    protected WebDriver driver;

    @BeforeMethod
    public void runBeforeTest() {
        String path = System.getProperty("user.dir") + File.separator + "WebDriver" + File.separator + "chromedriver.exe";
        if (OS.isWindows())
            System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + File.separator + "WebDriver" + File.separator + "chromedriver.exe");
        else if (OS.isMac())
            System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + File.separator + "WebDriver" + File.separator + "chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void runAfterTest() {
        closeBrowser();
    }

    public void closeBrowser() {
        try {
            driver.quit();
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
        }
    }
}

class OS {
    private static String OS = System.getProperty("os.name").toLowerCase();
    public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}
	public static boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}
}
