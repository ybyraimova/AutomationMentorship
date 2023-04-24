package steps.studyMate;

import com.google.j2objc.annotations.Weak;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.StudyMateLoginPageClass;
import utilities.Config;
import utilities.Driver;
import utilities.Flow;

public class changeLanguage_steps {
    @Given("I am on the login page of studyMate application")
    public void iAmOnTheLoginPageOfStudyMateApplication() {
        Driver.getDriver().get(Config.getValue("url"));
    }
    @When("I click on languageDropdown button")
    public void iClickOnLanguageDropdownButton() {
        StudyMateLoginPageClass studyMateLoginPageClass = new StudyMateLoginPageClass();
        studyMateLoginPageClass.languageDropdown.click();
    }
    @Then("I should see {string}")
    public void iShouldSee(String expectedLanguageOption) {
        StudyMateLoginPageClass studyMateLoginPageClass = new StudyMateLoginPageClass();
        for(WebElement languageOption: studyMateLoginPageClass.languageOptions){
            Assert.assertTrue("Failed! The language options do not meet the reqs!",
                    expectedLanguageOption.contains(languageOption.getText()));
            Flow.wait(500);
        }
    }
}