Feature: Add Employees

@regression
  Scenario:Adding one employee from feature file
    Given  user is navigated to HRMS application
    When   user enters valid admin username and password
    And  user clicks on login button
    Then admin user is succesfully logged in
    When user clicks on PIM option
    And user clicks Add employee button
    And user enters firstname and lastname
    And  user clicks on save button
    Then employee added succesfully
    Then  user close the browser