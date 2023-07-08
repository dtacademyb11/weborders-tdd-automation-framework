package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllOrdersPage;
import pages.LoginPage;
import pages.OrderPage;
import utils.CSVReader;
import utils.ConfigReader;
import utils.Driver;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class OrderTests extends TestBase {


    @Test (groups = {"smoke"})
    public void verifyDeleteSelectedButton(){


        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"), Keys.TAB, ConfigReader.getProperty("password"), Keys.ENTER);

        Driver.getDriver().findElement(By.linkText("Order")).click();
        WebElement element = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        Assert.assertTrue(element.isDisplayed());



    }

     @DataProvider (name = "customers")
        public Object [][] getData(){

            return CSVReader.readFromCSVFile("src/test/resources/customers.csv");
         }


    @Test (dataProvider = "customers")
    public  void placeOrderTest(String firstName,
                                String lastName,
                                String streetAddress,
                                String city,
                                String state,
                                String zip,
                                String cardNumber){


       new LoginPage().loginWithValidCredentials();


        AllOrdersPage allOrdersPage = new AllOrdersPage();

        allOrdersPage.getOrderLink().click();


        OrderPage orderPage = new OrderPage();

        orderPage.getQuantity().clear();
        orderPage.getQuantity().sendKeys("1");

       orderPage.getName().sendKeys(firstName + " " + lastName);
//       orderPage.enterText("bcdshvgj", orderPage.getName());




        orderPage.getStreetAddress().sendKeys(streetAddress);

        orderPage.getCity().sendKeys(city);

        orderPage.getState().sendKeys(state);

        orderPage.getZip().sendKeys(zip);




        orderPage.getRadioButtons().get(new Random().nextInt(3)).click();


        orderPage.getCard().sendKeys(cardNumber);

        orderPage.getExpiry().sendKeys("01/24");

        orderPage.getProcessButton().click();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Driver.getDriver().getPageSource().contains("New order has been successfully added."));


        allOrdersPage.getViewAllOrdersLink().click();

        softAssert.assertEquals(allOrdersPage.getCellText(2), firstName + " " + lastName);
        softAssert.assertEquals(allOrdersPage.getCellText(6), streetAddress);
        softAssert.assertEquals(allOrdersPage.getCellText(7), city);
        softAssert.assertEquals(allOrdersPage.getCellText(8), state);
        softAssert.assertEquals(allOrdersPage.getCellText(9), zip);
        softAssert.assertEquals(allOrdersPage.getCellText(11), cardNumber);
        softAssert.assertEquals(allOrdersPage.getCellText(12), "01/24");

        softAssert.assertAll();





    }
}
