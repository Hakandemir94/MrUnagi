*** Settings ***
Library    SeleniumLibrary
Library    Collections
Resource     ../Resources/ProductPageKeywords.resource

*** Test Cases ***
Sort Products by Name(A to Z)
    [Tags]    ProductSort
    Given user successfully logged in
    When user clicks dropdown menu
    And user clicks on    Name(A to Z)
    Then products should be sorted according to    Name(A to Z)

Sort products by Name(Z to A)
    [Tags]    ProductSort
    Given user successfully logged in
    When user clicks dropdown menu
    And user clicks on    Name(Z to A)
    Then products should be sorted according to    Name(Z to A)