
Feature:Login to the Library page Funtionality


  Background: User already on login page

  @Student
  Scenario Outline: Verify students login
    Given the student login with "<username>" and "<password>"
    And books is student in the student page


    Examples:
      | username      | password      |
      | stuUserName11 | stuPassword11 |
      | stuUserName12 | stuPassword12 |
      | stuUserName13 | stuPassword13 |


  @librarian
  Scenario Outline: Verify librarian login
    Given the librarian login with "<username>" and "<password>"
    And  user should see the Dashboard  in the  page



    Examples:
      | username            | password |
      | librarian50@library | kAbC7Ybl |
      | librarian18@library | rKG2sP88 |
      | librarian43@library | np6AxVIh |
      | librarian50@library | kAbC7Ybl |


##
