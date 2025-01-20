Feature: Applying for the leave in ESS portal

  Background: 
    User login with valid username and valid password

    Given user is on login page
    When user enters valid username
    And enters valid password
    And clicks on signin button
    Then user navigated to the main page

  #@login
  #Scenario: User login with valid username and valid password
  #Given user is on login page
  #When user enters valid username
  #And enters valid password
  #And clicks on signin button
  #Then user navigated to the main page
  @applyLeave
  Scenario: User applying the leave for 2 days
    Given user clicked on apply leave button
    When user navigated to the Apply leave screen
    And user selects the value from the leave reason dropdown
    And selects the value in date from field
    And selects the value in date to field
    And enters comments
    And clicks on apply button
    And user checking the reference number
    And clicks on close button
    Then user navigated to the main page
    And user navigated to the leave request list
    When user search the leave request using search filter
    Then the leave request row should be visible
    
    #@approver @approvingtheleave
    #Scenario: Approver approving the leave request 
    #Given approver clicked on my tasks tab
    #When approver clicks on the respective leave request
    #And enters comments
    #Then approver approve/rejects the leave request
    #
    #@approver @askingneedmoreinfo
    #Scenario: Approver asking need more information before approving/rejecting the leave request
    #Given approver clicked on my tasks tab
    #When approver clicks on the respective leave request
    #And enters comments
    #Then clicks on need more info
    #
    #@user @submitting @needmoreinfoform
    #Scenario: User submitting need more info form
    #Given user clicked on my tasks tab
    #When user clicks on the task
    #And enters comments
    #Then user submits the form 
    #
