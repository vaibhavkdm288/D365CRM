Feature: Create New Contact

  Scenario: Check if a new contact is being created
    Given the user is on the login page
    When user enters credentials
    And clicks on the login button
    Then the user is navigated to the home page
    When the user searches for the IET UCI App
    And clicks on the IET UCI App
    Then the user is navigated to the dashboard tab of IET UCI
    When the user clicks on the member/contact tab
    And clicks on the add new contact icon
    Then the new contact form is displayed
    When the user enters the first name and last name and selects the gender
    And clicks on the Home & Local Networks tab
    Then the user is navigated to the Home & Local Networks page
    When the user selects the home address
    And clicks on the save & close button
    Then the user is navigated to the Active Members/Contacts view
