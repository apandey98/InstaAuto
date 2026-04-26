package hooks;

import com.instaAuto.config.ConfigManager;
import com.instaAuto.driver.driverFactory;
import com.instaAuto.util.screenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks {

    @Before
    public void setup(Scenario scenario) {

        String browser = ConfigManager.get("browser");

        if (scenario.getSourceTagNames().contains("@edge")) {
            browser = "edge";
        } else if (scenario.getSourceTagNames().contains("@firefox")) {
            browser = "firefox";
        }

        driverFactory.initDriver(browser);
        driverFactory.getDriver().get(ConfigManager.get("baseUrl"));
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            byte[] screenshot = screenshotUtil.takeScreenshot(driverFactory.getDriver());
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }

        driverFactory.quit();
    }
}