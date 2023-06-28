package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Driver;

import java.time.Duration;

public class TestBase {


     //TestBase class is a super class of all test classes that offers benefits such as mainatainability, readability



    @BeforeMethod(alwaysRun = true)
    public void setUp(){

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Driver.getDriver().manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){

        Driver.quitDriver();
    }
}
