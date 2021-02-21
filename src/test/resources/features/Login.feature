Feature:Login LogOut

  Scenario: verify both Students and librarians login

    Given the user login as a <role>
    Then the user on  <page>

      | role       | page      |
      | student    | books.    |
      | librarian# | Dashboard |

 Scenario: As a user, I should be able to logout from the library app.

