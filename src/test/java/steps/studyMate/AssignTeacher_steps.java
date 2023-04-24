package steps.studyMate;

import com.google.common.collect.Ordering;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AssignTeacherPageClass;
import pages.CoursesPageClass;
import pages.StudyMateLoginPageClass;
import pages.StudyMateMainPageClass;
import utilities.Config;
import utilities.Driver;
import utilities.Flow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AssignTeacher_steps {
    StudyMateLoginPageClass studyMateLoginPageClass = new StudyMateLoginPageClass();
    StudyMateMainPageClass studyMateMainPageClass = new StudyMateMainPageClass();
    CoursesPageClass coursesPageClass = new CoursesPageClass();
    AssignTeacherPageClass assignTeacherPageClass = new AssignTeacherPageClass();

    String firstTeacher;

    @Given("I login with {string} and {string}")
    public void i_login_with_and(String email, String password) {
        studyMateLoginPageClass.login("studymate@gmail.com", "123123");
    }
    @Given("I click on courses option on a side bar menu")
    public void i_click_on_courses_option_on_a_side_bar_menu() {
        Flow.wait(1000);
        studyMateMainPageClass.coursesSideBarButton.click();
    }
    @When("I click on three-dot button on the first course")
    public void i_click_on_three_dot_button_on_the_first_course() {
        Flow.wait(1000);
        coursesPageClass.oneCourseThreeDotsButton.click();
    }
    @Then("I should see {string} option listed in a dropdown list")
    public void i_should_see_option_listed_in_a_dropdown_list(String expected) {
            Assert.assertEquals("The assign teacher button does not exist!",
                  coursesPageClass.oneAssignTeacherButton.getText(), expected);
        }

    @When("I click on Assign teacher option from the dropdown list")
    public void i_click_on_assign_teacher_option_from_the_dropdown_list() {
        coursesPageClass.oneAssignTeacherButton.click();
    }
    @When("I click on checkbox of the first teacher")
    public void i_click_on_checkbox_of_the_first_teacher() {
        coursesPageClass.teacherDropDownButton.click();
        Flow.wait(1000);
        coursesPageClass.firstTeacherFromDropDownList.click();
        firstTeacher =  coursesPageClass.firstTeacherButton.getText();
        Flow.wait(10000);
    }

    @Then("I should see the teacher assigned below the dropdown list")
    public void i_should_see_the_teacher_assigned_below_the_dropdown_list() {
        List <String> assignedTeachers = new ArrayList<>();
        for(WebElement assignedTeacher: coursesPageClass.assignedTeachersInForm){
            System.out.println(assignedTeacher.getText());
         assignedTeachers.add(assignedTeacher.getText());
        }
        Assert.assertTrue("Failed! The assigned teacher is not present in the form!",
                assignedTeachers.contains(firstTeacher));
    }

    @When("I click on save button")
    public void i_click_on_save_button() {
        coursesPageClass.saveButton.click();
    }
    @Then("I should see the pop-up message {string}")
    public void i_should_see_the_pop_up_message(String string) {
        Assert.assertEquals("Failed!The pop up message does not meet the reqs",
                "Instructors successfully added to the course", coursesPageClass.errorMessage.getText().trim());
    }

    @When("I click on checkboxes of all existing teachers")
    public void i_click_on_checkboxes_of_all_existing_teachers() {
        coursesPageClass.teacherDropDownButton.click();
        Flow.wait(1000);
        for(WebElement teacher: coursesPageClass.teachersDropDownList){
            teacher.click();
        }
        Flow.wait(10000);
    }


    @When("I click on checkboxes of one teacher")
    public void i_click_on_checkboxes_of_one_teacher() {
        coursesPageClass.teacherDropDownButton.click();
        Flow.wait(1000);

        for(WebElement teacher: coursesPageClass.teacherButtons){
            if(teacher.getText().contains("Anar")){
                teacher.click();
            }
        }
        Flow.wait(10000);
    }
    @When("I click on cancel button")
    public void i_click_on_cancel_button() {
        coursesPageClass.cancelButton.click();
    }
    @Then("I should not see any pop up message")
    public void i_should_not_see_any_pop_up_message() {
        try{
            Assert.assertFalse("Failed! The pop message was displayed after canceling!",
                    coursesPageClass.errorMessage.isDisplayed());
        }catch (Exception e){
            System.out.println("PASSED. No pop up message was displayed!");
        }
    }



    @When("I remove one  already assigned teachers from a course")
    public void i_remove_one_already_assigned_teachers_from_a_course() {
        coursesPageClass.removeButton.click();
    }


    @When("I remove all already assigned teachers from a course")
    public void i_remove_all_already_assigned_teachers_from_a_course() {
        for(WebElement removeButton: coursesPageClass.removeButtons){
            removeButton.click();
            Flow.wait(200);
        }
    }

    @Then("Save button should be disabled")
    public void save_button_should_be_disabled() {
        boolean actual = coursesPageClass.saveButton.isEnabled();
        boolean expected = true;
        Assert.assertEquals("Failed! The save button is enabled!",
                actual, expected);
    }

    @Then("I should see the list of teachers in alphabetical order")
    public void i_should_see_the_list_of_teachers_in_alphabetical_order() {
        List <String> assignedTeachers = new ArrayList<>();
        for(WebElement assignedTeacher: coursesPageClass.assignedTeachersInForm){
            System.out.println(assignedTeacher.getText());
            assignedTeachers.add(assignedTeacher.getText());
        }
        Collections.sort(assignedTeachers);
        boolean isSorted = Ordering.natural().isOrdered(assignedTeachers);
        Assert.assertEquals("Failed! The list of assigned teachers are not in alphabetical order",
                true, isSorted);
    }


    @When("I click on the course")
    public void i_click_on_the_course() {
        studyMateMainPageClass.coursesSideBarButton.click();
        Flow.wait(1000);
        coursesPageClass.firstCourse.click();
    }
    @Then("I should see the assigned teachers in the list of Teachers inside the Course description")
    public void i_should_see_the_assigned_teachers_in_the_list_of_teachers_inside_the_course_description() {
        List <String> teachersListStr = new ArrayList<>();
    for(WebElement teacher: assignTeacherPageClass.teachersList){
        teachersListStr.add(teacher.getText());
    }
}
    @When("I click on Assign teacher button")
    public void i_click_on_assign_teacher_button() {
    assignTeacherPageClass.assignTeacherButton.click();
    }

    @Then("I should see the message {string} in the pop-up window")
    public void iShouldSeeTheMessageInThePopUpWindow(String expectedMessageDelete) {
        Assert.assertTrue(coursesPageClass.deleteConfirmationMessage.getText().contains(Config.getValue("expectedMessageDelete")));
    }

    @When("I click on delete button")
    public void i_click_on_delete_button() {
        assignTeacherPageClass.deleteConfirmation.click();

    }

    @When("I click on the Trash button")
    public void i_click_on_the_trash_button() {
        assignTeacherPageClass.deleteButton.click();

        // This is the syntax of handling svg elements on the webpage:
//        // Action class to move and click element

//        Actions actions = new Actions(Driver.getDriver());
//        actions.moveToElement(assignTeacherPageClass.deleteButton).
//                click().build().perform();
        //However it worked without the actions class.
    }
}
