Feature:

Scenario: Students should have access to 2 modules
Given the student on the home page
Then the user should see following modules
| Books            |
| Borrowing Books  |


Scenario: Librarians  should have access to 3 modules
Given the librarian on the homepage
Then the user should see following modules
| Dashboard         |
| Books             |
| Borrowing Books   |
