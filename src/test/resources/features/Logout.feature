Feature: 


  @G23-109
  Scenario Outline: user should be able to logout
    Given the user login with "<username>" and "<password>"
    When user click the logout button
    Then user should be able to logout

    Examples:

      | username            | password      |
      | student18@library   | nK83Q8Be      |
      | student19@library   | Zxzbt6nX      |
      | student20@library   | KH8sN9WC      |
      | librarian50@library | kAbC7Ybl      |
      | librarian18@library | rKG2sP88      |
      | librarian43@library | np6AxVIh      |
      | librarian50@library | kAbC7Ybl      |