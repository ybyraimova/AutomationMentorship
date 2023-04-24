package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AssignTeacherPageClass {
    public AssignTeacherPageClass(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//tbody/tr/td[2]")
    public List <WebElement> teachersList;

    @FindBy(xpath = "//header/button")
    public WebElement assignTeacherButton;

    @FindBy(xpath = "//tbody//*[name()='svg']//*[local-name()='path']")
    //for svg elements we have to use this xpath in order to locate it
    //    https://www.linkedin.com/pulse/designing-xpath-svg-elements-suresh-dubey
    //instructions
    public List <WebElement> deleteButtons;

    @FindBy(xpath = "(//tbody//*[name()='svg']//*[local-name()='path'])[1]")
    public WebElement deleteButton;

    @FindBy(xpath = "(//div/button)[2]")
    public WebElement deleteConfirmation;

}
