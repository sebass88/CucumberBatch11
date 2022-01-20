package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class DashboardPage extends CommonMethods {

    @FindBy(id = "welcome")
    public WebElement welcomeMessage;

    @FindBy(xpath = "//*[@class='menu']/ul/li")
    public List<WebElement> dashboardTabs;

    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement PimOption;

    @FindBy(id = "menu_pim_addEmployee")
    public WebElement addEmployeeButton;

    @FindBy(id = "menu_pim_viewEmployeeList")
    public WebElement employeeListButton;


    public DashboardPage(){
        PageFactory.initElements(driver,this);
    }
}
