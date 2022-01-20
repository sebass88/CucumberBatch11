package steps;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginSteps extends CommonMethods {

    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() {
        openBrowserAndLaunchApplication();
    }

    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() {
       // LoginPage login=new LoginPage();
        loginPage.usernameField.sendKeys(ConfigReader.getPropertyValue("username"));
        //WebElement username = driver.findElement(By.id("txtUsername"));
        //username.sendKeys(ConfigReader.getPropertyValue("username"));
        loginPage.passwordField.sendKeys(ConfigReader.getPropertyValue("password"));
        //WebElement password = driver.findElement(By.id("txtPassword"));
        //password.sendKeys(ConfigReader.getPropertyValue("password"));
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        // LoginPage login = new LoginPage();
        // WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginPage.loginBtn.click();
    }

    @Then("admin user is succesfully logged in")
    public void admin_user_is_succesfully_logged_in() {
        System.out.println("Test passed");

    }

    @Then("user closes the browser")
    public void user_closes_the_browser() {
     closeBrowser();
    }

    @When("user enters valid ess username and password")
    public void user_enters_valid_ess_username_and_password() {
        System.out.println("hello");
    }
    @When("user enters different {string} and {string} and verify the {string} for all the combinations")
    public void user_enters_different_and_and_verify_the_for_all_the_combinations(String usernameValue, String passwordValue, String error) {
        //LoginPage login=new LoginPage();
       // WebElement username = driver.findElement(By.id("txtUsername"));
      loginPage.usernameField.sendKeys(usernameValue);
        //WebElement password = driver.findElement(By.id("txtPassword"));
      loginPage.passwordField.sendKeys(passwordValue);
      //WebElement loginbutton=driver.findElement(By.id("btnLogin"));
      loginPage.loginBtn.click();

      //WebElement errorMessage=driver.findElement(By.id("spanMessage"));
      String errorActual=loginPage.errorMessage.getText();
        Assert.assertEquals("values do not match",error,errorActual);
    }
    @When("user enters different {string} and {string}")
    public void user_enters_different_and(String usernameValue, String passwordValue) {
        //WebElement username = driver.findElement(By.id("txtUsername"));
        //username.sendKeys(usernameValue);
        loginPage.usernameField.sendKeys(usernameValue);
        //WebElement password = driver.findElement(By.id("txtPassword"));
        //password.sendKeys(passwordValue);
        loginPage.passwordField.sendKeys(passwordValue);

    }

    @Then("{string} user is succesfully logged in")
    public void user_is_succesfully_logged_in(String admin) {
       //WebElement dashboardMessage= driver.findElement(By.id("welcome"));
       Assert.assertTrue(dash.welcomeMessage.isDisplayed());
    }
}
