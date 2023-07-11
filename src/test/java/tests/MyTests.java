package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Driver;

public class MyTests extends TestBase{


    @Test(groups = {"smoke"})
    public void verifyDeleteSelectedButton(){

        // non-page
        new LoginPage().loginWithValidCredentials();
        Driver.getDriver().findElement(By.linkText("View all products")).click();
        WebElement element = Driver.getDriver().findElement(By.tagName("h2"));
        Assert.assertTrue(element.isDisplayed());



    }

}
