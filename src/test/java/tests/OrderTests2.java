package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllOrdersPage;
import pages.LoginPage;
import pages.OrderPage;
import utils.CSVReader;
import utils.ConfigReader;
import utils.Driver;

import java.util.Random;

public class OrderTests2 extends TestBase {




     @DataProvider (name = "customers", parallel = true)
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
