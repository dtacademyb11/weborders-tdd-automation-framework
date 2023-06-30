package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.ConfigReader;
import utils.Driver;

public class LoginPage {


    // Page Object Model is used for maintainability of the Webelements

    private WebElement usernameField = Driver.getDriver().findElement(By.id("ctl00_MainContent_username"));




    public WebElement getUsernameField() {
        return usernameField;
    }

    public void loginWithValidCredentials(){
        login(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));
    }

    public void login(String username, String password){
        usernameField.sendKeys(username, Keys.TAB, password, Keys.ENTER);
    }


}
