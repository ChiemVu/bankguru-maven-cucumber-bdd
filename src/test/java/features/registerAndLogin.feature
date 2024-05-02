@customer
Feature: Register/ Login and new Customer

  @register_login
  Scenario: Register to system and login
    Given Get login page Url
    When Open Register page
    And Input to Email textbox
    And Click to Submit
    Then Get User and Password infor
    When Back to Login page
    And Submit valid infor to login form
    Then Home page displayed

  @new_customer
  Scenario Outline: New Customer
    Given Submit to login form
    Then Home page displayed
    And Open "New Customer" page
    When Input  to "Customer Name" textbox with value "<CustomerName>"
    And Click to "m" radio button
    And Input  to "Date of Birth" textbox with value "<DobIn>"
    And Input  to "Address" textarea with value "<Address>"
    And Input  to "City" textbox with value "<City>"
    And Input  to "State" textbox with value "<State>"
    And Input  to "PIN" textbox with value "<PIN>"
    And Input  to "Mobile Number" textbox with value "<Phone>"
    And Input  to "E-mail" textbox with value "<Emai>"
    And Input  to "Password" textbox with value "<Password>"
    And Click to "Submit" button
    Then Success message displayed with "Customer Registered Successfully!!!"
    And The valid text displayed at "Customer Name" with value"<CustomerName>"
    And The valid text displayed at "Gender" with value"<Gender>"
    And The valid text displayed at "Birthdate" with value"<DobOut>"
    And The valid text displayed at "Address" with value"<Address>"
    And The valid text displayed at "City" with value"<City>"
    And The valid text displayed at "State" with value"<State>"
    And The valid text displayed at "Pin" with value"<PIN>"
    And The valid text displayed at "Mobile No." with value"<Phone>"
    And The valid text displayed at "Email" with value"<Emai>"


    Examples:
      | CustomerName | Gender | DobIn      | DobOut     | Address | City        | State   | PIN    | Phone      | Emai             | Password |
      | chiem        | male   | 02/16/1990 | 1990-02-16 | Hanoi   | Ho Chi Minh | Thu Duc | 650000 | 0123456987 | chiemv@gmail.com | 123456   |
