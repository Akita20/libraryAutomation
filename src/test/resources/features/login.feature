Feature: Library app login feature
  As a user, I should be able to login with correct credentials to different accounts. And dashboard should be displayed.
  Accounts are: librarian, student

  @librarian
  Scenario: Login as a librarian
    Given I login as a librarian
    Then dashboard should be displayed
  @student
  Scenario: Login as student
    Given I login as a student
    Then dashboard should be displayed

  @loginWithParameter
  Scenario: Login as librarian 11
    Given I am on the login page
    When I enter username "librarian11@library"
    And  I enter password 'I61FFPPf'
    And  I click the sign in button
    Then dashboard should be displayed