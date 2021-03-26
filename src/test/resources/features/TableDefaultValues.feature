Feature: Default values of the table

  @regression@wip
  Scenario: Table columns names

    Given I login as a student
    Then the user should see the following column names:
      | Actions     |
      | ISBN        |
      | Name        |
      | Author      |
      | Category    |
      | Year        |
      | Borrowed By |
