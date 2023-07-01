package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.log.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AllOrdersPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.Driver;

import java.time.Duration;
import java.util.List;

public class AllOrdersTests extends TestBase {


    @Test (groups = {"smoke"})
    public void verifyDeleteSelectedButton(){



        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"), Keys.TAB, ConfigReader.getProperty("password"), Keys.ENTER);

        WebElement element = Driver.getDriver().findElement(By.id("ctl00_MainContent_btnDelete"));
        Assert.assertTrue(element.isDisplayed());


    }

    @Test (groups = {"smoke"})
    public void verifyCheckAllButton(){


        LoginPage loginPage =  new LoginPage();
        loginPage.loginWithValidCredentials();

        AllOrdersPage allOrdersPage = new AllOrdersPage();
        Assert.assertTrue(allOrdersPage.getCheckAllButton().isDisplayed());
        allOrdersPage.getCheckAllButton().click();

        allOrdersPage.getCheckboxes().forEach( s -> Assert.assertTrue(s.isSelected()));


    }

    @Test
    public void verifyUnCheckAllButton(){


        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"), Keys.TAB, ConfigReader.getProperty("password"), Keys.ENTER);
        WebElement element = Driver.getDriver().findElement(By.id("ctl00_MainContent_btnUncheckAll"));
        Assert.assertTrue(element.isDisplayed());
        element.click();

        List<WebElement> checkboxes = Driver.getDriver().findElements(By.xpath("//input[@type='checkbox']"));

        checkboxes.forEach( s -> Assert.assertTrue(!s.isSelected()));



    }
}
