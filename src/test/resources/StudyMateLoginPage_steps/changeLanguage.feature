@language
  Feature: Change language of the software
    Scenario Outline: Verify the language options
      Given I am on the login page of studyMate application
      When I click on languageDropdown button
      Then I should see "<languageOptions>"
      Examples:
        | languageOptions |
      |English, Korean|





