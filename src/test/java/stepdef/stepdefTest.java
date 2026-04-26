package stepdef;

import com.instaAuto.base.loginpage;
import com.instaAuto.config.ConfigManager;
import com.instaAuto.driver.driverFactory;

import io.cucumber.java.en.*;

public class stepdefTest {

    private loginpage login;

    public stepdefTest() {
        this.login = new loginpage(driverFactory.getDriver());
    }

    @Given("go to url")
    public void go_to_url() {
        driverFactory.getDriver().get(ConfigManager.get("baseUrl"));
        login.clickonfirstLogin();
    }

    @When("user give <username> and <password>")
    public void userGiveUsernameAndPassword() {
        String username = ConfigManager.get("username");
        String password = ConfigManager.get("password");
        login.setLogin(username, password);
    }

    @And("user click on login")
    public void user_click_on_login() {
        login.click_login();
    }

    @Then("user select skills")
    public void user_select_skills() {
        login.selectSkill();
    }

    @Then("user click on view button")
    public void user_click_on_view_button() {
        login.clickViewButton();
    }

    @Then("click on Apply")
    public void click_on_apply() throws InterruptedException {
        login.clickApplyButton();
    }

    @Then("click on apply again")
    public void click_on_apply_again() {
        login.againClickOnApplyButton();
    }
}