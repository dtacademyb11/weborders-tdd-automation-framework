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
import utils.Driver;

import java.time.Duration;

public class LoginTests extends TestBase {


    @Test
    public void positiveLogin(){


        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"), Keys.TAB, ConfigReader.getProperty("password"), Keys.ENTER);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");


    }

    @Test
    public void negativeLoginInvalidUsername(){


        Driver.getDriver().get(ConfigReader.getProperty("url"));
        String username = "Invalid";
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(username, Keys.TAB, ConfigReader.getProperty("password"), Keys.ENTER);
        Assert.assertNotEquals(Driver.getDriver().getCurrentUrl(), "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");


    }

    @Test
    public void negativeLoginInvalidPassword(){


        Driver.getDriver().get(ConfigReader.getProperty("url"));
        String pass = "invalid";
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"), Keys.TAB, pass, Keys.ENTER);
        Assert.assertNotEquals(Driver.getDriver().getCurrentUrl(), "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");


    }

    @Test
    public void negativeLoginNoPassword(){

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"), Keys.TAB, "", Keys.ENTER);
        Assert.assertNotEquals(Driver.getDriver().getCurrentUrl(), "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");


    }


}
