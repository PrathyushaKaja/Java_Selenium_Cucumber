@all
Feature: Login Functionality

  #Scenaio Outline will be used we want to test the scenario with multiple values
  @scenario1
  Scenario Outline: User logged in with valid username and password
    Given user is on the login page
    When user enters the valid "<username>"
    And enters the valid "<password>"
    And user clicks on login button
    Then user is navigated to the home page

    Examples: 
      | username             | password |
      | prathyusha@gmail.com | s@2000   |
      | prashya2@gmail.com   | dfg@200  |

  @scenario2
  Scenario Outline: User logged in with invalid username and valid password
    Given user is on the login page
    When user entered the invalid "<username>"
    And entered the valid "<password>"
    And user clicks on login button
    Then user got warning message

    Examples: 
      | username     | password |
      | p@gmail.com  | fghvbv   |
      | fg@gmail.com | wjjw     |
