package com.instaAuto.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class driverFactory {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static void initDriver(String browser){
     if(browser.equalsIgnoreCase("chrome")){
        WebDriverManager.chromedriver().setup();
         driver.set(new ChromeDriver());
     }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
    public static void quit() {
        driver.get().quit();
        driver.remove();
    }

}
