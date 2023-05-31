Feature: Login

  @dataTable11
  Scenario: Login with multiple credentials using Data Table

    Given open the browser and launch HRMS applicationn
    When user enters username and password and verifies logins
      | username | password |
      | admin    | Hum@nhrm123 |
      | admin    | Hum@nhrm123 |