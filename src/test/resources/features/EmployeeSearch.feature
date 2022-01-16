Feature:  US-12345 Employee search

  Background:
    Given  user is navigated to HRMS application
    When   user enters valid admin username and password
    And  user clicks on login button
    Then admin user is succesfully logged in
    When  user navigates to employee list page

  @regression
  Scenario:  Search employee by id

    When  user enters valid employee id
    And user clicks on search button
    Then user sees employee information is displayed
    Then user closes the browser

  @regression
  Scenario:  Search employee by name
    When  user enters valid employee name
    And user clicks on search button
    Then user sees employee information is displayed
    Then user closes the browser