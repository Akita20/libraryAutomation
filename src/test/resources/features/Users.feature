Feature:

  @wip
  Scenario: Adding users with valid info
    Given the librarian  is on users page
    When user clicks to add new user
    And user enters valid info and clicks add user
    Then user will be able to see in user page the added user

@wip
  Scenario: Canceling user
    Given the librarian  is on users page
    When user clicks to add new user
    Then user clicks to cancel, the form is cancelled

#  @edit @wip
#  Scenario: Editing User
#    Given the librarian  is on users page
#    When user clicks to edit button for desired "Dr. Edison Hettinge"
#    And user enters valid info and clicks add user
#    Then user will be able to see in user page the added user

  @editRandom @wip
  Scenario: Editing User
    Given the librarian  is on users page
    When user clicks to edit button randomly from the list
    And user enters valid info and clicks add user
    Then user will be able to see in user page the added user


