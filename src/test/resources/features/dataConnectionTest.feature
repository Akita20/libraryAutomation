Feature: Check if data connection is stable
  As a librarian I should login and assert actual result with called data
  from data source

  @dataTest
  Scenario: Login as a librarian
    Given I login as a librarian
    Then I verify by calling data
