Feature:

  @addUser
  Scenario: Adding users with valid info
    Given the librarian  is on users page
    When user clicks to add new user
    And user enters valid info and clicks add user
    Then user will be able to see in user page the added user


  Scenario: Canceling user
    Given the librarian  is on users page
    When user clicks to add new user
    Then user clicks to cancel, the form is cancelled

  @edit
  Scenario: Editing User
    Given the librarian  is on users page
    When user clicks to edit button for desired "Mr. Long Quitzon"
    And user enters valid info and clicks add user
    Then user will be able to see in user page the added user



