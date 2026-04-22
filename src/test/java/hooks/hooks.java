package hooks;

import com.instaAuto.config.ConfigManager;
import com.instaAuto.driver.driverFactory;
import com.instaAuto.testcontext.testContext;
import com.instaAuto.util.screenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.ITestContext;

public class hooks {

    private testContext context;

    public hooks(testContext context) {
        this.context = context;
    }

    @Before
    public void setup() {

        // Initialize Driver
        driverFactory.initDriver(ConfigManager.get("browser"));

        // Set Driver in Context
        context.setDriver(driverFactory.getDriver());

        // Launch Application
        context.getDriver().get(ConfigManager.get("baseUrl"));
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            byte[] screenshot = screenshotUtil.takeScreenshot(context.getDriver());

            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }

        driverFactory.quit();
    }
}
