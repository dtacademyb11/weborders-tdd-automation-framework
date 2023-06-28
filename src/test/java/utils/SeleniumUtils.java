package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SeleniumUtils {



    public static void scroll(int x, int y, WebDriver driver){
        JavascriptExecutor js=  (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy("+x+","+y+");");
    }
}
