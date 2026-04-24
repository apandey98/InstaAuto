package com.instaAuto.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class loginpage extends basepage {

    public loginpage(WebDriver driver) {
              super(driver);
    }
    private By homeloginButton=By.id("nav-user-login");
    private By username = By.xpath("//input[@name='email']");
    private By password = By.id("password");
    private By login = By.xpath("//button[@type='submit']");
    //private By getTitle=By.xpath("//a[@id='nav-candidates-opportunities']");
    private By searchOtherJobs=By.xpath("//h6[contains(text(),'Search')]");
    private By skill=By.id("skills-selectized");
    //private By showResult=By.id("show-results");
    private By totalJobCount=By.xpath("//p[@class='ng-binding']/span");
    private By listofJobs=By.xpath("//div[@class='container']");
    private By viewButton=By.xpath("(//button[@id='interested-btn'])[1]");
    private By applyButton=By.xpath("//button[@class='btn btn-lg btn-primary new-btn']");


      public void clickonfirstLogin(){
          click(homeloginButton);
      }
    public void setLogin(String user, String pass) {

        WebElement emailField = waitUtil.waitForVisibility(username, 10);

        // Step 1: Try normal input first
        for (int i = 0; i < 3; i++) {

            emailField.click();
            emailField.sendKeys(Keys.CONTROL + "a");
            emailField.sendKeys(Keys.DELETE);
            emailField.sendKeys(user);

            // small wait for JS override
            try { Thread.sleep(500); } catch (Exception e) {}

            String value = emailField.getAttribute("value");

            if (user.equals(value)) {
                break; // success
            }
        }

        // Step 2: FINAL fallback (JS hard set)
        if (!user.equals(emailField.getAttribute("value"))) {

            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript(
                    "arguments[0].value = arguments[1];" +
                            "arguments[0].dispatchEvent(new Event('input',{bubbles:true}));" +
                            "arguments[0].dispatchEvent(new Event('change',{bubbles:true}));",
                    emailField,
                    user
            );
        }

        // Step 3: VERIFY AGAIN (CRITICAL)
        if (!user.equals(emailField.getAttribute("value"))) {
            throw new RuntimeException("Username not set properly");
        }

        // password normal
        type(password, pass);
    }
      public void click_login() {
          click(login);
      }
    public void selectSkill() {
        waitUtil.waitForVisibility(searchOtherJobs).click();

        waitUtil.waitForVisibility(skill).sendKeys("Automation Testing");
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
          ws.until(ExpectedConditions.elementToBeClickable(viewButton)).click();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    public void clickApplyButton() throws InterruptedException {
          WebDriverWait ws=new WebDriverWait(driver,Duration.ofSeconds(10));
          ws.until(ExpectedConditions.visibilityOfElementLocated(applyButton)).click();
          Thread.sleep(5000);
    }
    public void againClickOnApplyButton(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            while (true) {
                List<WebElement> buttons = driver.findElements(applyButton);

                if (buttons.isEmpty()) {
                    break; // no more Apply buttons
                }

                try {
                    WebElement btn = buttons.get(0);

                    wait.until(ExpectedConditions.elementToBeClickable(btn)).click();

                } catch (StaleElementReferenceException e) {
                    // DOM refreshed, retry
                }
            }


    }

}
