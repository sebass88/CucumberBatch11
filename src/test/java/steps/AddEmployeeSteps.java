package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        pimOption.click();

    }
    @When("user clicks Add employee button")
    public void user_clicks_add_employee_button() {
       WebElement addEmployeeButton=driver.findElement(By.id("menu_pim_addEmployee"));
       addEmployeeButton.click();
    }
    @When("user enters firstname and lastname")
    public void user_enters_firstname_and_lastname() {
       WebElement firstname=driver.findElement(By.id("firstName"));
       firstname.sendKeys("Nammar");
       WebElement lastname=driver.findElement(By.id("lastName"));
       lastname.sendKeys("MS");
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        WebElement savebtn=driver.findElement(By.id("btnSave"));
        savebtn.click();
    }
    @Then("employee added succesfully")
    public void employee_added_succesfully() {
        System.out.println("Employee Added Succesfully");
    }

}
