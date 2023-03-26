@getAllStudents @students
Feature: Verify Get All Students API
  I want to told to verify /getAllStudents API.

  @positiveScenario
  Scenario: Fetch all students with valid user.
    Given I am a valid user
    When I get all students
    Then Response should returned with status code 'OK'.
    And Verify the response from Db.

  @negativeScenario, @insufficientPermission
  Scenario: Try to fetch all students with user with insufficient role.
    Given I am a valid user with insufficient permissions
    When I try to get all students
    Then Response should returned with status code 'FORBIDDEN', error as 'Forbidden' and message as "Forbidden".

  @negativeScenario @invalidUser
  Scenario: Try to fetch all students with invalid user.
    Given I am a invalid user
    When I try to get all students
    Then Response should returned with status code 'UNAUTHORIZED'.

    
