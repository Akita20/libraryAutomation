Feature: Add book to inventory
  As a librarian, I should be able to add and edit books in to the inventory

  @smoke
  Scenario: Librarian should be able to add a book
    Given I login as a librarian
    When I click on books module
    And I click on Add Book
    And A new window for Add Book should open
    And Enter Book Information
      | bookName     | BookNameTest         |
      | ISBN          | ISBNNumber           |
      | year          | 2021                 |
      | author        | Jair                 |
      | bookCategory | Action and Adventure |
      |description    | Input Description    |
    And I click Save changes button
    Then User verifies "BookNameTest" is in the list



