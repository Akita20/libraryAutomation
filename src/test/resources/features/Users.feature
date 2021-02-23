Feature:

  Scenario: Adding users with valid info
    Given the librarian  is on users page
    When user clicks to add new user
    And user enters valid info and clicks add user
    Then user will be able to see in user page the added user


