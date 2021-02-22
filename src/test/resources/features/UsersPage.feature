Feature: user page feautures
@users
  Scenario: user should be able to edit user info
    Given the librarian  is on users page
    When the librarian clicks on edit user page
    Then librarian can see edit page