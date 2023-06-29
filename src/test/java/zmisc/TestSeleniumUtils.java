package zmisc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import utils.Driver;
import utils.SeleniumUtils;

public class TestSeleniumUtils {


    public static void main(String[] args) {


        Driver.getDriver().get("https://www.amazon.com/");

        SeleniumUtils.scroll(0, 2000);

        SeleniumUtils.jsClick(Driver.getDriver().findElement(By.xpath("//a[@href='https://music.amazon.com?ref=nav_youraccount_cldplyr']")));

        SeleniumUtils.takeScreenshot("target/screenshots/screenshotOfFailure.png");

    }
}
