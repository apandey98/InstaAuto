    package stepdef;

    import com.instaAuto.base.loginpage;
    import com.instaAuto.config.ConfigManager;
    import com.instaAuto.testcontext.testContext;
    import io.cucumber.java.PendingException;
    import io.cucumber.java.en.*;
    import org.testng.Assert;

    public class stepdefTest {

        private testContext context;
        private loginpage login;

        public stepdefTest(testContext context) {
            this.context = context;
            this.login = new loginpage(context.getDriver());
        }

        @Given("go to url")
        public void go_to_url() {
            context.getDriver().get(ConfigManager.get("baseUrl"));
            login.clickonfirstLogin();
        }

        @When("user give <username> and <password>")
        public void userGiveUsernameAndPassword() {
           String username = ConfigManager.get("username");
           String  password = ConfigManager.get("password");
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

//        @And("click on show results")
//        public void click_on_show_results() {
//       login.clickShowResult();
//        }

        @Then("take total job counts")
        public void take_total_job_counts() {
          login.getTotalJobCount();
        }

        @And("go to total jobs feed")
        public void go_to_total_jobs_feed() {
           login.checkJobAvailability();
        }

        @Then("user click on view button")
        public void user_click_on_view_button() {
           login.clickViewButton();
        }
        @Then("click on Apply")
        public void click_on_apply() {
            login.clickApplyButton();
        }

        @Then("wait for {int} seconds")
        public void wait_for_seconds(Integer seconds) throws InterruptedException {
           ;
        }

        @Then("click on apply again")
        public void click_on_apply_again() {
            // code
        }

    }