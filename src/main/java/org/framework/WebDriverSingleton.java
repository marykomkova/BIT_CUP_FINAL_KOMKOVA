package org.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;

public class WebDriverSingleton {

    private static WebDriver driver;
    private static  ThreadLocal<WebDriverSingleton> instance = new ThreadLocal<>();

    private WebDriverSingleton() {
        File file = new File("IEDriverServer.exe");
        System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
        driver = new InternetExplorerDriver();
    }

    public static synchronized WebDriverSingleton getInstance() {
        if (instance.get() == null)
            instance.set(new WebDriverSingleton());
        return instance.get();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static void closeWebBrowser(){
        try {
            driver.quit();
        }
        finally {
            instance.remove();
        }
    }
}
