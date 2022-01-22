package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.PageInitializer;


import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializer {

    public static WebDriver driver;


    public static void openBrowserAndLaunchApplication() {
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);

        switch (ConfigReader.getPropertyValue("browser")){
            case "chrome":
               WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
        }


        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/login");
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        initializePageObjects();
    }

    public static void SendText(WebElement element,String textToSend){
        element.clear();
        element.sendKeys(textToSend);
    }

    public static WebDriverWait getWait(){
        WebDriverWait wait=new WebDriverWait(driver,Constants.EXPLICIT_WAIT);
        return wait;
    }

    public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element){
        waitForClickability(element);
        element.click();
    }

    public static JavascriptExecutor getJSEexecutor(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        return js;
    }

    public static void jsClick(WebElement element){
        getJSEexecutor().executeScript("arguments[0].click",element);
    }




    public static void closeBrowser(){
        driver.quit();
    }


}
