package zmisc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

@Data
@AllArgsConstructor
public class AllOrdersPageWithLombok {


       public AllOrdersPageWithLombok(){
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



    @FindBy(linkText = "View all orders")
    private WebElement viewAllOrdersLink;

    @FindBy(linkText = "View all productssdas")
    private WebElement viewAllProductsLink;

    @FindBy(xpath = "//table[@class='SampleTable']//tr[2]//td")
    private List<WebElement> cells;


    public String getCellText(int cellNumber){

        return  cells.get(cellNumber-1).getText();
    }







    // Non-Page Factory style Page Object Model
    //    private WebElement checkAllButton = Driver.getDriver().findElement(By.id("ctl00_MainContent_btnCheckAll"));
//    private WebElement uncheckAllButton = Driver.getDriver().findElement(By.id("ctl00_MainContent_btnUncheckAll"));
//    private List<WebElement> checkboxes = Driver.getDriver().findElements(By.xpath("//input[@type='checkbox']"));



    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }




}
