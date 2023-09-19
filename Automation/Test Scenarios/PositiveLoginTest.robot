*** Settings ***
Resource   ../Resources/LoginKeywords.resource
Suite Teardown    Close Browser

*** Test Cases ***
Successful Login Test
    Given user is on the login page
    When user enters valid credentials
    And user clicks the login button
    Then user should be on the dashboard  