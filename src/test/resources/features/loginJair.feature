Feature: Library app login feature
  As a user, I should be able to login with correct credentials to different accounts. And dashboard should be displayed.
  Accounts are: librarian, student

  @librarian
  Scenario: Login as a librarian1
    Given I login as a librarian1

  @student
  Scenario: Login as student1
    Given I login as a student1


