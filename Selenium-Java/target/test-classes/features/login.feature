Feature: AutomationExercise login test cases
	
  Scenario: Login with valid inputs
    Given User navigates to Automationexercise website
    And User clicks on Signup / Login button
    And User enters a valid username: "demirhakan94@gmail.com"
    And User enters a valid password: "p12345678"
    When User clicks Login button
    Then Login should be successfull
	
  Scenario: Login with invalid inputs 
  	Given User navigates to Automationexercise website
    And User clicks on Signup / Login button
    And User enters a valid username: "demihakan94@gmail.com"
    And User enters a valid password: "12345678"
    When User clicks Login button
    But Login should fail