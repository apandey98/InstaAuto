package com.instaAuto.testcontext;

import com.instaAuto.config.ConfigManager;
import com.instaAuto.driver.driverFactory;
import org.openqa.selenium.WebDriver;

public class testContext {

    private WebDriver driver;
    public WebDriver getDriver() { return driver; }
    public void setDriver(WebDriver driver) { this.driver = driver; }

}
