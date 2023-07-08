package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class AllOrdersPage {


       public AllOrdersPage(){
           PageFactory.initElements(Driver.getDriver(), this); // this line initializes all @FindBy annotated variables
       }


    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    private WebElement checkAllButton;

    @FindBy(id = "ctl00_MainContent_btnUncheckAll")
    private WebElement uncheckAllButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(linkText = "Order")
    private WebElement orderLink;

    public WebElement getViewAllOrdersLink() {
        return viewAllOrdersLink;
    }

    @FindBy(linkText = "View all orders")
    private WebElement viewAllOrdersLink;

    @FindBy(linkText = "View all productssdas")
    private WebElement viewAllProductsLink;

    @FindBy(xpath = "//table[@class='SampleTable']//tr[2]//td")
    private List<WebElement> cells;


    public String getCellText(int cellNumber){

        return  cells.get(cellNumber-1).getText();
    }

    public WebElement getOrderLink() {
        return orderLink;
    }





    // Non-Page Factory style Page Object Model
    //    private WebElement checkAllButton = Driver.getDriver().findElement(By.id("ctl00_MainContent_btnCheckAll"));
//    private WebElement uncheckAllButton = Driver.getDriver().findElement(By.id("ctl00_MainContent_btnUncheckAll"));
//    private List<WebElement> checkboxes = Driver.getDriver().findElements(By.xpath("//input[@type='checkbox']"));

    public WebElement getCheckAllButton() {
        return checkAllButton;
    }

    public WebElement getUncheckAllButton() {
        return uncheckAllButton;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public WebElement getViewAllProductsLink() {

        return viewAllProductsLink;
    }
}
