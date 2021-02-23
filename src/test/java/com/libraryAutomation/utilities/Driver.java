package com.libraryAutomation.utilities;

import com.libraryAutomation.utilities.enumOptions.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static final ThreadLocal<WebDriver> driverPoll = new ThreadLocal<>();

    public static synchronized WebDriver getDriver() {
        if (driverPoll.get() == null) {
            Browser browser = Browser.valueOf(ConfigurationReader.getProperty("browser"));
            switch (browser) {
                case chrome:
                    WebDriverManager.chromedriver().setup();
                    driverPoll.set(new ChromeDriver());
                    driverPoll.get().manage().window().maximize();
                    driverPoll.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    break;
                case fireFox:
                    WebDriverManager.firefoxdriver().setup();
                    driverPoll.set(new FirefoxDriver());
                    driverPoll.get().manage().window().maximize();
                    driverPoll.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    break;
                case safari:
                    driverPoll.set(new SafariDriver());
                    driverPoll.get().manage().window().maximize();
                    driverPoll.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    break;
            }
        }
        return driverPoll.get();
    }

    public static void closeDriver() {
        if (driverPoll.get() != null) {
            driverPoll.get().quit();
            driverPoll.remove();
        }
    }

}
