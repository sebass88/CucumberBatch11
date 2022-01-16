Feature: Login feature
Background:
  #Given  user is navigated to HRMS application

  @smoke  @sprint2
  Scenario Outline: Valid admin login

    When user enters different "<username>" and "<password>"
    And  user clicks on login button
    Then "<admin>" user is succesfully logged in
    Examples:
    |username|password|admin|
    |Admin   |Hum@nhrm123|Admin|


 @regression @smoke
    Scenario: Valid ess login

      When user enters valid ess username and password
      And  user clicks on login button
      Then admin user is succesfully logged in


   @login
   Scenario Outline: negative login test
     When user enters different "<username>" and "<password>" and verify the "<error>" for all the combinations
     Examples:
     |username|password|error|
     |admin   |xyz     |Invalid credentials|
     |cristiano|Hum@nhrm123|Invalid credentials|
     |         |Hum@nhrm123|Username cannot be empty|
     |Admin    |           |Password cannot be empty|



