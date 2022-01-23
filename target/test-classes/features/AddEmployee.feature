Feature: Add Employees
Background:
  When   user enters valid admin username and password
  And  user clicks on login button
  Then admin user is succesfully logged in
  When user clicks on PIM option
  And user clicks Add employee button
@regression
  Scenario:Adding one employee from feature file
    And user enters firstname and lastname
    And  user clicks on save button
    Then employee added succesfully

  @ddt
  Scenario Outline:Add Employee

    And user clicks Add employee button
    And user enters "<firstName>" "<middleName>" and "<lastName>"
    And  user clicks on save button
    Then employee added sucessfully

    Examples:
    |firstName|middleName|lastName|
    |test123  |MS        |test456 |


    @ddt2
      Scenario Outline: Modifying Employee Details
      And user clicks Add employee button
      And user enters "<firstName>" "<middleName>" and "<lastName>"
      And  user clicks on save button
      And user clicks on edit button
      Then user fills out required information
      And user clicks on save button again
      Then user has succesfully modify employee

      Examples:
        |firstName|middleName|lastName|
        |sebass |A        |garcia|



@samplecucumberScenario
    Scenario:  Adding one employee using cucumber feature
      And user enters direct data "sebastianfn" "christinemn" and "yogitaln"
      And  user clicks on save button
      Then employee added succesfully

  @dataTable
  Scenario:Add Employee
    When  user adds multiple employees and verify they are added
      |firstName|middleName|lastName|
      |test123  |MS        |test456 |
      |testabc  |MS        |testxyz |
      |test987  |MS        |test321 |

@excel
    Scenario: Adding Employees from excel File
      When user adds multiple employees from excel file using "EmployeeData" sheet and verify the added employee