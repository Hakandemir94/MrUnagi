
Feature: AutomationExercise add to users cart test cases

  Scenario Outline: Add an item to cart
    Given User navigates to Automationexercise website
    And User clicks on Signup / Login button
    And User enters valid "<username>" and "<password>"
    And User clicks Login button
    And User click on Products button
    And User searches for a "<item>"
    When User hovers over Add To Cart button
    And User clicks on Add To Cart button on the dropped layout
    Then Confirmation message should pop-up

    Examples: 
      |username|password|top|
      |demirhakan94@gmail.com|p12345678| blue top |
			