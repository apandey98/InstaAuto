package com.instaAuto.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class basepage {

    protected WebDriver driver;
    protected utils.waitUtils waitUtil;

    public basepage(WebDriver driver) {
        this.driver = driver;
        this.waitUtil = new utils.waitUtils(driver);
    }

    protected void click(By locator) {
        waitUtil.waitForClickable(locator).click();
    }

    protected void type(By locator, String text) {
        waitUtil.waitForVisibility(locator).sendKeys(text);
    }

    protected String getText(By locator) {
        return waitUtil.waitForVisibility(locator).getText();
    }
}