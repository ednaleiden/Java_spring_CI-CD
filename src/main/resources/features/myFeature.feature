Feature: Employee Management

  Scenario: Request all employees
    When I request all employees
    Then I should receive a list of employees
