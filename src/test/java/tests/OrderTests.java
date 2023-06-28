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
import utils.ConfigReader;

import java.time.Duration;

public class OrderTests extends TestBase {







    @Test
    public void verifyDeleteSelectedButton(){


        driver.get(ConfigReader.getProperty("url"));
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"), Keys.TAB, ConfigReader.getProperty("password"), Keys.ENTER);

        driver.findElement(By.linkText("Order")).click();
        WebElement element = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        Assert.assertTrue(element.isDisplayed());



    }
}
