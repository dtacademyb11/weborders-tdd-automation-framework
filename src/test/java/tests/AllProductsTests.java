package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AllOrdersPage;
import pages.AllProductsPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

import java.time.Duration;
import java.util.List;

public class AllProductsTests  extends TestBase{



    @Test (groups = {"smoke"})
    public void verifyDeleteSelectedButton(){

         // non-page
        new LoginPage().loginWithValidCredentials();
        Driver.getDriver().findElement(By.linkText("View all products")).click();
        WebElement element = Driver.getDriver().findElement(By.tagName("h2"));
        Assert.assertTrue(element.isDisplayed());



    }

    @Test
    public void verifyTableColumns(){
        new LoginPage().loginWithValidCredentials();

        List<String> expected = List.of("Product name", "Price", "Discount");

        throw new SkipException("Test skipped");

//        new AllOrdersPage().getViewAllProductsLink().click();
//
//        AllProductsPage allProductsPage = new AllProductsPage();
//
//        List<String> actual = SeleniumUtils.getElementsText(allProductsPage.getHeaderCells());
//
//        Assert.assertEquals(actual,expected);





    }

    @Test
    public void verifyTableProductNames(){

        logger.info("Logging in");
        new LoginPage().loginWithValidCredentials();

        List<String> expected = List.of("MyMoney", "FamilyAlbum", "ScreenSaver");

        logger.info("Click on view all products link");
        new AllOrdersPage().getViewAllProductsLink().click();

        List<String> actual = SeleniumUtils.getElementsText(new AllProductsPage().getProductNameCells());

        logger.info("Verify product names");
        Assert.assertEquals(actual,expected);

    }
}
