package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AllOrdersTests extends TestBase {


    @Test
    public void verifyDeleteSelectedButton(){


        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        String username = "Tester";
        String pass = "test";
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username, Keys.TAB, pass, Keys.ENTER);

        WebElement element = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        Assert.assertTrue(element.isDisplayed());


    }

    @Test
    public void verifyCheckAllButton(){


        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        String username = "Tester";
        String pass = "test";
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username, Keys.TAB, pass, Keys.ENTER);

        WebElement element = driver.findElement(By.id("ctl00_MainContent_btnCheckAll"));
        Assert.assertTrue(element.isDisplayed());


    }

    @Test
    public void verifyUnCheckAllButton(){


        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        String username = "Tester";
        String pass = "test";
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username, Keys.TAB, pass, Keys.ENTER);

        WebElement element = driver.findElement(By.id("ctl00_MainContent_btnUncheckAll"));
        Assert.assertTrue(element.isDisplayed());


    }
}
