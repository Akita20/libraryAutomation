Feature: Add users
  As a librarian, I should be able to add users from users page.

  Background:
    Given the user  on the librarian homepage

  @smoke @addUser
  Scenario: Librarian should add users
    When the user click users moudle
    And Librarian add user
    Then User should be able to see new user name

  @smoke @close
  Scenario: Librarian should click close button
    When the user click users moudle
    Then User should be able to close the add user pop-up window

  @smoke @edit
  Scenario: Librarians able to edit user info.
    When the user click users moudle
    When User should be able to edit user information
