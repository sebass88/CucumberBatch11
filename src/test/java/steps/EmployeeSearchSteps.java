package steps;

import Pages.DashboardPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class EmployeeSearchSteps extends CommonMethods {

    @When("user navigates to employee list page")
    public void user_navigates_to_employee_list_page() {
        //DashboardPage dash=new DashboardPage();

        //WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        dash.PimOption.click();



        //WebElement employeeListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        dash.employeeListButton.click();
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        //WebElement searchByID = driver.findElement(By.id("empsearch_id"));
        //searchByID.sendKeys("23638000");
        employeeListPage.idEmployeeSearch.sendKeys("26368000");
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        //WebElement searchButton = driver.findElement(By.id("searchBtn"));
        //searchButton.click();
        employeeListPage.searchButton.click();
    }

    @Then("user sees employee information is displayed")
    public void user_sees_employee_information_is_displayed() {
        System.out.println("Information page is displayed");

    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
        //WebElement name = driver.findElement(By.id("empsearch_employee_name_empName"));
        //name.sendKeys("XYZT");
        employeeListPage.empSearchStepByName.sendKeys("XYZT");
    }

    @Then("user close the browser")
    public void user_close_the_browser() {
        closeBrowser();
    }
}

