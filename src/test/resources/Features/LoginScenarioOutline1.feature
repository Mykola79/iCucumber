Feature: login Features

  @scenarioOtline1
  Scenario Outline: Many usernames and passwords

    Given open the browser and launch HRMS applicationnn
    When user eneters valid "<username>" and "<password>"
    And user clics loginn
    Then user is loggged in successfully "Welcome Admin"
    Examples:
    |username|password|
    | admin       | Hum@nhrm123  |
    | ADMIN        |    Hum@nhrm123 |
    | Jason         | Hum@nhrm123   |

