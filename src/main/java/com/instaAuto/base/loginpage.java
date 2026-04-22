package com.instaAuto.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginpage extends basepage {

    public loginpage(WebDriver driver) {
              super(driver);
    }
    private By homeloginButton=By.id("nav-user-login");
    private By username = By.id("email");
    private By password = By.id("password");
    private By login = By.xpath("//button[@type='submit']");
    //private By getTitle=By.xpath("//a[@id='nav-candidates-opportunities']");
    private By searchOtherJobs=By.xpath("//h6[contains(text(),'Search')]");
    private By skill=By.id("skills-selectized");
    private By showResult=By.id("show-results");
    private By totalJobCount=By.xpath("//p[@class='ng-binding']/span");
    private By listofJobs=By.xpath("//div[@class='container']");
    private By viewButton=By.xpath("(//button[@id='interested-btn'])[1]");
    private By applyButton=By.xpath("//button[@class='btn btn-lg btn-primary new-btn']");


      public void clickonfirstLogin(){
          click(homeloginButton);
      }
      public void setLogin(String user, String pass) {
          type(username,user);
          type(password,pass);
      }
      public void click_login() {
          click(login);
      }
    public void selectSkill() {
        waitUtil.waitForVisibility(searchOtherJobs).click();

        waitUtil.waitForVisibility(skill).sendKeys("Selenium");
        driver.findElement(skill).sendKeys(Keys.ENTER);

       //waitUtil.waitForVisibility(skill).sendKeys("Automation testing");
    }
//      public void clickShowResult() {
//          driver.findElement(showResult).click();
//      }
      public void getTotalJobCount() {
          driver.findElement(totalJobCount).getText();
      }
      public void checkJobAvailability() {
          driver.findElement(listofJobs).getText();
      }
      public void clickViewButton(){
          WebDriverWait ws=new WebDriverWait(driver,Duration.ofSeconds(10));
          ws.until(ExpectedConditions.visibilityOfElementLocated(viewButton)).click();

    }
    public void clickApplyButton(){
          WebDriverWait ws=new WebDriverWait(driver,Duration.ofSeconds(10));
          ws.until(ExpectedConditions.visibilityOfElementLocated(applyButton)).click();
          //driver.findElement(applyButton).click();
    }
    public void againClickOnApplyButton(){
        waitUtil.waitForVisibility(applyButton).click();
    }

}
