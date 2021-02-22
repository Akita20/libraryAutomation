Feature: user group category features

  Scenario: verify user categories

    Given the user  on the librarian homepage
    When the user click users moudle
    And the user click User Group dropdown
    Then the user should see the following options:
      | ALL       |
      | Librarian |
      | Students  |
