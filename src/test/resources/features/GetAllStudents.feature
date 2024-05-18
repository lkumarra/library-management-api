@getAllStudents @students
Feature: Verify Get All Students API
  I want to told to verify /getAllStudents API.

  @positiveScenario
  Scenario: Fetch all students with valid user.
    Given I am a valid user
    When I get all students
    Then Response should returned with status code 'OK'.
    And Verify the response from Db.

    
