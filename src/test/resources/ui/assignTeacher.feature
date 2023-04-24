@assignteacher @smoke @regression
  Feature: Assigning teacher to a course as an Admin
    Background:
     Given I am on the login page of studyMate application
      And I login with "<email>" and "<password> "
      And I click on courses option on a side bar menu
    Example:
    | email              | password  |
    |studymate@gmail.com | 123123    |

      Scenario: 1 Verifying if Assign teacher option is present in a dropdown list
        When I click on three-dot button on the first course
        Then I should see "Assign teacher" option listed in a dropdown list


     Scenario: 2 Verifying if the assigned teacher is displayed in assign teacher window
       When I click on three-dot button on the first course
       And I click on Assign teacher option from the dropdown list
       And I click on checkbox of the first teacher
       Then I should see the teacher assigned below the dropdown list



       Scenario: 3 Assigning teacher to a course using three dots
         When I click on three-dot button on the first course
         And I click on Assign teacher option from the dropdown list
         And I click on checkbox of the first teacher
         And I click on save button
         Then I should see the pop-up message "Instructors successfully added to the course"



     Scenario: 4 Assigning several teachers to a course using three dots
       When I click on three-dot button on the first course
       And I click on Assign teacher option from the dropdown list
       And I click on checkboxes of all existing teachers
       And I click on save button
       Then I should see the pop-up message "Instructors successfully added to the course"



    Scenario: 5 Canceling teacher assignment after assigning one teacher
      When I click on three-dot button on the first course
      And I click on Assign teacher option from the dropdown list
      And I click on checkboxes of one teacher
      And I click on cancel button
      Then I should not see any pop up message




    Scenario: 6 Canceling teacher assignment after assigning several teachers
      When I click on three-dot button on the first course
      And I click on Assign teacher option from the dropdown list
      And I click on checkboxes of all existing teachers
      And I click on cancel button
      Then I should not see any pop up message




    Scenario: 7 Removing already assigned teachers from a course and leaving one
      When I click on three-dot button on the first course
      And I click on Assign teacher option from the dropdown list
      And I remove one  already assigned teachers from a course
      And I click on save button
      Then I should see the pop-up message "Instructors successfully added to the course"




    Scenario: 8 Removing all already assigned teachers from a course
      When I click on three-dot button on the first course
      And I click on Assign teacher option from the dropdown list
      And I remove all already assigned teachers from a course
      And I click on save button
      Then Save button should be disabled



    Scenario: 9 Verifying the list of the teachers from dropdown list
      When I click on three-dot button on the first course
      And I click on Assign teacher option from the dropdown list
      Then I should see the list of teachers in alphabetical order
#      Failed. It is not in alphabetical order



    Scenario: 10 Verifying if the assigned teachers appear in course description
      When I click on three-dot button on the first course
      And I click on Assign teacher option from the dropdown list
      And I click on checkbox of the first teacher
      And I click on save button
      And I click on the course
      Then I should see the assigned teachers in the list of Teachers inside the Course description



    Scenario: 11 Assigning teacher using the Assign teacher button from the course description
      When I click on the course
      And I click on Assign teacher button
      And I click on checkbox of the first teacher
      And I click on save button
      Then I should see the pop-up message "Instructors successfully added to the course"



      Scenario: 12 Verifying confirmation message for removing already assigned teacher from the course description
        When I click on the course
        And I click on the Trash button
        Then I should see the message "Do you want to delete teacher from course" in the pop-up window

@remove
    Scenario: 13 Removing already assigned teacher from the course description
      When I click on the course
      And I click on the Trash button
      And I click on delete button
      Then I should see the pop-up message "Instructor was successfully deleted from the course"


    Scenario: 14 Canceling removing already assigned teacher from the course description
      When I click on the course
      And I click on the Trash button
      And I click on cancel button
      Then I should not see any pop up message
#      How to check if the pop-up message is not displayed?















