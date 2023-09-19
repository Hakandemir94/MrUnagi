*** Settings ***
Documentation   Keywords for sorting products by price
Library         SeleniumLibrary
Resource   ../Resources/LoginKeywords.resource

*** Variables ***
${SortByNameAtoZ}    //option[@value='az']
${SortByNameZtoA}    //option[@value='za']

*** Keywords ***
user successfully logged in
    user is logged in and on the dashboard

User Clicks Dropdown Menu
    Click Element    //select[@class='product_sort_container']

user clicks on
    [Arguments]    ${string}
    ${sort_method}    Get Text    ${SortByNameAtoZ}
    Run Keyword If    $string == 'Name(A to Z)'
    ...    Click Element    ${SortByNameAtoZ}
    ...  ELSE IF    $string == 'Name(Z to A)'
    ...    Click Element    ${SortByNameZtoA}
    ...  ELSE
    ...    Fail    Sorting method doesn't exist

products should be sorted according to
    [Arguments]    ${string}
    ${item_names}    Get WebElements    xpath=//div[@class='inventory_item_name']
    ${item_names_list}    Create List
    ${sorted_names_list}    Create List
    FOR    ${item_name}    IN    @{item_names}
        ${text}    Get Text    ${item_name}
        Append To List    ${item_names_list}    ${text}
    END
    @{sorted_names_list}=    Copy List    ${item_names_list}
    Run Keyword If    $string == 'Name(A to Z)'    Sort List    ${sorted_names_list}
    Run Keyword If    $string == 'Name(Z to A)'    
    ...  Run Keywords
    ...    Sort List    ${sorted_names_list}
    ...    AND    Reverse List    ${sorted_names_list}
    Lists Should Be Equal    ${sorted_names_list}    ${item_names_list}
    