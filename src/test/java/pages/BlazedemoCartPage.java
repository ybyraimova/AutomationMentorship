package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class BlazedemoCartPage {
    public BlazedemoCartPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//tbody[@id='tbodyid']/tr/td[2]")
    public List <WebElement> productNamesInCart;

    @FindBy(xpath = "//tbody[@id='tbodyid']/tr/td[3]")
    public List <WebElement> productPricesInCart;

    @FindBy(xpath = "//tbody[@id='tbodyid']/tr/td[4]/a")
    public List <WebElement> productDeleteButtonsFromCart;

}
